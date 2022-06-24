package api.services;

import api.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {

    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    void createPost(Post post);
}
