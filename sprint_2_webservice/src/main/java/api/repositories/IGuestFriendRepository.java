package api.repositories;

import api.models.GuestFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: GuestFriend Repository
*/
@Transactional
public interface IGuestFriendRepository extends JpaRepository<GuestFriend, Long> {

    @Modifying
    @Query(value = "INSERT INTO `sprint-2-db`.`guest_friend` (`friend_id`, `guest_id`) VALUES (:#{#guestFriend.friend.id}, :#{#guestFriend.guest.id}) ; ",
            nativeQuery = true)
    void insertGuestFriend(GuestFriend guestFriend);

    @Query(value = "SELECT * FROM `sprint-2-db`.guest_friend " +
            " where guest_friend.guest_id = :#{#id} ;",
            nativeQuery = true)
    List<GuestFriend> findAllGuestFriendByGuestId(Integer id);

    @Query(value = "SELECT * FROM `sprint-2-db`.guest_friend " +
            "where guest_id = :#{#guestId} and friend_id = :#{#friendId} ;",
            nativeQuery = true)
    GuestFriend findAllGuestFriendByGuestIdAndFriendId(Long guestId, Long friendId);

    @Modifying
    @Query(value = "DELETE FROM `sprint-2-db`.guest_friend " +
            "where id = :#{#id} ;",
            nativeQuery = true)
    void deleteGuestFriendById(Long id);
}
