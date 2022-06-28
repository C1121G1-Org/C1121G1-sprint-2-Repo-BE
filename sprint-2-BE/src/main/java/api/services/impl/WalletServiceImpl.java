package api.services.impl;

import api.repositories.IWalletRepository;
import api.services.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements IWalletService {
    @Autowired
    IWalletRepository iWalletRepository;
}
