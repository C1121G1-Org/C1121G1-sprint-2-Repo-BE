package api.repositories;

import api.dto.ExtraInforDto;

import api.dto.Top100Dto;
import api.models.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


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
    @Query(value = "insert into guest (address, career, date_of_birth, email, gender, delete_flag, account_id) values " +
            "(:#{#guest.address},:#{#guest.career},:#{#guest.dateOfBirth},:#{#guest.email},:#{#guest.gender}, " +
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

    @Query(value = " select g.id,g.name,g.image,w.value,count(l.like_post_flag) as totalLike\n" +
            "from guest as g, post as p, like_post as l, wallet as w\n" +
            "where (g.id = p.guest_id) and (p.id = l.post_id) and (g.id = w.guest_id)\n" +
            "group by g.id "
            , nativeQuery = true)
    Page<Top100Dto> viewTop100 (Pageable pageable);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 16:11 23/06/2022
        Function: update isLogin by guest;
        Class:
    */
    @Query(value="update `account` set `is_login`=:is_login where (`id`=:#{#guest.account.id})", nativeQuery = true)
    void updateAccountByIsLogin(Guest guest,@Param("is_login")Boolean is_login);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 16:11 23/06/2022
        Function: update img by guest;
        Class:
    */
    @Query(value="update `guest` set `image`=:#{#guest.image} where (`id`=:id)", nativeQuery = true)
    void updateGuestByImage(Guest guest,@Param("id")Long id);

    /*
        Created by HauPV
        Role: Admin, member
        Time: 14:00 29/06/2022
    */
//    @Query(value = "SELECT guest.id , address , career , date_of_birth , delete_flag , email , gender , image , marital_status , name , account_id , create_date FROM guest " +
//            "join account on guest.account_id = account.id " +
//            "where account.user_name = :'#{#username} ;",
//            nativeQuery = true)
    Guest findGuestByAccount_UserName(String username);
}
