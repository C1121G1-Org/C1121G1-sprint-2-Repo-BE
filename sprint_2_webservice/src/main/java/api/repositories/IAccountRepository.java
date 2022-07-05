package api.repositories;

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

}
