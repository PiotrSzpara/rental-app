package com.rest.rentalapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlReservationRepository extends ReservationRepository, JpaRepository<Reservation, Integer> {
}
