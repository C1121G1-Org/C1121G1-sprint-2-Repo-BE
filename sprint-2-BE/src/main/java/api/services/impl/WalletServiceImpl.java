package api.services.impl;

import api.models.Wallet;
import api.repositories.IWalletRepository;
import api.services.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements IWalletService {
    @Autowired
    IWalletRepository iWalletRepository;

    @Override
    public void chargeMoney(Double value, Long id) {
        iWalletRepository.chargeMoney(value, id);
    }

    @Override
    public Wallet findById(Long id) {
         return iWalletRepository.findById(id).orElse(null);
    }
}
