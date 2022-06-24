package api.services;

import api.models.Friend;
import api.models.Guest;
import api.models.GuestFriend;

public interface IGuestFriendService {
    Friend findFriendById(Long id);

    Guest findGuestById(Long id);

    void save(GuestFriend guestFriend);

    GuestFriend findGuestFriendById(Long id);
}
