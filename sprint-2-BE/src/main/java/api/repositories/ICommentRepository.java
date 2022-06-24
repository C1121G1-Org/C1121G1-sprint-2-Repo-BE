package api.repositories;

import api.models.Comment;
import api.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: create comment;
        Class:
    */
    @Query(value = "insert into `comment` (`comment_content`,`time`,`guest_id`,`post_id`)" +
            "values (:#{#comment.commentContent},:#{#comment.time},:#{#comment.guest},:#{#comment.post})", nativeQuery = true)
    void createComment(Comment comment);

    /*
        Created by hoangDH

        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: create comment;
        Class:
    */
    @Query(value = "select `id`,`comment_content`,`time`,`guest_id`,`post_id` from `comment` where `post_id`=:id", nativeQuery = true)
    List<Comment> listCommentByGuestId(@Param("id")Long id);
}
