package api.repositories;

import api.models.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFriendRepository extends JpaRepository<Friend, Long> {
}
