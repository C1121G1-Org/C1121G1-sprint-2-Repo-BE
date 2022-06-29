package api.repositories;

import api.models.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikePostRepository extends JpaRepository<LikePost, Long> {
}
