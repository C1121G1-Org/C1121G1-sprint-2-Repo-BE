package api.services;

import api.dto.IPostDto;
import api.models.Post;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface IPostService {
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

    Page<IPostDto> findAll(Pageable pageable, Long guest);

    void savePost(Post post);
}
