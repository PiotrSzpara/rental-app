package com.rest.rentalapp.domain;

import java.util.List;
import java.util.Optional;

public interface ApartmentRepository {

    List<Apartment> findAll();

    Optional<Apartment> findById(Integer apartmentId);

    boolean existsById(Integer apartmentId);

    Apartment save(Apartment entity);
}
