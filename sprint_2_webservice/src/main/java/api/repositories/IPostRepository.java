package api.repositories;

import api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    Created by HauPV
    Time: 09:00 30/06/2022
*/
public interface IPostRepository extends JpaRepository<Post, Long> {

    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    @Transactional
    @Modifying
    @Query(value = "insert into post (`image`, `post_date`, `privacy`, `feeling`, `content`, `guest_id`) " +
            "values (:#{#post.image}, now(), ifnull(:#{#post.privacy}, 'Công khai'), :#{#post.feeling}, :#{#post.content}, :#{#post.guest.id})",
    nativeQuery = true)
    void createPost(Post post);

    @Query(value = " SELECT * FROM `sprint-2-db`.post where guest_id = :#{#guestId} ;",
            nativeQuery = true)
    List<Post> findAllGuestPost(Long guestId);

}
