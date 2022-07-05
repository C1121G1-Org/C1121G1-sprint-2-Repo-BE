package api.services.impl;

import api.dto.UpdateGuestAndAccount;
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


    /*
        Created by hoangDH
        Role: Admin, member
        Time: 16:11 23/06/2022
        Function: update isLogin by guest;
        Class:
    */
    @Override
    public void updateAccountByIsLogin(Account account, Long id) {
        iAccountRepository.updateAccountByIsLogin(account,id);
    }

    /*
        Created by hoangDH
        Role: Admin,member
        Time: 16:11 23/06/2022
        Function: find Account by id = find account by id
        Class:
    */
    @Override
    public Account findAccountById(Long id) {
        return iAccountRepository.findAccountById(id);
    }

    /*
        Created by hoangDH
        Role: Admin,member
        Time: 16:11 23/06/2022
        Function: get guest and account by id
        Class:
    */
    @Override
    public UpdateGuestAndAccount getGuestAndAccount(Long id){
        return iAccountRepository.getGuestAndAccount(id);
    };

}
