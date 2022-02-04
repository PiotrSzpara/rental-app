package com.rest.rentalapp.controller;

import com.rest.rentalapp.domain.*;
import com.rest.rentalapp.mapper.ApartmentMapper;
import com.rest.rentalapp.mapper.ClientMapper;
import com.rest.rentalapp.mapper.ReservationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
public class ReservationController {
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

    private final ReservationRepository reservationRepository;
    private final ApartmentRepository apartmentRepository;
    private final ClientRepository clientRepository;
    private final ReservationMapper reservationMapper;
    private final ApartmentMapper apartmentMapper;
    private final ClientMapper clientMapper;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, ApartmentRepository apartmentRepository, ClientRepository clientRepository, ReservationMapper reservationMapper, ApartmentMapper apartmentMapper, ClientMapper clientMapper) {
        this.reservationRepository = reservationRepository;
        this.apartmentRepository = apartmentRepository;
        this.clientRepository = clientRepository;
        this.reservationMapper = reservationMapper;
        this.apartmentMapper = apartmentMapper;
        this.clientMapper = clientMapper;
    }


    @PostMapping(value = "/reservation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void createReservation(@RequestBody Reservation toCreate/*, @PathVariable String apartmentId, @PathVariable Date begin, @PathVariable Date end*/) {
        Date begin = toCreate.getBegin();
        Date end = toCreate.getEnd();
        Apartment apartmentId = toCreate.getApartment();
        if(!reservationRepository.existsBy(apartmentId, begin, end)) {

        reservationMapper.mapToReservationDto(reservationRepository.save(toCreate));}
        else ResponseEntity.notFound().build();
        //return ResponseEntity.created(URI.create("/" + result.getReservationId())).body(result);
    }


    @PostMapping(value = "/createReservation", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity creatReservation(@RequestBody ReservationDto reservationDto) {
        Reservation newReservation = new Reservation(reservationDto.getReservationId(), reservationDto.getBegin(), reservationDto.getEnd(), reservationDto.getOwner(), reservationDto.getGuest(), reservationDto.getCost(), reservationDto.getApartment());
        newReservation.setReservationId(reservationDto.getReservationId());
        newReservation.setApartment(reservationDto.getApartment());
        newReservation.setBegin(reservationDto.getBegin());
        newReservation.setEnd(reservationDto.getEnd());
        newReservation.setGuest(reservationDto.getGuest());
        newReservation.setOwner(reservationDto.getOwner());
        newReservation.setCost(reservationDto.getCost());
        return new ResponseEntity(reservationRepository.save(newReservation), HttpStatus.CREATED);

    }

    @Transactional
    @PostMapping(value = "/createApartment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void creatApartment(@RequestBody Apartment apartment) {
        apartmentMapper.mapToApartmentDto(apartmentRepository.save(apartment));
    }
    @Transactional
    @PostMapping(value = "/createClient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody Client client) {
        clientMapper.mapToClientDto(clientRepository.save(client));
    }

    @GetMapping(value = "/getReservations")
    public ResponseEntity<List<ReservationDto>> getReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return ResponseEntity.ok(reservationMapper.mapToReservationDtoList(reservations));
    }
    @GetMapping(value = "/getApartments")
    public ResponseEntity<List<ApartmentDto>> getApartments() {
        List<Apartment> apartments = apartmentRepository.findAll();
        return ResponseEntity.ok(apartmentMapper.mapToApartmentDtoList(apartments));
    }
    @GetMapping(value = "/getClients")
    public ResponseEntity<List<ClientDto>> getClients() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clientMapper.mapToClientDtoList(clients));
    }

    @GetMapping(value = "/reservations", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<ReservationDto>> readAllReservations() {
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(reservationMapper.mapToReservationDtoList(reservationRepository.findAll()));
    }

    @PutMapping(value = "/reservations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> updateReservation(@PathVariable int reservationId, @RequestBody Reservation toUpdate) {
        if(reservationRepository.existsById(reservationId)) {
            return ResponseEntity.notFound().build();
        }
        Date begin = toUpdate.getBegin();
        Date end = toUpdate.getEnd();
        Apartment apartmentId = toUpdate.getApartment();
        if(!reservationRepository.existsBy(apartmentId, begin, end)) {
            toUpdate.setReservationId(reservationId);
            reservationMapper.mapToReservationDto(reservationRepository.save(toUpdate));
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();



    }
    @GetMapping(value = "getReservationByClientName")
    public List<ReservationDto> getReservationByClientName(@RequestParam("name") String name) {
        return reservationMapper.mapToReservationDtoList(reservationRepository.findReservationsByGuestName(name));
    }


}
