package com.rest.rentalapp.domain;

import lombok.Getter;

@Getter
public class ClientDto {
    private int clientId;
    private String name;

    public ClientDto() {
    }

    public ClientDto(int clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

}
