package com.rest.rentalapp.controller;

import com.rest.rentalapp.domain.Apartment;
import com.rest.rentalapp.domain.ApartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ApartmentController {

    private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);
    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping(value = "/apartments", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Apartment>> readAllApartments() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(apartmentRepository.findAll());
    }

    @PutMapping("/apartments/{id}")
    ResponseEntity<?> updateApartment(@PathVariable int id, @RequestBody Apartment toUpdate) {
        if(apartmentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        apartmentRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
}
