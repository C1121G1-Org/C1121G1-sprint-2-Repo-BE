package api.controllers;

import api.dto.GuestFriendDto;
import api.models.Friend;
import api.models.Guest;
import api.models.GuestFriend;
import api.services.IGuestFriendService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: Profile Controller
*/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/profile", method = RequestMethod.GET)
public class ProfileRestController {

    @Autowired
    IGuestFriendService iGuestFriendService;

    @GetMapping("/friend/{id}")
    public ResponseEntity<Friend> showFriendProfile(@PathVariable Long id) {
        Friend friend = this.iGuestFriendService.findFriendById(id);
        if (friend == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(friend, HttpStatus.OK);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Guest> showPersonalProfile(@PathVariable Long id) {
        Guest guest = this.iGuestFriendService.findGuestById(id);
        if (guest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @PostMapping("/add-friend")
    public ResponseEntity<?> addFriend(@RequestBody GuestFriendDto guestFriendDto) {
        Map<String, String> errMap = new HashMap<>();

        if (guestFriendDto == null || guestFriendDto.getFriendDto() == null || guestFriendDto.getGuestDto() == null) {
            errMap.put("required", "friend and guest cannot be null");
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }

        if (iGuestFriendService.findAllGuestFriendByGuestIdAndFriendId(guestFriendDto.getGuestDto().getId(),
                guestFriendDto.getFriendDto().getId()) != null) {
            errMap.put("exist", "already your friend !");
            return new ResponseEntity<>(errMap, HttpStatus.BAD_REQUEST);
        }

        Guest guest = new Guest();
        Friend friend = new Friend();
        GuestFriend guestFriend = new GuestFriend();

        BeanUtils.copyProperties(guestFriendDto, guestFriend);
        BeanUtils.copyProperties(guestFriendDto.getGuestDto(), guest);
        BeanUtils.copyProperties(guestFriendDto.getFriendDto(), friend);

        guestFriend.setFriend(friend);
        guestFriend.setGuest(guest);
        System.out.println(guestFriend);

        this.iGuestFriendService.save(guestFriend);
        return new ResponseEntity<>(guestFriend, HttpStatus.OK);
    }

    @GetMapping("/guest-friend/{guestId}/{friendId}")
    public ResponseEntity<GuestFriend> getGetFriend(@PathVariable Long guestId, @PathVariable Long friendId) {
        GuestFriend guestFriend = this.iGuestFriendService.findAllGuestFriendByGuestIdAndFriendId(guestId, friendId);

        if (guestFriend == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(guestFriend, HttpStatus.OK);
    }

    @GetMapping("/list-friend/{id}")
    public ResponseEntity<List<Friend>> listFriend(@PathVariable Integer id) {
        List<GuestFriend> guestFriendList = this.iGuestFriendService.findAllGuestFriendByGuestId(id);
        if (guestFriendList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Friend> friends = guestFriendList.stream().map(f -> f.getFriend()).collect(Collectors.toList());
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    @DeleteMapping("/delete-friend/{id}")
    public ResponseEntity<Void> deleteFriend(@PathVariable Long id) {
        if (iGuestFriendService.findGuestFriendById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.iGuestFriendService.deleteGuestFriendById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
