package api.services;

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

    void getActionAccount(String dateBan, Long idPost);

}
