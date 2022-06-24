package api.services.impl;

import api.repositories.ILikeCommentRepository;
import api.services.ILikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeCommentServiceImpl implements ILikeCommentService {
    @Autowired
    ILikeCommentRepository iLikeCommentRepository;
}
