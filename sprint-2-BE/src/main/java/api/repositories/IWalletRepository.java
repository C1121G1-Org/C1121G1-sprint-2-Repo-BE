package api.repositories;

import api.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IWalletRepository extends JpaRepository<Wallet, Long> {
    @Transactional
    @Modifying
    @Query(value = "update wallet as w \n" +
            "    set w.value = w.value + ?1 \n " +
            "where guest_id =?2", nativeQuery = true)
    void chargeMoney (@Param(value = "value") Double value, @Param(value = "guest_id") Long id);
}
