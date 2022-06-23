package api.controllers;

import api.dto.IPostDto;
import api.dto.PostDto;
import api.models.Guest;
import api.models.ResponseObject;
import api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostRestController {
    @Autowired
    IPostService iPostService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createPost() {
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<IPostDto>> listPost(@PageableDefault(value = 3) Pageable pageable, @RequestParam Long guestId) {
        Page<IPostDto> postList = iPostService.findAll(pageable, guestId);
        if (postList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updatePost(@PathVariable String id) {
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deletePost(@PathVariable String id) {
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
