package api.repositories;

import api.models.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGiftRepository extends JpaRepository<Gift, Long> {
}
