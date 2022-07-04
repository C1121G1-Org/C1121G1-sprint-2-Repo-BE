package api.services.impl;

import api.dto.LikeCmtAndGuest;
import api.models.LikeComment;
import api.repositories.ILikeCommentRepository;
import api.services.ILikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeCommentServiceImpl implements ILikeCommentService {
    @Autowired
    ILikeCommentRepository iLikeCommentRepository;
    /*
      Created by hoangDH
      Role: Admin, member
      Time: 11:17 24/06/2022
      Function: count like comment by comment id;
      Class:
  */
    public Long countLikeCommentById(Long id){
       return iLikeCommentRepository.countLikeCommentById(id);
    };


    /*
        Created by hoangDH
        Role: Admin, member
        Time: 11:17 24/06/2022
        Function: list who like comment by comment id;
        Class:
    */

    public List<LikeCmtAndGuest> listLikeComment(Long id){
        return iLikeCommentRepository.listLikeComment(id);
    };


    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: create like comment;
    Class:
*/
    public void createLikeComment(LikeComment likeComment){
        iLikeCommentRepository.createLikeComment(likeComment);
    };


    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: Update like comment;
    Class:
*/
    public void updateLikeComment(LikeComment likeComment,Long id){
        iLikeCommentRepository.updateLikeComment(likeComment,id);
    };

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: Find like comment by comment and guest id;
    Class:
    */
    public LikeComment findLikeCommentByGuestIdAndCommentId(Long guestId, Long commentId){
        return iLikeCommentRepository.findLikeCommentByGuestIdAndCommentId(guestId, commentId);
    };
}
