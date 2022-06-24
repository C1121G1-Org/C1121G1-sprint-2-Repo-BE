package api.repositories;

import api.models.AccountRole;
import api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Long> {

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: create = create AccountRole
        Class:
    */
    @Transactional
    @Modifying
    @Query(value = "insert into account_role (account_id, role_id) values " +
            "(:#{#account.id}, :i) ", nativeQuery = true)
    void create(Account account, @Param("i") Long i);
}
