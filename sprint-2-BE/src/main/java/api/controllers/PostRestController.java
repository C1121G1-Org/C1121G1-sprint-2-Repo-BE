package api.controllers;

import api.models.ResponseObject;
import api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostRestController {
    @Autowired
    IPostService iPostService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createPost(){
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listPost(){

        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updatePost(@PathVariable String id){
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deletePost(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
