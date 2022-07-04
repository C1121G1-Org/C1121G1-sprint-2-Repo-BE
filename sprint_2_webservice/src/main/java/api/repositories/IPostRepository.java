package api.repositories;

import api.models.Comment;
import api.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPostRepository extends JpaRepository<Post, Long> {
    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: find post by id;
    Class:
*/
    @Query(value = "select * from `post` where `id`=:id", nativeQuery = true)
    Post findPostById1(@Param("id")Long id);
}
