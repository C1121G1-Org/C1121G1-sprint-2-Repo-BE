package api.repositories;

import api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
    Created by HauPV
    Time: 09:00 30/06/2022
*/
public interface IPostRepository extends JpaRepository<Post, Long> {

    @Query(value = " SELECT * FROM `sprint-2-db`.post where guest_id = :#{#guestId} ;",
            nativeQuery = true)
    List<Post> findAllGuestPost(Long guestId);
}
