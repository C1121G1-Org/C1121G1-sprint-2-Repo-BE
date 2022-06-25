package api.services.impl;

import api.models.Friend;
import api.models.GuestFriend;
import api.repositories.IFriendRepository;
import api.services.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements IFriendService {
    @Autowired
    IFriendRepository iFriendRepository;


}
