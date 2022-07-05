package api.services.impl;

import api.dto.IFriendDto;
import api.repositories.IFriendRepository;
import api.services.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements IFriendService {
    @Autowired
    IFriendRepository iFriendRepository;

    @Override
    public Page<IFriendDto> findAllFriend(Pageable pageable, String key, Long id) {
        return iFriendRepository.pageFindAll(pageable, key, id);
    }

    @Override
    public void saveDelete(Long id) {
        this.iFriendRepository.saveDelete(id);
    }

}
