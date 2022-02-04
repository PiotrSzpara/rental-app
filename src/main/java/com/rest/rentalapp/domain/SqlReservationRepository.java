package com.rest.rentalapp.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
interface SqlReservationRepository extends ReservationRepository, JpaRepository<Reservation, Integer> {

    @Query( nativeQuery = true,
            value = "select count(*) > 0 from reservations where (apartment_id = :apartment) or (((begin <= :begin) and (:begin < end)) or ((begin < :end) and (:end <= end)) or ((:begin < begin) and (begin < :end))) " )

     boolean existsBy(@Param("apartment") Apartment apartment, @Param("begin") Date begin, @Param("end") Date end);


}
