package api.services;

import api.models.Comment;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICommentService {
    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: create comment;
      Class:
  */
    void createComment(Comment comment);

    /*
        Created by hoangDH

        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: create list comment;
        Class:
    */
    List<Comment> listCommentByPostId(@Param("id")Long id);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: count comment by id;
        Class:
    */
    Long countCommentByPostId(@Param("id")Long id);

    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: find comment by id;
        Class:
    */
    Comment findCommentById(@Param("id")Long id);

    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: update comment by id;
      Class:
  */
    Comment updateCommentById(Comment comment,@Param("id")Long id);

    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: delete comment by id;
      Class:
  */
    void deleteCommentById(Comment comment,@Param("id")Long id);

}
