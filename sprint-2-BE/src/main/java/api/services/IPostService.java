package api.services;

import api.models.Post;

public interface IPostService {
    Post getById(Long id);
}
