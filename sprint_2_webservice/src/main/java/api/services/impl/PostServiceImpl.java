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

<<<<<<< HEAD:sprint-2-BE/src/main/java/api/services/impl/PostServiceImpl.java
    @Override
    public Post getById(Long id) {
        return iPostRepository.getById(id);
=======
    /*
        Created by TuanNQ
        Time: 14:00 23/06/2022
        Function: Create post
    */
    @Override
    public void createPost(Post post) {
        iPostRepository.createPost(post);
>>>>>>> f8bff5e374d80f77abd3db31e9c05bbac00422e4:sprint_2_webservice/src/main/java/api/services/impl/PostServiceImpl.java
    }
}
