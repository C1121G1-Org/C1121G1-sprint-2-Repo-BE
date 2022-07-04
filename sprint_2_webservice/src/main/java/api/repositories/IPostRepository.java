package api.repositories;

import api.models.Comment;
import api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
    Created by HauPV
    Time: 09:00 30/06/2022
*/
public interface IPostRepository extends JpaRepository<Post, Long> {

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: find post by id;
    Class:
*/
    @Query(value = "select * from `post` where `id`=:id", nativeQuery = true)
    Post findPostById1(@Param("id")Long id);


    @Query(value = " SELECT * FROM `sprint-2-db`.post where guest_id = :#{#guestId} ;",
            nativeQuery = true)
    List<Post> findAllGuestPost(Long guestId);
}
