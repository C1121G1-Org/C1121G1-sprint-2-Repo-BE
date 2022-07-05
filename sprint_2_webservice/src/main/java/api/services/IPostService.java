package api.services;

import api.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPostService {
    Post getById(Long id);

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: find post by id;
    Class:
    */
    Post findPostById1(Long id);


    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    void createPost(Post post);

}
