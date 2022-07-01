package api.services.impl;

import api.repositories.IPostRepository;
import api.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostRepository iPostRepository;
}
