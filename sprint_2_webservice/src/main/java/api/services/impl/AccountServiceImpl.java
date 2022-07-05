package api.services.impl;

import api.models.Account;
import api.repositories.IAccountRepository;
import api.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository iAccountRepository;

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: create = create Account
        Class:
    */
    @Override
    public void create(Account account) {
        iAccountRepository.create(account);
    }

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: findAccountByUserName = find Account By UserName
        Class:
    */
    @Override
    public Account getAccountByUserName(String userName) {
        return iAccountRepository.getAccountByUserName(userName);
    }


    @Override
    public void getActionAccount(String dateBan, Long idPost) {
        iAccountRepository.actionBanAccount(dateBan,idPost);
    }


}
