package api.repositories;

import api.models.Gift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IGiftRepository extends JpaRepository<Gift, Long> {
    @Query(value = "select id , name , amount_coin, category_id , guest_id from gift" , nativeQuery = true)
    Page<Gift> getAllGift(Pageable pageable);
}
