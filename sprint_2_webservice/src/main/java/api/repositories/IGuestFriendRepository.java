package api.repositories;

import api.models.GuestFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
/*
    Created by HauPV
    Time: 14:00 27/06/2022
    Function: GuestFriend Repository
*/
@Transactional
public interface IGuestFriendRepository extends JpaRepository<GuestFriend, Long> {

    @Modifying
    @Query(value = "INSERT INTO `sprint-2-database`.`guest_friend` (`friend_id`, `guest_id`) VALUES (:#{#guestFriend.friend.id}, :#{#guestFriend.guest.id}) ; ",
            nativeQuery = true)
    void insertGuestFriend(GuestFriend guestFriend);
}