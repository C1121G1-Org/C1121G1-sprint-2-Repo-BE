package api.services;

import api.models.Account;
import api.models.Guest;

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
    void updateAccountByIsLogin(Guest guest,Boolean isLogin);
}
