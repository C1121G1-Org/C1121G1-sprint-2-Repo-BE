package api.services;

import api.dto.ExtraInforDto;

import api.dto.Top100Dto;
import api.models.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/IGuestService.java
import java.util.List;
=======
>>>>>>> e209a6f63f900b1dde0ac30eb40929a4d8730560:sprint_2_webservice/src/main/java/api/services/IGuestService.java

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

    /*
      Created by khoaVC
      Role: GUEST
      Time: 23:00 15/06/2022
      Function: getPersonByEmail = find Person by email
      Class:
  */
    public void update(Guest guest);

=======
>>>>>>> e209a6f63f900b1dde0ac30eb40929a4d8730560:sprint_2_webservice/src/main/java/api/services/IGuestService.java
    Page<Top100Dto> viewTop100(Pageable pageable);

}
