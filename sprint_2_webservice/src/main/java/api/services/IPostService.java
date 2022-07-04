package api.services;

import api.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPostService {
    /*
Created by hoangDH
Role: Admin, member
Time: 11:17 24/06/2022
Function: find post by id;
Class:
*/
    Post findPostById1(Long id);
}
