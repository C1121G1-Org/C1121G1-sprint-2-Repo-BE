package api.services;

import api.dto.IPostDto;
import api.dto.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<IPostDto> findAll(Pageable pageable, Long guest);
}
