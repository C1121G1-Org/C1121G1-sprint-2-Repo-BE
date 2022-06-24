package api.services.impl;

import api.repositories.IGuestTargetRepository;
import api.services.IGuestTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestTargetServiceImpl implements IGuestTargetService {

    @Autowired
    IGuestTargetRepository iGuestTargetRepository;

/*
    Created by khoaVC
    Role: MEMBER
    Time: 23:00 15/06/2022
    Function: create = create record for target list
    Class:
*/
    @Override
    public void create(Long id, Integer i) {
        iGuestTargetRepository.create(id,i);
    }
}
