package api.services;

import api.dto.IFriendDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFriendService {
    Page<IFriendDto> findAllFriend(Pageable pageable, String key, Long id);

    void saveDelete(Long id);

}
