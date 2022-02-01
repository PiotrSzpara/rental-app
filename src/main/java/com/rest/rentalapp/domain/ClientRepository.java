package com.rest.rentalapp.domain;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> findAll();

    Optional<Client> findById(Integer repositoryId);

    boolean existsById(Integer repositoryId);

    Client save(Client entity);
}
