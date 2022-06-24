package api.repositories;

import api.models.CategoryGift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryGiftRepository extends JpaRepository<CategoryGift, Long> {
}
