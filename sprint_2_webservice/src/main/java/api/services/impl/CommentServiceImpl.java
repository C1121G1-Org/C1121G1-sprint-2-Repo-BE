package api.services.impl;

import api.repositories.ICommentRepository;
import api.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    ICommentRepository iCommentRepository;
}
