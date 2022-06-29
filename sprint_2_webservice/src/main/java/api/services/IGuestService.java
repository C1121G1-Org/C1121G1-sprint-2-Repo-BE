package api.services;

import api.dto.ExtraInforDto;
//import api.dto.Top100Dto;
import api.dto.Top100Dto;
import api.models.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


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

    Page<Top100Dto> viewTop100(Pageable pageable);

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 16:11 23/06/2022
    Function: update isLogin by guest;
    Class:
*/
    void updateAccountByIsLogin(Guest guest,Boolean is_login);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 16:11 23/06/2022
        Function: update img by guest;
        Class:
    */
    void updateGuestByImage(Guest guest,Long id);


}