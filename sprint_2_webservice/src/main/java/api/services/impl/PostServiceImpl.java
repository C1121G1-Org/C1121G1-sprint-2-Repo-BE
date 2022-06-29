package api.services.impl;

import api.models.Post;
import api.repositories.IPostRepository;
import api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepository iPostRepository;

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
