package api.repositories;

import api.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {
    @Query(value = "select * from favorite", nativeQuery = true)
    List<Favorite> getAllFavorite();
}
