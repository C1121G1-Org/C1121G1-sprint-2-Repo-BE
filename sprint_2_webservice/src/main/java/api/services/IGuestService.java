package api.services;

import api.dto.ExtraInforDto;
<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/IGuestService.java
import api.dto.GuestInterfaceDTO;
import api.dto.IGuestDto;
=======

import api.dto.Top100Dto;
>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/IGuestService.java
import api.models.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/IGuestService.java
=======

>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/IGuestService.java

public interface IGuestService {

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: create = create Person
        Class:
    */
    void create(Guest guest);

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 09:40 16/06/2022
        Function: findPersonById = find Person by id
        Class:
    */
    Guest findGuestById(Long id);
    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: updatePersonById = update Person by id and data
        Class:
    */
    void updateGuestById(Long id, ExtraInforDto extraInforDto);

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: getPersonByUserName = find Person by userName
        Class:
    */
    Guest getGuestByUserName(String userName);

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: getPersonByEmail = find Person by email
        Class:
    */
    Guest getGuestByEmail(String email);

<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/IGuestService.java
    /**
     Created by TuanPD
     ROLE: ADMIN
     Time: 13:00 27/07/2022
     Function: getAllMember = Select All by Member
     Class:
     **/
    Page<IGuestDto> getAllMember(Pageable pageable);

    Page<IGuestDto> getSearchName(String nameMember, Pageable pageable);

    Page<IGuestDto> getVipMember(Pageable pageable);

    Page<IGuestDto> getNormalMember(Pageable pageable);

    List<GuestInterfaceDTO> findGuestByKey(String keyName, String keyGender, String keyCareer, String keyAddress, String keyYearOfBirth, String keyFavorite);

    Page<GuestInterfaceDTO> findGuestByName(Pageable pageable, String keyName);
=======
    Page<Top100Dto> viewTop100(Pageable pageable);
>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/IGuestService.java

}
