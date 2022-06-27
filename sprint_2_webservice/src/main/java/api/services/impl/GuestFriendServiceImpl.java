package api.services.impl;


import api.models.Friend;
import api.models.Guest;
import api.models.GuestFriend;
import api.repositories.IFriendRepository;
import api.repositories.IGuestFriendRepository;
import api.repositories.IGuestRepository;

import api.services.IGuestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
