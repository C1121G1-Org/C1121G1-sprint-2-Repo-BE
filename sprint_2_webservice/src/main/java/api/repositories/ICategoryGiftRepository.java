package api.repositories;

import api.models.CategoryGift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryGiftRepository extends JpaRepository<CategoryGift, Long> {
    @Query(value = "select * from category_gift", nativeQuery = true)
    List<CategoryGift> getAllCategory();
}
