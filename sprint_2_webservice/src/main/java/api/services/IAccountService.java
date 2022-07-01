package api.services;

import api.dto.UpdateGuestAndAccount;
import api.models.Account;

public interface IAccountService {

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: create = create Account
        Class:
    */
    void create(Account account);

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: findAccountByUserName = find Account By UserName
        Class:
    */
    Account getAccountByUserName(String userName);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 16:11 23/06/2022
        Function: update isLogin by guest;
        Class:
    */
    void updateAccountByIsLogin(Account account,Long id);

    /*
        Created by hoangDH
        Role: Admin,member
        Time: 16:11 23/06/2022
        Function: find Account by id = find account by id
        Class:
    */
    Account findAccountById(Long id);

    /*
        Created by hoangDH
        Role: Admin,member
        Time: 16:11 23/06/2022
        Function: get guest and account by id
        Class:
    */
    UpdateGuestAndAccount getGuestAndAccount(Long id);
}
