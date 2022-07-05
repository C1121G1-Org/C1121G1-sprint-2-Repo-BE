package api.controllers;

import api.models.ResponseObject;
import api.services.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/friend")
public class FriendRestController {
    @Autowired
    IFriendService iFriendService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createFriend(){
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listFriend(){
        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateFriend(@PathVariable String id){
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deleteFriend(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
