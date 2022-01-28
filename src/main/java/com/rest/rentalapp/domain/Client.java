package com.rest.rentalapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Client name must not be empty")
    String name;
    @ManyToMany
    private List<Apartment> apartments = new ArrayList<>();
    @OneToMany
    private List<Reservation> reservations = new ArrayList<>();

    public Client() {
    }

    public int getId() { return id; }

    void setId(int id) { this.id = id; }

    public String getName() { return name; }

    void setName(String name) { this.name = name; }

    public List<Apartment> getApartments() { return apartments; }

    void setApartments(List<Apartment> apartments) { this.apartments = apartments; }

    public List<Reservation> getReservations() { return reservations; }

    void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
}
