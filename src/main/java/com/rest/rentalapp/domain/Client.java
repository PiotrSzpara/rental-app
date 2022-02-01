package com.rest.rentalapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    private int clientId;
    @NotBlank(message = "Client name must not be empty")
    String name;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "client_apartment",
            joinColumns = {@JoinColumn(name = "join_client_id", referencedColumnName = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "join_apartment_id", referencedColumnName = "apartment_id")}
    )
    private Set<Apartment> apartments = new java.util.LinkedHashSet<>();
    @OneToMany(targetEntity = Reservation.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "guest")
    private Set<Reservation> guestReservations;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Reservation> ownerReservations;

    public Set<Apartment> getApartments() {
        return apartments;
    }


    public Client() {
    }

    public int getClientId() { return clientId; }

    public void setClientId(int clientId) { this.clientId = clientId; }

    public String getName() { return name; }

    void setName(String name) { this.name = name; }

    void setApartments(Set<Apartment> apartments) { this.apartments = apartments; }

    public Set<Reservation> getGuestReservations() { return guestReservations; }

    void setGuestReservations(Set<Reservation> guestReservations) { this.guestReservations = guestReservations; }

    public Set<Reservation> getOwnerReservations() { return ownerReservations; }

    public void setOwnerReservations(Set<Reservation> ownerReservations) { this.ownerReservations = ownerReservations; }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", apartments=" + apartments +
                ", guestReservations=" + guestReservations +
                ", ownerReservations=" + ownerReservations +
                '}';
    }
}
