package api.services.impl;

import api.models.Account;
import api.repositories.IAccountRoleRepository;
import api.services.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements IAccountRoleService {

    @Autowired
    IAccountRoleRepository iAccountRoleRepository;

    /*
        Created by khoaVC
        Role: GUEST
        Time: 20:00 16/06/2022
        Function: create = create AccountRole
        Class:
    */
    @Override
    public void create(Account account, Long i) {
        iAccountRoleRepository.create(account, i);
    }

}
