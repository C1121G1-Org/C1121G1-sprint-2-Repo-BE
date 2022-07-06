package api.repositories;

import api.dto.IPostDto;
import api.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            "values (:#{#post.image}, now(), :#{#post.privacy}, :#{#post.feeling}, :#{#post.content}, :#{#post.guest.id})",
    nativeQuery = true)
    void createPost(Post post);

    /*
    Created by HauPV
    Time: 09:00 30/06/2022
*/

    @Query(value = " SELECT * FROM `sprint-2-db`.post where guest_id = :#{#guestId} and privacy = 'Công khai'", nativeQuery = true)
    List<Post> findAllGuestPost(Long guestId);

    @Transactional
    @Query(value = "select post.id, post.content, post.image, post.post_date as postDate, post.privacy, post.feeling, post.guest_id as guestId, guest.name,guest.image as imageGuest, count(like_post.guest_id) as totalLike from post " +
            "inner join like_post on post.id = like_post.post_id " +
            "inner join guest on post.guest_id = guest.id " +
            "where like_post_flag =1  and post.guest_id = :guestId or post.guest_id in ( select friend_id from guest_friend where guest_id = :guestId) " +
            "group by like_post.post_id " +
            "Order by post_date desc ",
            countQuery = "select post.id, post.content, post.image, post.post_date as postDate, post.privacy, post.feeling, post.guest_id as guestId,guest.name,guest.image as imageGuest, count(like_post.guest_id) as totalLike from post " +
                    "inner join like_post on post.id = like_post.post_id " +
                    "inner join guest on post.guest_id = guest.id " +
                    "where like_post_flag =1  and post.guest_id = :guestId or post.guest_id in ( select friend_id from guest_friend where guest_id = :guestId) " +
                    "group by like_post.post_id " +
                    "Order by post_date desc ",
            nativeQuery = true)
    Page<IPostDto> findAllPosts(Pageable pageable, Long guestId);

}
