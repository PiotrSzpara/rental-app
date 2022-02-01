package com.rest.rentalapp.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private int reservationId;//@Embedded//private RentalPeriod rentalPeriod = new RentalPeriod();
    private LocalDate begin;
    private LocalDate end;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    private Client owner;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guest_id")
    private Client guest;
    private double cost;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public Reservation() {
    }

    public Reservation(int reservationId, LocalDate begin, LocalDate end, Client owner, Client guest, double cost, Apartment apartment) {
        this.reservationId = reservationId;
        this.begin = begin;
        this.end = end;
        this.owner = owner;
        this.guest = guest;
        this.cost = cost;
        this.apartment = apartment;
    }

    public void updateFrom(final Reservation source) {
        //rentalPeriod = source.rentalPeriod;
        guest = source.guest;
        cost = source.getCost();
        apartment = source.apartment;

    }

    public int getReservationId() { return reservationId; }

    public void setReservationId(int reservationId) { this.reservationId = reservationId; }

    //public int getRentalPeriod() {
        //return rentalPeriod.countDays(); }

    //void setRentalPeriod(RentalPeriod rentalPeriod) { this.rentalPeriod = rentalPeriod; }

    public Client getOwner() { return owner; }

    void setOwner(Client owner) { this.owner = owner; }

    public Client getGuest() { return guest; }

    void setGuest(Client guest) { this.guest = guest; }

    public double getCost() {
        return cost;
    }

    //public double getCost() {
       // assert apartment != null;
        //return rentalPeriod.countDays() * apartment.getPrice(); }

    void setCost(double cost) { this.cost = cost; }

    public Apartment getApartment() { return apartment; }

    public void setApartment(Apartment apartment) { this.apartment = apartment; }

    public LocalDate getBegin() {
        return begin;
    }

    void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    void setEnd(LocalDate end) {
        this.end = end;
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
