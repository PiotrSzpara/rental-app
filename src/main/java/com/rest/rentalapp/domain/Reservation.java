package com.rest.rentalapp.domain;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int rentalPeriod;
    //private Client owner;
    //private Client guest;
    private double cost;

    public Reservation() {
    }

    public int getId() { return id; }

    void setId(int id) { this.id = id; }

    public int getRentalPeriod() { return rentalPeriod; }

    void setRentalPeriod(int rentalPeriod) { this.rentalPeriod = rentalPeriod; }

    public double getCost() { return cost; }

    void setCost(double cost) { this.cost = cost; }
}
