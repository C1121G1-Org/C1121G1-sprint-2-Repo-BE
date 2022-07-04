package api.services.impl;

import api.models.Post;
import api.repositories.IPostRepository;
import api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepository iPostRepository;

    /*
    Created by hoangDH
    Role: Admin, member
    Time: 11:17 24/06/2022
    Function: find post by id;
    Class:
    */
    @Override
    public Post findPostById1(Long id){
        return iPostRepository.findPostById1(id);
    };
    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    @Override
    public void createPost(Post post) {
        iPostRepository.createPost(post);
    }

}
