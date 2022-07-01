package api.controllers;

import api.dto.IFriendDto;
import api.models.Friend;
import api.models.ResponseObject;
import api.services.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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


    /*
        Created by HuyNH
        Time: 15:00 23/06/2022
        Function: findAllFriend = list Friend.
    */
    @GetMapping(value = {"/list/{id}"})
    public ResponseEntity<Page<IFriendDto>> findAllFriend(@PageableDefault(value = 8) Pageable pageable,
                                                          @RequestParam Optional<String> keyName,
                                                          @PathVariable Long id) {
        String nameValue = keyName.orElse("");

        Page<IFriendDto> friendPage = iFriendService.findAllFriend(pageable, nameValue, id);

        if (friendPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendPage, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateFriend(@PathVariable String id){
        return null;
    }


    /*
        Created by HuyNH
        Time: 16:00 23/06/2022
        Function: findAllFriend = delete flag friend.
    */
    @PatchMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteFriend(Optional<Friend> friend){
        if (friend.isPresent()) {
            iFriendService.saveDelete(friend.get().getId());
            return new ResponseEntity<>(friend.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
