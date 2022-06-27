package api.repositories;

import api.models.GuestFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IGuestFavoriteRepository extends JpaRepository<GuestFavorite, Long> {

    /*
        Created by khoaVC
        Role: MEMBER
        Time: 14:00 23/06/2022
        Function: create = create record for favorite list
        Class:
    */
    @Transactional
    @Modifying
    @Query(value = " insert into guest_favorite (guest_id, favorite_id) values (:id, :i) ", nativeQuery = true)
    void create(@Param("id") Long id, @Param("i") Integer i);
}
