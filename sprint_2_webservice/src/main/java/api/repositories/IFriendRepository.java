package api.repositories;

import api.dto.IFriendDto;
import api.models.Friend;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

public interface IFriendRepository extends JpaRepository<Friend, Long> {
//    @Query(value = "select friend.id as id, name as name, address as address, date_of_birth as dateOfBirth," +
//            " image as image, career as career from guest_friend " +
//            " where delete_flag = 0 and guest_friend.is_accept = 1 " +
//            " and guest_friend.guest_id = :id and name like concat('%', :name ,'%') "
//            ,
//            countQuery = "select friend.id as id, name as name, address as address, date_of_birth as dateOfBirth," +
//                    " image as image, nick_name as nickName from friend " +
//                    " where delete_flag = 0 and name like concat('%', :name ,'%') ",
//            nativeQuery = true )
//    Page<IFriendDto> pageFindAll(Pageable pageable, @Param("name") String keyword);


    @Query(value = "select friend.id as id, friend.name as name, friend.address as address, friend.date_of_birth as dateOfBirth," +
            " friend.image as image, friend.career as career from guest_friend " +
            " join friend on guest_friend.friend_id = friend.id " +
            " where delete_flag = 0 and guest_friend.is_accept = 1 " +
            " and guest_friend.guest_id = :id and name like concat('%', :name ,'%') "
            ,
            countQuery = "select friend.id as id, friend.name as name, friend.address as address, friend.date_of_birth as dateOfBirth," +
                    " friend.image as image, friend.career as career from guest_friend " +
                    " join friend on guest_friend.friend_id = friend.id " +
                    " where delete_flag = 0 and guest_friend.is_accept = 1 " +
                    " and guest_friend.guest_id = :id and name like concat('%', :name ,'%') ",
            nativeQuery = true )
    Page<IFriendDto> pageFindAll(Pageable pageable, @Param("name") String keyword, @PathVariable("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update friend set delete_flag = 1 where friend.id = :id ; ", nativeQuery = true)
    void saveDelete(@PathVariable("id") Long id);

}
