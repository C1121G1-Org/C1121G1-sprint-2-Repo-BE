package api.services;

import api.models.Post;
<<<<<<< HEAD

public interface IPostService {
    Post getById(Long id);
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {

    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    void createPost(Post post);
>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4
}
