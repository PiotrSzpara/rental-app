package com.rest.rentalapp.mapper;

import com.rest.rentalapp.domain.Apartment;
import com.rest.rentalapp.domain.ApartmentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ApartmentMapper {

    public Apartment mapToApartment(final ApartmentDto apartmentDto) {
        return new Apartment(
                apartmentDto.getApartmentId(),
                apartmentDto.getName(),
                apartmentDto.getPrice(),
                apartmentDto.getArea(),
                apartmentDto.getDescription()
        );
    }

    public ApartmentDto mapToApartmentDto(final Apartment apartment) {
        return new ApartmentDto(
                apartment.getApartmentId(),
                apartment.getName(),
                apartment.getPrice(),
                apartment.getArea(),
                apartment.getDescription()
        );
    }

    public List<ApartmentDto> mapToApartmentDtoList(final List<Apartment> apartments) {
        return apartments.stream()
                .map(this::mapToApartmentDto)
                .collect(Collectors.toList());
    }
}
