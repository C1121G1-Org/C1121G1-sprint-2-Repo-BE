package api.repositories;

import api.models.Comment;
import api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


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

    /*
    Created by HauPV
    Time: 09:00 30/06/2022
*/

    @Query(value = " SELECT * FROM `sprint-2-db`.post where guest_id = :#{#guestId} and privacy = 'Công khai'", nativeQuery = true)
    List<Post> findAllGuestPost(Long guestId);

}
