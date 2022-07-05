package api.services.impl;

import api.dto.ExtraInforDto;
<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/impl/GuestServiceImpl.java
import api.dto.GuestInterfaceDTO;
import api.dto.IGuestDto;
=======

import api.dto.Top100Dto;

>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/impl/GuestServiceImpl.java
import api.models.Guest;
import api.repositories.IGuestRepository;
import api.services.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/impl/GuestServiceImpl.java
=======

>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/impl/GuestServiceImpl.java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/impl/GuestServiceImpl.java
    /**
     * Created by TuanPD
     * ROLE: ADMIN
     * Time: 13:00 27/07/2022
     * Function: getAllMember = Select All by Member
     * Class:
     **/
    @Override
    public Page<IGuestDto> getAllMember(Pageable pageable) {
        return iGuestRepository.getAllMember(pageable);
    }

    @Override
    public Page<IGuestDto> getSearchName(String nameMember, Pageable pageable) {
        return iGuestRepository.getSearchName(nameMember, pageable);
    }

    @Override
    public Page<IGuestDto> getVipMember(Pageable pageable) {
        return iGuestRepository.getVipMember(pageable);
    }

    @Override
    public Page<IGuestDto> getNormalMember(Pageable pageable) {
        return iGuestRepository.getNormalMember(pageable);
    }

    @Override
    public List<GuestInterfaceDTO> findGuestByKey(String keyName, String keyGender, String keyCareer, String keyAddress, String keyYearOfBirth, String keyFavorite) {
        return iGuestRepository.getPageGuest(keyName, keyGender, keyCareer, keyAddress, keyYearOfBirth, keyFavorite);
    }

    @Override
    public Page<GuestInterfaceDTO> findGuestByName(Pageable pageable, String keyName) {
        return iGuestRepository.getPageGuestName(pageable, keyName);
    }
=======

    @Override
    public Page<Top100Dto> viewTop100(Pageable pageable) {
        return iGuestRepository.viewTop100(pageable);
    }

>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/impl/GuestServiceImpl.java
}
