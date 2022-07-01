package api.repositories;

import api.models.Gift;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IGiftRepository extends JpaRepository<Gift, Long> {
    @Query(value = "select id , name , amount_coin, category_id , image from gift where category_id = :categoryId ",
            countQuery = "select id , name , amount_coin, category_id , image from gift where category_id = :categoryId",nativeQuery = true)
    Page<Gift> getAllGift(Pageable pageable , @Param("categoryId") Integer categoryId);
}
