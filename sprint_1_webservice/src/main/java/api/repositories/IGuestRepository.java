package api.repositories;

import api.dto.ExtraInforDto;
import api.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IGuestRepository extends JpaRepository<Guest, Long> {

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: create = create Person
        Class:
    */
    @Transactional
    @Modifying
    @Query(value = "insert into guest (name, address, career, date_of_birth, create_date, email, gender, delete_flag, account_id) values " +
            "(:#{#guest.name},:#{#guest.address},:#{#guest.career},:#{#guest.dateOfBirth},:#{#guest.createDate},:#{#guest.email},:#{#guest.gender}, " +
            ":#{#guest.deleteFlag}, :#{#guest.account.id}) ", nativeQuery = true)
    void create(Guest guest);

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: findPersonById = find Person by id
        Class:
    */
    @Query(value = "select * from guest where delete_flag = 0 and id = :id ", nativeQuery = true)
    Guest findGuestById(@Param("id")Long id);

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: updatePersonById = update Person by id and data
        Class:
    */
    @Transactional
    @Modifying
    @Query(value = "update guest " +
            "set image = :#{#extraInforDto.image}, marital_status = :#{#extraInforDto.maritalStatus} " +
            "where delete_flag = 0 and id = :id ", nativeQuery = true)
    void updateGuestById(@Param("id") Long id, ExtraInforDto extraInforDto);

    /*
        Created by khoaVC
        Role: GUEST
        Time: 23:00 15/06/2022
        Function: getPersonByUserName = find Person by userName
        Class:
    */
    @Query(value = "select * from guest inner join account on guest.account_id = account.id " +
            "where delete_flag = 0 and user_name = :userName ", nativeQuery = true)
    Guest getGuestByUserName(@Param("userName") String userName);

    /*
        Created by khoaVC
        Role: GUEST
        Time: 09:40 16/06/2022
        Function: getPersonByEmail = find Person by email
        Class:
    */
    @Query(value = "select * from guest where delete_flag = 0 and email = :email ", nativeQuery = true)
    Guest getGuestByEmail(String email);
}