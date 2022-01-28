package com.rest.rentalapp.domain;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    List<Reservation> findAll();

    Optional<Reservation> findById(Integer id);

    boolean existsById(Integer id);

    Reservation save(Reservation entity);
}
