package api.services.impl;

import api.dto.IPostDto;
import api.dto.PostDto;
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

    @Override
    public Page<IPostDto> findAll(Pageable pageable, Long guestId) {
        return iPostRepository.findAllPosts(pageable, guestId);
    }
}
