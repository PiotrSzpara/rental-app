package com.rest.rentalapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
interface SqlApartmentRepository extends ApartmentRepository, JpaRepository<Apartment, Integer> {


}
