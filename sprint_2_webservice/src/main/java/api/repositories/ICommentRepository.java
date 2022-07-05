package api.repositories;

import api.models.Comment;
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
        Function: create list comment;
        Class:
    */
    @Query(value = "select `id`,`comment_content`,`time`,`guest_id`,`post_id` from `comment` where `post_id`=:id", nativeQuery = true)
    List<Comment> listCommentByPostId(@Param("id")Long id);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: count comment by id;
        Class:
    */
    @Query(value = "select count `id`from `comment` where `post_id`=:id", nativeQuery = true)
    Long countCommentByPostId(@Param("id")Long id);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: find comment by id;
        Class:
    */
    @Query(value = "select count `id`from `comment` where `id`=:id", nativeQuery = true)
    Comment findCommentById(@Param("id")Long id);

    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: update comment by id;
      Class:
  */
    @Query(value = "update `comment` set `comment_content`=:#{#comment.commentContent},`time`=:#{#comment.time} where `id`=:id", nativeQuery = true)
    Comment updateCommentById(Comment comment,@Param("id")Long id);

    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: delete comment by id;
      Class:
  */
    @Query(value = "delete from `comment` where `id`=:id", nativeQuery = true)
    void deleteCommentById(@Param("id")Long id);
}
