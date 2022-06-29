package api.repositories;

import api.models.GuestFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    /*
     Created by ChienLV
     Date: 15:00 29/06/2022
     Desc: findAllFriendRequests(id) => Lấy list lời mời kết bạn dựa vào id của guest khi đăng nhập vào;
     Nó sẽ lấy những record nào có is_accept = 0 trong bảng guest_friend của guest có id = id truyền vào;
*/
    @Query(value = "Select * " +
            "from guest_friend " +
            "where guest_friend.is_accept = 0 and guest_friend.guest_id = :id ", nativeQuery = true)
    List<GuestFriend> findAllFriendRequests(@Param("id") Long id);

    /*
         Created by ChienLV
         Date: 15:00 29/06/2022
         Desc: findAllFriendSuggestions(id) => Lấy list gợi kết bạn dựa vào id của guest khi đăng nhập vào;
         Nó sẽ lấy những record nào có is_accept = 1 và is_suggest = 1 trong bảng guest_friend của những guest
         có bạn chung với guest có id = id truyền vào;
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
       Date: 15:00 29/06/2022
       Desc: acceptFriend(id) => Chấp nhận lời mời kết bạn dựa vào id của bảng guest_friend;
       Đổi is_accept từ 0 thành 1 trong table guest_friend;
     */
    @Modifying
    @Query(value = "update guest_friend " +
            "set is_accept = 1 " +
            "where id = :id ", nativeQuery = true)
    void acceptFriend(@Param("id") Long id);

    /*
       Created by ChienLV
       Date: 15:00 29/06/2022
       Desc: refuseFriend(id) =>Từ chối lời mời kết bạn dựa vào id của bảng guest_friend;
       Xóa luôn record có id truyền vào trong table guest_friend;
     */
    @Modifying
    @Query(value = "delete from guest_friend " +
            "where id = :id and is_accept = 0 ", nativeQuery = true)
    void refuseFriend(@Param("id") Long id);

    /*
       Created by ChienLV
       Date: 15:00 29/06/2022
       Desc: removeSuggestion(id) => Từ chối lời gợi ý kết bạn dựa vào id của bảng guest_friend;
       Đổi is_suggest từ 1 thành 0 trong table guest_friend;
     */
    @Modifying
    @Query(value = "update guest_friend " +
            "set is_suggest = 0 " +
            "where id = :id ", nativeQuery = true)
    void removeSuggestion(@Param("id") Long id);
}
