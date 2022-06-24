package api.repositories;

import api.models.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeCommentRepository extends JpaRepository<LikeComment, Long> {


}
