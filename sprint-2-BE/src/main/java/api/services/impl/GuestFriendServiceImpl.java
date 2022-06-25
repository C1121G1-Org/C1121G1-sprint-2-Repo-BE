package api.services.impl;

import api.models.GuestFriend;
import api.repositories.IGuestFriendRepository;
import api.services.IGuestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestFriendServiceImpl implements IGuestFriendService {
    @Autowired
    IGuestFriendRepository iGuestFriendRepository;

    @Override
    public List<GuestFriend> findAllFriendRequests(Long id) {
        return iGuestFriendRepository.findAllFriendRequests(id);
    }

    @Override
    public List<GuestFriend> findAllFriendSuggestions(Long id) {
        return iGuestFriendRepository.findAllFriendSuggestions(id);
    }

    @Override
    public void acceptFriend(Long id) {
        iGuestFriendRepository.acceptFriend(id);
    }

    @Override
    public void refuseFriend(Long id) {
        iGuestFriendRepository.refuseFriend(id);
    }

    @Override
    public void removeSuggestion(Long id) {
        iGuestFriendRepository.removeSuggestion(id);
    }
}
