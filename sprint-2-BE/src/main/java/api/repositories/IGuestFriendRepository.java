package api.repositories;

import api.models.GuestFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IGuestFriendRepository extends JpaRepository<GuestFriend, Long> {
    /*
     Created by ChienLV
     Time: 20:00 25/06/2022
 */
    @Query(value = "Select * " +
            "from guest_friend " +
            "where guest_friend.is_accept = 0 and guest_friend.guest_id = :id ", nativeQuery = true)
    List<GuestFriend> findAllFriendRequests(@Param("id") Long id);

    /*
     Created by ChienLV
     Time: 20:00 25/06/2022
 */
    @Query(value = "select * " +
            "from guest_friend " +
            "where guest_friend.is_accept = 1 and guest_friend.is_suggest = 1 " +
            "and guest_friend.guest_id in (select guest_friend.friend_id from guest_friend where guest_friend.guest_id = :id and guest_friend.is_accept = 1 and guest_friend.is_suggest = 1) " +
            "and  guest_friend.friend_id not in (select guest_friend.friend_id from guest_friend where guest_friend.guest_id = :id and guest_friend.is_accept = 1 and guest_friend.is_suggest = 1) " +
            "and guest_friend.friend_id != :id ", nativeQuery = true)
    List<GuestFriend> findAllFriendSuggestions(@Param("id") Long id);

    /*
     Created by ChienLV
     Time: 20:00 25/06/2022
 */
    @Modifying
    @Query(value = "update guest_friend " +
            "set is_accept = 1 " +
            "where id = :id ", nativeQuery = true)
    void acceptFriend(@Param("id") Long id);

    /*
     Created by ChienLV
     Time: 20:00 25/06/2022
 */
    @Modifying
    @Query(value = "delete from guest_friend " +
            "where id = :id and is_accept = 0 ", nativeQuery = true)
    void refuseFriend(@Param("id") Long id);

    /*
     Created by ChienLV
     Time: 20:00 25/06/2022
 */
    @Modifying
    @Query(value = "update guest_friend " +
            "set is_suggest = 0 " +
            "where id = :id ", nativeQuery = true)
    void removeSuggestion(@Param("id") Long id);
}
