package api.repositories;

import api.models.GuestFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestFavoriteRepository extends JpaRepository<GuestFavorite, Long> {
}
