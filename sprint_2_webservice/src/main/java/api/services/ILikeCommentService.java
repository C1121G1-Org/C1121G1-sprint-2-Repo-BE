package api.services;

import api.models.LikeComment;
import api.repositories.ILikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILikeCommentService {
    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: count like comment by comment id;
      Class:
  */
    Long countLikeCommentById(Long id);


    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: list who like comment by comment id;
        Class:
    */

    List<LikeComment> listLikeComment(Long id);


    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: create like comment;
    Class:
*/
    void createLikeComment(LikeComment likeComment);


    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: Update like comment;
    Class:
*/
    void updateLikeComment(LikeComment likeComment);

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: Find like comment by comment and guest id;
    Class:
    */
    LikeComment findLikeCommentByGuestIdAndCommentId(Long commentId, Long guestId);
}
