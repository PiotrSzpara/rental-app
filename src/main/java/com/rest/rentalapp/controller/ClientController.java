package com.rest.rentalapp.controller;

import com.rest.rentalapp.domain.ClientRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
