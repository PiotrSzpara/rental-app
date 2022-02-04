package com.rest.rentalapp.mapper;

import com.rest.rentalapp.domain.Reservation;
import com.rest.rentalapp.domain.ReservationDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReservationMapper {

    public Reservation mapToReservation(final ReservationDto reservationDto) {
        return new Reservation(
                reservationDto.getReservationId(),
                reservationDto.getBegin(),
                reservationDto.getEnd(),
                reservationDto.getOwner(),
                reservationDto.getGuest(),
                reservationDto.getCost(),
                reservationDto.getApartment()
        );
    }

    public ReservationDto mapToReservationDto(final Reservation reservation) {
        return new ReservationDto(
                reservation.getReservationId(),
                reservation.getBegin(),
                reservation.getEnd(),
                reservation.getOwner(),
                reservation.getGuest(),
                reservation.getCost(),
                reservation.getApartment()
        );
    }

    public List<ReservationDto> mapToReservationDtoList(final List<Reservation> reservations) {
        return reservations.stream()
                .map(this::mapToReservationDto)
                .collect(Collectors.toList());
    }
}
