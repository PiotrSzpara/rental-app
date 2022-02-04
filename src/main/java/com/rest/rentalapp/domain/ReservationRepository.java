package com.rest.rentalapp.domain;

import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {

    List<Reservation> findAll();

    List<Reservation> findReservationsByGuestName(String name);

    List<Reservation> findReservationsByApartment_ApartmentId(Integer apartmentId);

    List<Reservation> findReservationsByGuest_ClientId(Integer clientId);

    Optional<Reservation> findById(Integer reservationId);

    boolean existsById(Integer reservationId);

    boolean existsBy(@Param("apartment") Apartment apartment, @Param("begin") Date begin, @Param("end") Date end);

    //boolean existsReservationsByStartAfter(LocalDate start);

    //boolean existsReservationsByEndBefore(LocalDate end);

    boolean existsReservationsByApartment_ApartmentId(Integer apartmentId);

    Reservation save(Reservation entity);
}
