package com.rest.rentalapp.domain;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository {

    List<Apartment> findAll();

    Optional<Apartment> findById(Integer id);

    boolean existsById(Integer id);

    Apartment save(Apartment entity);
}
