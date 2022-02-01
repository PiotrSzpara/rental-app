package com.rest.rentalapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;


@Entity
@Table(name = "apartments")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id")
    private int apartmentId;
    @NotBlank(message = "Apartment name must not be empty")
    private String name;
    private double price;
    private double area;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "apartment")
    private Set<Reservation> reservations;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "apartments")
    private Set<Client> clients;

    public Apartment() {
    }

    public int getApartmentId() { return apartmentId; }

    public void setApartmentId(int apartmentId) { this.apartmentId = apartmentId; }

    public String getName() { return name; }

    void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    void setPrice(double price) { this.price = price; }

    public double getArea() { return area; }

    void setArea(double area) { this.area = area; }

    public String getDescription() { return description; }

    void setDescription(String description) { this.description = description; }

    public Set<Reservation> getReservations() { return reservations; }

    void setReservations(Set<Reservation> reservations) { this.reservations = reservations; }

    public Set<Client> getClients() { return clients; }

    void setClients(Set<Client> clients) { this.clients = clients; }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", description='" + description + '\'' +
                ", reservations=" + reservations +
                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        Apartment apartment = (Apartment) o;
        return apartmentId == apartment.apartmentId && Double.compare(apartment.price, price) == 0 && Double.compare(apartment.area, area) == 0 && Objects.equals(name, apartment.name) && Objects.equals(description, apartment.description) && Objects.equals(reservations, apartment.reservations) && Objects.equals(clients, apartment.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartmentId, name, price, area, description, reservations, clients);
    }
}
