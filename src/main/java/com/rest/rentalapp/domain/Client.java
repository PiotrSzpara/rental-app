package com.rest.rentalapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Access(AccessType.FIELD)
@Getter
@Setter
@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "client_id")
    int clientId;
    @NotBlank(message = "Client name must not be empty")

    String name;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(
            name = "CLIENT_APARTMENT",
            joinColumns = {@JoinColumn(name = "join_client_id", referencedColumnName = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "join_apartment_id", referencedColumnName = "apartment_id")}
    )
    private Set<Apartment> apartments = new java.util.LinkedHashSet<>();

    @OneToMany(targetEntity = Reservation.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "guest")
    private Set<Reservation> guestReservations;

    @OneToMany(targetEntity = Reservation.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Reservation> ownerReservations;

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public Client() {
    }

    public Client(int clientId, String name) {
    }


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
