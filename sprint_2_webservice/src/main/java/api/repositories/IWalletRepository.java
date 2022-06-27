package api.repositories;

import api.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository extends JpaRepository<Wallet, Long> {
}
