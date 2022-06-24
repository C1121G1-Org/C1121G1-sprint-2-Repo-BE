package api.controllers;

import api.models.ResponseObject;
import api.services.IGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/gift")
public class GiftRestController {
    @Autowired
    IGiftService iGiftService;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createGift(){
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> listGift(){
        return null;
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateGift(@PathVariable String id){
        return null;
    }

    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseObject> deleteGift(@PathVariable String id){
        return null;
    } //Xóa bằng cách update lại các delete_flag = 1
}
