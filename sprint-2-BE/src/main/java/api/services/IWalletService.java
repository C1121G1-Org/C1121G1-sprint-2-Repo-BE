package api.services;

import api.models.Wallet;

public interface IWalletService {
    void chargeMoney(Double value, Long id);
    Wallet findById(Long id);
}
