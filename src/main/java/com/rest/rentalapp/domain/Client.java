package com.rest.rentalapp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Client name must not be empty")
    String name;

    public Client() {
    }

    public int getId() { return id; }

    void setId(int id) { this.id = id; }

    public String getName() { return name; }

    void setName(String name) { this.name = name; }
}
