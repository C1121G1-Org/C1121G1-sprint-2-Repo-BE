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

    /*
           Created by KhaiTT
           Date: 22:40 31/05/2022
           Function: This changePassword() method change account password.
       */
    void changePassword(String encryptPassword, Long accountId);
}
