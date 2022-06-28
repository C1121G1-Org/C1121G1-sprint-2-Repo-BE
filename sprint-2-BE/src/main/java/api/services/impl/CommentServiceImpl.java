package api.services.impl;

import api.models.Comment;
import api.repositories.ICommentRepository;
import api.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;

    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: create comment;
      Class:
  */
    @Override
    public void createComment(Comment comment) {
        iCommentRepository.createComment(comment);
    }

      /*
      Created by hoangDH

      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: create list comment;
      Class:
  */
    @Override
    public List<Comment> listCommentByPostId(Long id) {
        return iCommentRepository.listCommentByPostId(id);
    }


  /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: count comment by id;
      Class:
  */
    @Override
    public Long countCommentByPostId(Long id) {
        return iCommentRepository.countCommentByPostId(id);
    }

      /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: find comment by id;
      Class:
  */
    @Override
    public Comment findCommentById(Long id) {
        return iCommentRepository.findCommentById(id);
    }

      /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: update comment by id;
    Class:
*/
    @Override
    public Comment updateCommentById(Comment comment, Long id) {
        return iCommentRepository.updateCommentById(comment,id);
    }


  /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: delete comment by id;
    Class:
*/
    @Override
    public void deleteCommentById(Comment comment, Long id) {
        iCommentRepository.deleteCommentById(comment,id);
    }
}
