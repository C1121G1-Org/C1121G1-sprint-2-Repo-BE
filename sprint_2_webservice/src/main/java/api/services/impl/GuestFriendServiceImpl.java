package api.services.impl;


import api.models.Friend;
import api.models.Guest;
import api.models.GuestFriend;
import api.models.Post;
import api.repositories.IFriendRepository;
import api.repositories.IGuestFriendRepository;
import api.repositories.IGuestRepository;

import api.repositories.IPostRepository;
import api.services.IGuestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: Guest Friend Service
*/
@Service
public class GuestFriendServiceImpl implements IGuestFriendService {
    @Autowired
    IGuestFriendRepository iGuestFriendRepository;

    @Autowired
    IFriendRepository iFriendRepository;

    @Autowired
    IGuestRepository iGuestRepository;

    @Autowired
    IPostRepository iPostRepository ;

    @Override
    public Friend findFriendById(Long id) {
        return this.iFriendRepository.findById(id).orElse(null);
    }

    @Override
    public Guest findGuestById(Long id) {
        return this.iGuestRepository.findGuestById(id);
    }

    @Override
    public void save(GuestFriend guestFriend) {
        this.iGuestFriendRepository.insertGuestFriend(guestFriend);
    }

    @Override
    public GuestFriend findGuestFriendById(Long id) {
        return this.iGuestFriendRepository.findById(id).orElse(null);
    }

    @Override
    public List<GuestFriend> findAllGuestFriendByGuestId(Integer id) {
        return this.iGuestFriendRepository.findAllGuestFriendByGuestId(id);
    }

    @Override
    public GuestFriend findAllGuestFriendByGuestIdAndFriendId(Long guestId, Long friendId) {
        return this.iGuestFriendRepository.findAllGuestFriendByGuestIdAndFriendId(guestId, friendId);
    }

    @Override
    public void deleteGuestFriendById(Long id) {
        this.iGuestFriendRepository.deleteGuestFriendById(id);
    }

    @Override
    public Guest findGuestByUsername(String username) {
        return this.iGuestRepository.findGuestByAccount_UserName(username);
    }


    @Override
    public List<Post> findAllGuestPost(Long guestId) {
        return this.iPostRepository.findAllGuestPost(guestId);
    }


    /*
        Created by ChienLV
        Time: 15:00 29/06/2022
        Function: Guest Friend Service
    */

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
