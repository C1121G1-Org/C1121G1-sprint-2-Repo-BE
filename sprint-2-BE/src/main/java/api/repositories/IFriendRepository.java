package api.repositories;

import api.models.Friend;
import api.models.GuestFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFriendRepository extends JpaRepository<Friend, Long> {

}
