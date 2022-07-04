package api.repositories;

import api.dto.LikeCmtAndGuest;
import api.models.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILikeCommentRepository extends JpaRepository<LikeComment, Long> {
    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: count like comment by comment id;
      Class:
  */
    @Query(value = "select count(`id`) from `like_comment` where `comment_id`=:id and `like_comment_flag`=true", nativeQuery = true)
    Long countLikeCommentById(@Param("id")Long id);




    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: find like c comment id;
        Class:
    */
    @Query(value = "SELECT `like_comment`.`id` as `id`,`guest`.`image` as `image`,`guest`.`name` as `name`" +
            "FROM `like_comment` join `guest` on `like_comment`.`guest_id`=`guest`.`id` " +
            "where `comment_id`=:id " +
            "and `like_comment_flag`=true " +
            "and `guest`.`delete_flag`=false;", nativeQuery = true)
    List<LikeCmtAndGuest> listLikeComment(@Param("id")Long id);



    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: create like comment;
    Class:
*/
    @Transactional
    @Modifying
    @Query(value = "insert into `like_comment` (`like_comment_flag`,`comment_id`,`guest_id`)" +
            "values (:#{#likeComment.likeCommentFlag},:#{#likeComment.comment.id},:#{#likeComment.guest.id})", nativeQuery = true)
    void createLikeComment(LikeComment likeComment);


    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: Update like comment;
    Class:
*/
    @Transactional
    @Modifying
    @Query(value = "update `like_comment`" +
            "set `like_comment_flag`=:#{#likeComment.likeCommentFlag} where `id`=:id", nativeQuery = true)
    void updateLikeComment(LikeComment likeComment,@Param ("id")Long id);

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: Find like comment by id;
    Class:
    */
    @Query(value = "select * from `like_comment`" +
            "where `comment_id`=:commentId and `guest_id`=:guestId ", nativeQuery = true)
    LikeComment findLikeCommentByGuestIdAndCommentId(Long guestId, Long commentId);

}
