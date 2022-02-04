package com.rest.rentalapp.domain;

import lombok.Getter;

import java.util.Date;
@Getter
public class ReservationDto {
    private int reservationId;
    private Date begin;
    private Date end;
    private Client owner;
    private Client guest;
    private double cost;
    private Apartment apartment;

    public ReservationDto() {
    }

    public ReservationDto(int reservationId, Date begin, Date end, Client owner, Client guest, double cost, Apartment apartment) {
        this.reservationId = reservationId;
        this.begin = begin;
        this.end = end;
        this.owner = owner;
        this.guest = guest;
        this.cost = cost;
        this.apartment = apartment;
    }

}
