package com.rest.rentalapp.controller;

import com.rest.rentalapp.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationRepository reservationRepository;
    private final ApartmentRepository apartmentRepository;
    private final ClientRepository clientRepository;

    public ReservationController(ReservationRepository reservationRepository, ApartmentRepository apartmentRepository, ClientRepository clientRepository ) {
        this.reservationRepository = reservationRepository;
        this.apartmentRepository = apartmentRepository;
        this.clientRepository = clientRepository;
    }


    @PostMapping("/reservations")
    ResponseEntity<Reservation> createReservation(@PathVariable String apartment, @PathVariable LocalDate begin, @PathVariable LocalDate end, @RequestBody @Valid Reservation toCreate) {
        if(reservationRepository.existsBy(apartment, begin, end)) {
            return ResponseEntity.notFound().build();
        }
        Reservation result = reservationRepository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getReservationId())).body(result);
    }
    @Transactional
    @PostMapping(value = "/createReservation", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creatReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }
    @Transactional
    @PostMapping(value = "/createApartment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creatApartment(@RequestBody Apartment apartment) {
        apartmentRepository.save(apartment);
    }
    @Transactional
    @PostMapping(value = "/createClient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody Client client) {
        clientRepository.save(client);
    }
    @GetMapping(value = "/getReservations")
    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }
    @GetMapping(value = "/getApartments")
    public List<Apartment> getApartments() {
        List<Apartment> apartments = apartmentRepository.findAll();
        return apartments;
    }
    @GetMapping(value = "/getClients")
    public List<Client> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @GetMapping(value = "/reservations", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Reservation>> readAllReservations() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(reservationRepository.findAll());
    }

    @PutMapping("/reservations/{id}")
    ResponseEntity<?> updateReservation(@PathVariable int id, @RequestBody Reservation toUpdate) {
        //if(reservationRepository.existsById(id)) {
            //return ResponseEntity.notFound().build();
        //}
        toUpdate.setReservationId(id);
        reservationRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
    /*@GetMapping(value = "getReservationByClientName")
    public List<Reservation> getReservationByClientName(@RequestParam("name") String name) {
        return reservationRepository.findReservationsByGuestName(name);
    }*/
}
