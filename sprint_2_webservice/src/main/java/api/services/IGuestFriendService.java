package api.services;

import api.models.Friend;
import api.models.Guest;
import api.models.GuestFriend;

import java.util.List;

/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: Guest Friend Repository
*/
public interface IGuestFriendService {
    Friend findFriendById(Long id);

    Guest findGuestById(Long id);

    void save(GuestFriend guestFriend);

    GuestFriend findGuestFriendById(Long id);

    List<GuestFriend> findAllGuestFriendByGuestId(Integer id);

    GuestFriend findAllGuestFriendByGuestIdAndFriendId(Long guestId, Long friendId);

    void deleteGuestFriendById(Long id);
}
