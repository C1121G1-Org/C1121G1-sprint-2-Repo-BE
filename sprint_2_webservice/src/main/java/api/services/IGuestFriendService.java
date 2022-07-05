package api.services;

import api.models.Friend;
import api.models.Guest;
import api.models.GuestFriend;
import api.models.Post;

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

    Guest findGuestByUsername(String username);


    List<Post> findAllGuestPost(Long guestId);

/*
    Created by ChienLV
    Time: 15:00 29/06/2022
    Function: Guest Friend Service
*/

    List<GuestFriend> findAllFriendRequests(Long id);

    List<GuestFriend> findAllFriendSuggestions(Long id);

    void acceptFriend(Long id);

    void refuseFriend(Long id);

    void removeSuggestion(Long id);

}
