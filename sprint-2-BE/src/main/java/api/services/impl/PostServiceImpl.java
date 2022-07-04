package api.services.impl;

import api.models.Post;
import api.repositories.IPostRepository;
import api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepository iPostRepository;

    @Override
    public Post getById(Long id) {
        return iPostRepository.getById(id);
    }
}
