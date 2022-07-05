package api.controllers;

import api.dto.PostDto;
import api.models.Guest;
import api.models.Post;
import api.models.ResponseObject;
import api.services.IGuestService;
import api.services.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostRestController {
    @Autowired
    IPostService iPostService;

    @Autowired
    IGuestService iGuestService;

    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createPost(@Valid @RequestBody PostDto postDto,
                                                     BindingResult bindingResult){
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!",
                    errorMap, new ArrayList()), HttpStatus.BAD_REQUEST);
        } else {
            Post post = new Post();
            BeanUtils.copyProperties(postDto, post);

            Guest guest = iGuestService.findGuestById(postDto.getGuestId());

            if (guest != null) {
                post.setGuest(guest);

                if (!postDto.getContent().trim().equals("")) {
                    post.setContent(postDto.getContent());
                }
                iPostService.createPost(post);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap,
                new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listPost() {
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deletePost(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
