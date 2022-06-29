package api.controllers;

import api.models.GuestFriend;
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
     Date: 15:00 29/06/2022
     Desc: getListFriendRequests(id) => Lấy list lời mời kết bạn dựa vào id của guest khi đăng nhập vào lấy từ Angular;
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
     Date: 15:00 29/06/2022
     Desc: getListFriendSuggestions(id) => Lấy list gợi ý kết bạn dựa vào id của guest khi đăng nhập vào lấy từ Angular;
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
     Date: 15:00 29/06/2022
     Desc: acceptFriend(id) => Chấp nhận lời mời kết bạn dựa vào id của bảng guest_friend;
   */
    @GetMapping(value = "/accept-friend-request/{id}")
    public ResponseEntity<Void> acceptFriend(@PathVariable Long id){
        iGuestFriendService.acceptFriend(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by ChienLV
     Date: 15:00 29/06/2022
     Desc: refuseFriend(id) => Từ chối lời mời kết bạn dựa vào id của bảng guest_friend;
   */
    @GetMapping(value = "/refuse-friend-request/{id}")
    public ResponseEntity<Void> refuseFriend(@PathVariable Long id){
        iGuestFriendService.refuseFriend(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by ChienLV
     Date: 15:00 29/06/2022
     Desc: removeSuggestion(id) => Từ chối lời gợi ý kết bạn dựa vào id của bảng guest_friend;
   */
    @GetMapping(value = "/remove-friend-suggestion/{id}")
    public ResponseEntity<Void> removeSuggestion(@PathVariable Long id){
        iGuestFriendService.removeSuggestion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
