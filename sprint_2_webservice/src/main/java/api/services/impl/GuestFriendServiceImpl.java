package api.services.impl;

import api.repositories.IGuestFriendRepository;
import api.services.IGuestFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestFriendServiceImpl implements IGuestFriendService {
    @Autowired
    IGuestFriendRepository iGuestFriendRepository;
}
