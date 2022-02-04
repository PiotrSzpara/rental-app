package com.rest.rentalapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Access(AccessType.FIELD)
@Getter
@Setter
@Entity
@Table(name = "RESERVATIONS")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "reservation_id")
    int reservationId;

    private Date begin;

    private Date end;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "OWNER_ID")
    private Client owner;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "GUEST_ID")
    private Client guest;

    private double cost;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "APARTMENT_ID")
    private Apartment apartment;



    public Reservation() {
    }

    public Reservation(int reservationId, Date begin, Date end, Client owner, Client guest, double cost, Apartment apartment) {
    }

    public void updateFrom(final Reservation source) {
        begin = source.begin;
        end = source.end;
        owner = source.owner;
        guest = source.guest;
        cost = source.getCost();
        apartment = source.apartment;

    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                //", rentalPeriod=" + rentalPeriod +
                ", owner=" + owner +
                ", guest=" + guest +
                ", cost=" + cost +
                ", apartment=" + apartment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return reservationId == that.reservationId && Double.compare(that.cost, cost) == 0 && Objects.equals(begin, that.begin) && Objects.equals(end, that.end) && Objects.equals(owner, that.owner) && Objects.equals(guest, that.guest) && Objects.equals(apartment, that.apartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, begin, end, owner, guest, cost, apartment);
    }
}
