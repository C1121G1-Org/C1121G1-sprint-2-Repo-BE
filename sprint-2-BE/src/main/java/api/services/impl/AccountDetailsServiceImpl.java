package api.services.impl;

import api.models.Account;
import api.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
    Created by TuanPA
    Time: 10:30 23/06/2022
    Function: class AccountDetailsServiceImpl implements interface UserDetailsService to override method
              loadUserByUsername(String username), this method use interface IAccountRepository to get account
              object by username, after that use method build from class AccountDetailsImpl to tranfer account
              object to UserDetails object, if the account is not found, an exception is returned.
*/
@Service
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IAccountRepository iAccountRepository;

    /*
        Function: This loadUserByUsername() method will return a UserDetails object with the parameter username.
    */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepository.getAccountByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return AccountDetailsImpl.build(account);
    }
}
