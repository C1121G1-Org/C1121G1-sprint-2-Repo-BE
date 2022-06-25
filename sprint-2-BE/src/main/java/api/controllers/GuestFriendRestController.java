package api.controllers;

import api.models.GuestFriend;
import api.models.ResponseObject;
import api.services.IFriendService;
import api.services.IGuestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/guest-friend")
public class GuestFriendRestController {

    @Autowired
    IGuestFriendService iGuestFriendService;

    /*
       Created by ChienLV
       Time: 20:00 25/06/2022
   */
    @GetMapping(value = "/list-friend-requests/{id}")
    public ResponseEntity<List<GuestFriend>> getListFriendRequests(@PathVariable Long id){
        List<GuestFriend> friendRequests = this.iGuestFriendService.findAllFriendRequests(id);
        if (friendRequests.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendRequests, HttpStatus.OK);
    }

    /*
       Created by ChienLV
       Time: 20:00 25/06/2022
   */
    @GetMapping(value = "/list-friend-suggestions/{id}")
    public ResponseEntity<List<GuestFriend>> getListFriendSuggestions(@PathVariable Long id){
        List<GuestFriend> friendSuggestions = this.iGuestFriendService.findAllFriendSuggestions(id);
        if (friendSuggestions.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendSuggestions, HttpStatus.OK);
    }

    /*
       Created by ChienLV
       Time: 20:00 25/06/2022
   */
    @PatchMapping(value = "/accept-friend-request/{id}")
    public ResponseEntity<Void> acceptFriend(@PathVariable Long id){
        iGuestFriendService.acceptFriend(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
       Created by ChienLV
       Time: 20:00 25/06/2022
   */
    @PatchMapping(value = "/refuse-friend-request/{id}")
    public ResponseEntity<Void> refuseFriend(@PathVariable Long id){
        iGuestFriendService.refuseFriend(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
       Created by ChienLV
       Time: 20:00 25/06/2022
   */
    @PatchMapping(value = "/remove-friend-suggestion/{id}")
    public ResponseEntity<Void> removeSuggestion(@PathVariable Long id){
        iGuestFriendService.removeSuggestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
