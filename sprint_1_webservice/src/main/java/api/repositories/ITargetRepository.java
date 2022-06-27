package api.repositories;

import api.models.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITargetRepository extends JpaRepository<Target,Long> {

    @Query(value = "select * from target ", nativeQuery = true)
    List<Target> getAllTarget();
}
