package com.rest.rentalapp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
interface SqlClientRepository extends ClientRepository, JpaRepository<Client, Integer> {

}
