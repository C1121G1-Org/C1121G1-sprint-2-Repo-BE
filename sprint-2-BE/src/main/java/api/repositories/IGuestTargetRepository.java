package api.repositories;

import api.models.GuestTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IGuestTargetRepository extends JpaRepository<GuestTarget, Long> {


    /*
        Created by khoaVC
        Role: MEMBER
        Time: 23:00 15/06/2022
        Function: create = create record for target list
        Class:
    */
    @Transactional
    @Modifying
    @Query(value = " insert into guest_target (guest_id, target_id) values (:id, :i) ", nativeQuery = true)
    void create(@Param("id") Long id, @Param("i") Integer i);
}
