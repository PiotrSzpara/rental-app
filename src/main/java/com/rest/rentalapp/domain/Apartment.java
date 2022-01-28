package com.rest.rentalapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Apartment name must not be empty")
    private String name;
    private double price;
    private double area;
    private String description;
    @OneToMany
    private List<Reservation> reservations = new ArrayList<>();
    @ManyToMany
    private List<Client> clients = new ArrayList<>();

    public Apartment() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    void setPrice(double price) { this.price = price; }

    public double getArea() { return area; }

    void setArea(double area) { this.area = area; }

    public String getDescription() { return description; }

    void setDescription(String description) { this.description = description; }

    public List<Reservation> getReservations() { return reservations; }

    void setReservations(List<Reservation> reservations) { this.reservations = reservations; }

    public List<Client> getClients() { return clients; }

    void setClients(List<Client> clients) { this.clients = clients; }
}
