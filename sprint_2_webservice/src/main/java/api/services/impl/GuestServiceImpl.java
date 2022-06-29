package api.services.impl;

import api.dto.ExtraInforDto;
//import api.dto.Top100Dto;
import api.dto.Top100Dto;
import api.models.Guest;
import api.repositories.IGuestRepository;
import api.services.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements IGuestService {

    @Autowired
    IGuestRepository iGuestRepository;

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: create = create Person
        Class:
    */
    @Override
    public void create(Guest guest) {
        iGuestRepository.create(guest);
    }

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: findPersonById = find Person by id
        Class:
    */
    @Override
    public Guest findGuestById(Long id) {
        return iGuestRepository.findGuestById(id);
    }

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: updatePersonById = update Person by id and data
        Class:
    */
    @Override
    public void updateGuestById(Long id, ExtraInforDto extraInforDto) {
        iGuestRepository.updateGuestById(id, extraInforDto);
    }

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: getPersonByUserName = find Person by userName
        Class:
    */
    @Override
    public Guest getGuestByUserName(String userName) {
        return iGuestRepository.getGuestByUserName(userName);
    }

    /*
        Created by khoaVC
        Role: GUEST
        Time: 09:40 16/06/2022
        Function: getPersonByEmail = find Person by email
        Class:
    */
    @Override
    public Guest getGuestByEmail(String email) {
        return iGuestRepository.getGuestByEmail(email);
    }

    @Override
    public Page<Top100Dto> viewTop100(Pageable pageable) {
        return iGuestRepository.viewTop100(pageable);
    }

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 16:11 23/06/2022
    Function: update isLogin by guest;
    Class:
    */
    @Override
    public void updateAccountByIsLogin(Guest guest, Boolean is_login){
        iGuestRepository.updateAccountByIsLogin(guest,is_login);
    };

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 16:11 23/06/2022
        Function: update img by guest;
        Class:
    */
    @Override
    public void updateGuestByImage(Guest guest,Long id){
        iGuestRepository.updateGuestByImage(guest,id);
    };

}
