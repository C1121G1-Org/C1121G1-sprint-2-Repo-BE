package api.services.impl;

import api.repositories.IFriendRepository;
import api.services.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements IFriendService {
    @Autowired
    IFriendRepository iFriendRepository;
}
