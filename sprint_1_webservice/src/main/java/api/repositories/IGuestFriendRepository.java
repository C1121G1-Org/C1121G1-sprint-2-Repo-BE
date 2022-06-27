package api.repositories;

import api.models.GuestFriend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGuestFriendRepository extends JpaRepository<GuestFriend, Long> {
}
