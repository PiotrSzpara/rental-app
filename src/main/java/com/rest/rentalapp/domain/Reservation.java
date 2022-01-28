package com.rest.rentalapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rentalPeriod;
    @ManyToOne
    private Client owner;
    @ManyToOne
    private Client guest;
    private double cost;
    @ManyToOne
    private Apartment apartment;

    public Reservation() {
    }

    public int getId() { return id; }

    void setId(int id) { this.id = id; }

    public int getRentalPeriod() { return rentalPeriod; }

    void setRentalPeriod(int rentalPeriod) { this.rentalPeriod = rentalPeriod; }

    public Client getOwner() { return owner; }

    void setOwner(Client owner) { this.owner = owner; }

    public Client getGuest() { return guest; }

    void setGuest(Client guest) { this.guest = guest; }

    public double getCost() { return cost; }

    void setCost(double cost) { this.cost = cost; }

    public Apartment getApartment() { return apartment; }

    public void setApartment(Apartment apartment) { this.apartment = apartment; }
}
