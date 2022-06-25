package api.services;

import api.models.GuestFriend;

import java.util.List;

public interface IGuestFriendService {
    List<GuestFriend> findAllFriendRequests(Long id);

    List<GuestFriend> findAllFriendSuggestions(Long id);

    void acceptFriend(Long id);

    void refuseFriend(Long id);

    void removeSuggestion(Long id);
}
