package api.repositories;

import api.dto.UpdateGuestAndAccount;
import api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountRepository extends JpaRepository<Account, Long> {

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: create = create Account
        Class:
    */
    @Transactional
    @Modifying
    @Query(value = "insert into account (encrypt_password, is_enabled, user_name, verification_code) values " +
            "(:#{#account.encryptPassword}, :#{#account.isEnabled}, " +
            ":#{#account.userName},:#{#account.verificationCode}) ", nativeQuery = true)
    void create(Account account);

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: findAccountByUserName = find Account By UserName
        Class:
    */
    @Query(value = "select * from account where user_name = :userName ", nativeQuery = true)
    Account getAccountByUserName(@Param("userName") String userName);


    @Query(value ="UPDATE `account`\n" +
            "    JOIN\n" +
            "    guest ON guest.account_id = account.id\n" +
            "            SET\n" +
            "    account.is_enabled = 0,\n" +
            "    account.date_ban = ?1\n" +
            "    WHERE\n" +
            "    guest.id = (SELECT\n" +
            "    guest.id AS idGuest\n" +
            "    FROM\n" +
            "            (SELECT\n" +
            "                     post.id AS postId,\n" +
            "             guest.`name` AS guestName,\n" +
            "             post_report.date_report AS dateReport,\n" +
            "             report.name AS reportName,\n" +
            "             post_report.people_report_id AS reportedPeople\n" +
            "                     FROM\n" +
            "                     report\n" +
            "                     JOIN post_report ON post_report.report_id = report.id\n" +
            "                     JOIN post ON post_report.post_id = post.id\n" +
            "                     JOIN guest ON post.guest_id = guest.id) AS temp\n" +
            "    INNER JOIN\n" +
            "    guest ON guest.id = temp.reportedPeople\n" +
            "            WHERE\n" +
            "    postId = ?2) ", nativeQuery = true)
    void actionBanAccount(String dateBan, Long idPost);



    /*
        Created by hoangDH
        Role: Admin,member
        Time: 16:11 23/06/2022
        Function: find Account by id = find account by id
        Class:
    */
    @Query(value = "select * from `account` where id = :id ", nativeQuery = true)
    Account findAccountById(@Param("id")Long id);

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 16:11 23/06/2022
    Function: update isLogin by id;
    Class:
    */
    @Transactional
    @Modifying
    @Query(value="update `account` set `is_login`=:#{#account.isLogin} where `id`=:id", nativeQuery = true)
    void updateAccountByIsLogin(Account account,@Param("id")Long id);

    /*
        Created by hoangDH
        Role: Admin,member
        Time: 16:11 23/06/2022
        Function: get guest and account by id
        Class:
    */
    @Transactional
    @Query(value = "SELECT guest.image as image, account.is_login as isLogin FROM guest " +
            " join account on guest.account_id = account.id where account.id = :id ", nativeQuery = true)
    UpdateGuestAndAccount getGuestAndAccount(@Param("id") Long id);


}
