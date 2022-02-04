package com.rest.rentalapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Access(AccessType.FIELD)
@Getter
@Setter
@Entity
@Table(name = "APARTMENTS")
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id")
    int apartmentId;

    @NotBlank(message = "Apartment name must not be empty")
    private String name;

    private double price;

    private double area;

    private String description;

    @OneToMany(targetEntity = Reservation.class, mappedBy = "apartment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "apartments")
    private Set<Client> clients;


    public Apartment() {
    }

    public Apartment(int apartmentId, String name, double price, double area, String description) {
    }



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
