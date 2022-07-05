package api.controllers;

import api.models.ResponseObject;
import api.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//Role: User, Admin
@RestController
@CrossOrigin("*")
@RequestMapping("/api/comment")
public class CommentRestController {
    @Autowired
    ICommentService iCommentService;


    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createComment(){
        return null;
    }


    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listComment(){
        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateComment(@PathVariable String id){
        return null;
    }


    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deleteComment(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
