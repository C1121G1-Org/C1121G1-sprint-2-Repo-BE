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

    /*
      Created by TamHT
      Role: Acount
      Time: 20:00 30/06/2022
      Class:
  */
    @Override
    public void changePassword(String encryptPassword, Long accountId) {
        iAccountRepository.changPassword(encryptPassword, accountId);
    }
}
