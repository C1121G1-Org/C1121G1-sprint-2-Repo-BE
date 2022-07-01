package api.services.impl;

import api.dto.ExtraInforDto;
import api.dto.Top100Dto;
import api.models.Guest;
import api.repositories.IGuestRepository;
import api.services.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Top100Dto> viewTop100() {
        return iGuestRepository.viewTop100();
    }

    /*
     Created by HT
     Role: GUEST
     Time: 09:40 30/06/2022
     Class:
 */
    @Override
    public void update(Guest guest) {
        iGuestRepository.save(guest);
    }

}
