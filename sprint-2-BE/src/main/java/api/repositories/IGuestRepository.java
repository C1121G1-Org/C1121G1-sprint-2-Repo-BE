package api.repositories;

import api.dto.ExtraInforDto;
import api.dto.IGuestDto;
import api.models.Guest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
