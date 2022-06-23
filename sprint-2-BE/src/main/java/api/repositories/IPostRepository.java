package api.repositories;

import api.dto.IPostDto;
import api.dto.PostDto;
import api.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IPostRepository extends JpaRepository<Post, Long> {

    @Transactional
    @Query(value = "select post.id, post.content, post.image, post.post_date as postDate, post.privacy, post.feeling, post.guest_id as guestDto, count(like_post.guest_id) as totalLike from post " +
            "inner join like_post on post.id = like_post.post_id " +
            "where like_post_flag =1  and post.guest_id = :guestId or post.guest_id in ( select friend_id from guest_friend where guest_id = :guestId) " +
            "group by like_post.post_id " +
            "Order by post_date desc ",
            countQuery = "select post.id, post.content, post.image, post.post_date as postDate, post.privacy, post.feeling, post.guest_id as guestDto, count(like_post.guest_id) as totalLike from post " +
                    "inner join like_post on post.id = like_post.post_id " +
                    "where like_post_flag =1  and post.guest_id = :guestId or post.guest_id in ( select friend_id from guest_friend where guest_id = :guestId) " +
                    "group by like_post.post_id " +
                    "Order by post_date desc ",
            nativeQuery = true)
    Page<IPostDto> findAllPosts(Pageable pageable, Long guestId);
}
