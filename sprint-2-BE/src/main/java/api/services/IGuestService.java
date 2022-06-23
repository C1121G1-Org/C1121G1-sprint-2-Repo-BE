package api.services;

import api.dto.ExtraInforDto;
import api.models.Guest;

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
}
