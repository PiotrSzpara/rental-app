package com.rest.rentalapp.domain;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> findAll();

    Optional<Client> findById(Integer id);

    boolean existsById(Integer id);

    Client save(Client entity);
}
