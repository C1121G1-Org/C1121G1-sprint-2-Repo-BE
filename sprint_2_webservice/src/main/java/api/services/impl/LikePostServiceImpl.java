package api.services.impl;

import api.repositories.ILikePostRepository;
import api.services.ILikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikePostServiceImpl implements ILikePostService {
    @Autowired
    ILikePostRepository iLikePostRepository;
}
