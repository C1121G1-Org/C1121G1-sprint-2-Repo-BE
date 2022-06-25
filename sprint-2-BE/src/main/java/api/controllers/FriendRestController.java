package api.controllers;

import api.models.Friend;
import api.models.GuestFriend;
import api.models.ResponseObject;
import api.services.IFriendService;
import api.services.IGuestFriendService;
import api.services.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
