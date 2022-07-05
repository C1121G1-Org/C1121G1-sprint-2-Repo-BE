package api.repositories;

import api.dto.ExtraInforDto;
<<<<<<< HEAD:sprint-2-BE/src/main/java/api/repositories/IGuestRepository.java
import api.dto.GuestInterfaceDTO;
import api.dto.IGuestDto;
=======

import api.dto.Top100Dto;
>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/repositories/IGuestRepository.java
import api.models.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD:sprint-2-BE/src/main/java/api/repositories/IGuestRepository.java
import java.util.List;

=======

import java.util.List;


>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/repositories/IGuestRepository.java
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
    Guest findGuestById(@Param("id") Long id);

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

<<<<<<< HEAD:sprint-2-BE/src/main/java/api/repositories/IGuestRepository.java
    /*
     Created by TuanPD
     ROLE: ADMIN
     Time: 13:00 27/07/2022
     Function: getAllMember = Select All by Member
     Class:
    */
    @Query(value = "SELECT \n" +
            "    guest.id AS guestId,\n" +
            "    guest.`name` AS guestName,\n" +
            "    guest.create_date AS joinDate,\n" +
            "    wallet.coin AS walletCoin,\n" +
            "    wallet.value AS AmountRecharge,\n" +
            "    IFNULL((SELECT \n" +
            "                    COUNT(people_report_id) AS numberOfViolations\n" +
            "                FROM\n" +
            "                    post_report\n" +
            "                WHERE\n" +
            "                    post_report.report_id = guest.id),\n" +
            "            0) AS numberOfViolations\n" +
            "FROM\n" +
            "    guest\n" +
            "        JOIN\n" +
            "    wallet ON wallet.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post ON post.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post_report ON post_report.post_id = post.id\n" +
            "GROUP BY guest.id\n" +
            "ORDER BY guest.id DESC ",
            countQuery = "SELECT \n" +
                    "    guest.id AS guestId,\n" +
                    "    guest.`name` AS guestName,\n" +
                    "    guest.create_date AS joinDate,\n" +
                    "    wallet.coin AS walletCoin,\n" +
                    "    wallet.value AS AmountRecharge,\n" +
                    "    IFNULL((SELECT \n" +
                    "                    COUNT(people_report_id) AS numberOfViolations\n" +
                    "                FROM\n" +
                    "                    post_report\n" +
                    "                WHERE\n" +
                    "                    post_report.report_id = guest.id),\n" +
                    "            0) AS numberOfViolations\n" +
                    "FROM\n" +
                    "    guest\n" +
                    "        JOIN\n" +
                    "    wallet ON wallet.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post ON post.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post_report ON post_report.post_id = post.id\n" +
                    "GROUP BY guest.id\n" +
                    "ORDER BY guest.id DESC", nativeQuery = true)
    Page<IGuestDto> getAllMember(Pageable pageable);

    /*
         Created by TuanPD
         ROLE: ADMIN
         Time: 13:00 27/07/2022
         Function: getAllMember = Select All by Member
         Class:
        */
    @Query(value = "SELECT \n" +
            "    guest.id AS guestId,\n" +
            "    guest.`name` AS guestName,\n" +
            "    guest.create_date AS joinDate,\n" +
            "    wallet.coin AS walletCoin,\n" +
            "    wallet.value AS AmountRecharge,\n" +
            "    IFNULL((SELECT \n" +
            "                    COUNT(people_report_id) AS numberOfViolations\n" +
            "                FROM\n" +
            "                    post_report\n" +
            "                WHERE\n" +
            "                    post_report.report_id = guest.id),\n" +
            "            0) AS numberOfViolations\n" +
            "FROM\n" +
            "    guest\n" +
            "        JOIN\n" +
            "    wallet ON wallet.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post ON post.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post_report ON post_report.post_id = post.id\n" +
            "WHERE\n" +
            "    guest.`name` LIKE CONCAT('%', :nameMember , '%')\n" +
            "GROUP BY guest.id " +
            "ORDER BY guest.id DESC",
            countQuery = "SELECT \n" +
                    "    guest.id AS guestId,\n" +
                    "    guest.`name` AS guestName,\n" +
                    "    guest.create_date AS joinDate,\n" +
                    "    wallet.coin AS walletCoin,\n" +
                    "    wallet.value AS AmountRecharge,\n" +
                    "    IFNULL((SELECT \n" +
                    "                    COUNT(people_report_id) AS numberOfViolations\n" +
                    "                FROM\n" +
                    "                    post_report\n" +
                    "                WHERE\n" +
                    "                    post_report.report_id = guest.id),\n" +
                    "            0) AS numberOfViolations\n" +
                    "FROM\n" +
                    "    guest\n" +
                    "        JOIN\n" +
                    "    wallet ON wallet.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post ON post.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post_report ON post_report.post_id = post.id\n" +
                    "WHERE\n" +
                    "    guest.`name` LIKE CONCAT('%', :nameMember , '%')\n" +
                    "GROUP BY guest.id " +
                    "ORDER BY guest.id DESC", nativeQuery = true)
    Page<IGuestDto> getSearchName(@Param("nameMember") String nameMember, Pageable pageable);

    /*
      Created by TuanPD
      ROLE: ADMIN
      Time: 13:00 27/07/2022
      Function: getVipMember = Select vip by Member
      Class:
    */
    @Query(value = "SELECT \n" +
            "    guest.id AS guestId,\n" +
            "    guest.`name` AS guestName,\n" +
            "    guest.create_date AS joinDate,\n" +
            "    wallet.coin AS walletCoin,\n" +
            "    wallet.value AS AmountRecharge,\n" +
            "    IFNULL((SELECT \n" +
            "                    COUNT(people_report_id) AS numberOfViolations\n" +
            "                FROM\n" +
            "                    post_report\n" +
            "                WHERE\n" +
            "                    post_report.report_id = guest.id),\n" +
            "            0) AS numberOfViolations\n" +
            "FROM\n" +
            "    guest\n" +
            "        JOIN\n" +
            "    wallet ON wallet.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post ON post.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post_report ON post_report.post_id = post.id\n" +
            "WHERE\n" +
            "    wallet.value >= 300\n" +
            "GROUP BY guest.id\n" +
            "ORDER BY guest.id DESC",
            countQuery = "SELECT \n" +
                    "    guest.id AS guestId,\n" +
                    "    guest.`name` AS guestName,\n" +
                    "    guest.create_date AS joinDate,\n" +
                    "    wallet.coin AS walletCoin,\n" +
                    "    wallet.value AS AmountRecharge,\n" +
                    "    IFNULL((SELECT \n" +
                    "                    COUNT(people_report_id) AS numberOfViolations\n" +
                    "                FROM\n" +
                    "                    post_report\n" +
                    "                WHERE\n" +
                    "                    post_report.report_id = guest.id),\n" +
                    "            0) AS numberOfViolations\n" +
                    "FROM\n" +
                    "    guest\n" +
                    "        JOIN\n" +
                    "    wallet ON wallet.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post ON post.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post_report ON post_report.post_id = post.id\n" +
                    "WHERE\n" +
                    "    wallet.value >= 300\n" +
                    "GROUP BY guest.id\n" +
                    "ORDER BY guest.id DESC", nativeQuery = true)
    Page<IGuestDto> getVipMember(Pageable pageable);

    /*
          Created by TuanPD
          ROLE: ADMIN
          Time: 13:00 27/07/2022
          Function: getVipMember = Select vip by Member
          Class:
        */
    @Query(value = "SELECT \n" +
            "    guest.id AS guestId,\n" +
            "    guest.`name` AS guestName,\n" +
            "    guest.create_date AS joinDate,\n" +
            "    wallet.coin AS walletCoin,\n" +
            "    wallet.value AS AmountRecharge,\n" +
            "    IFNULL((SELECT \n" +
            "                    COUNT(people_report_id) AS numberOfViolations\n" +
            "                FROM\n" +
            "                    post_report\n" +
            "                WHERE\n" +
            "                    post_report.report_id = guest.id),\n" +
            "            0) AS numberOfViolations\n" +
            "FROM\n" +
            "    guest\n" +
            "        JOIN\n" +
            "    wallet ON wallet.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post ON post.guest_id = guest.id\n" +
            "        JOIN\n" +
            "    post_report ON post_report.post_id = post.id\n" +
            "WHERE\n" +
            "    wallet.value < 300\n" +
            "GROUP BY guest.id\n" +
            "ORDER BY guest.id DESC",
            countQuery = "SELECT \n" +
                    "    guest.id AS guestId,\n" +
                    "    guest.`name` AS guestName,\n" +
                    "    guest.create_date AS joinDate,\n" +
                    "    wallet.coin AS walletCoin,\n" +
                    "    wallet.value AS AmountRecharge,\n" +
                    "    IFNULL((SELECT \n" +
                    "                    COUNT(people_report_id) AS numberOfViolations\n" +
                    "                FROM\n" +
                    "                    post_report\n" +
                    "                WHERE\n" +
                    "                    post_report.report_id = guest.id),\n" +
                    "            0) AS numberOfViolations\n" +
                    "FROM\n" +
                    "    guest\n" +
                    "        JOIN\n" +
                    "    wallet ON wallet.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post ON post.guest_id = guest.id\n" +
                    "        JOIN\n" +
                    "    post_report ON post_report.post_id = post.id\n" +
                    "WHERE\n" +
                    "    wallet.value < 300\n" +
                    "GROUP BY guest.id\n" +
                    "ORDER BY guest.id DESC", nativeQuery = true)
    Page<IGuestDto> getNormalMember(Pageable pageable);

    /*
    Created by khoaPTD
    Role: N/A
    Time: 09:40 16/06/2022
    Function: getPageGuest = find Person by Key word
    Class:
    */
    @Query(value = "SELECT guest.id ,guest.image, guest.address , guest.name , guest.gender ,guest.career , guest.date_of_birth as dateOfBirth , guest_favorite.id as id_guest_fatorite , favorite.id as id_fatorite " +
            "from guest " +
            "join guest_favorite on guest.id = guest_favorite.guest_id " +
            "join  favorite on favorite.id  = guest_favorite.id " +
            "where`guest`.delete_flag = 0 and " +
            " guest_favorite.guest_id in " +
            "(select guest_favorite.guest_id from guest_favorite where favorite_id = :keyFavorite) " +
            "or`guest`.name like concat('%',:keyName)" +
            "or `guest`.date_of_birth like concat(:keyYearOfBirth,'%')" +
            "or`guest`.gender like :keyGender " +
            "or  `guest`.address like  concat('%',:keyAddress)" +
            " or `guest`.`career` like concat('%',:keyCareer,'%')",
            countQuery = "SELECT count(*) " +
                    "from guest " +
                    "join guest_favorite on guest.id = guest_favorite.guest_id" +
                    "join  favorite on favorite.id  = guest_favorite.id  " +
                    "where`guest`.delete_flag = 0 and " +
                    " guest_favorite.guest_id  " +
                    "in " +
                    "(select guest_favorite.guest_id from guest_favorite where favorite_id = :keyFavorite) " +
                    "or`guest`.name like concat(:keyName,'%')" +
                    "or `guest`.date_of_birth like concat(:keyYearOfBirth,'%')" +
                    "or`guest`.gender like :keyGender " +
                    "or  `guest`.address like  concat('%',:keyAddress)" +
                    " or `guest`.`career` like concat('%',:keyCareer,'%')", nativeQuery = true)
    List<GuestInterfaceDTO> getPageGuest(@Param("keyName") String keyName, @Param("keyGender") String keyGender, @Param("keyCareer") String keyCareer, @Param("keyAddress") String keyAddress, @Param("keyYearOfBirth") String keyYearOfBirth, @Param("keyFavorite") String keyFavorite);


    /*
           Created by hiếuMMT
           Role: N/A
           Time: 09:40 16/06/2022
           Function: getPageGuest = find Person by KeyName
           Class:
    */
    @Query(value = "SELECT * FROM `sprint-2-db`.guest where guest.`name` like concat('%',:keyName,'%') and `guest`.delete_flag = 0", nativeQuery = true)
    Page<GuestInterfaceDTO> getPageGuestName(Pageable pageable, String keyName);


=======
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
>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/repositories/IGuestRepository.java
}
