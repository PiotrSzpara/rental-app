package com.rest.rentalapp.domain;

import lombok.Getter;

@Getter
public class ApartmentDto {
    private int apartmentId;
    private String name;
    private double price;
    private double area;
    private String description;

    public ApartmentDto() {
    }

    public ApartmentDto(int apartmentId, String name, double price, double area, String description) {
        this.apartmentId = apartmentId;
        this.name = name;
        this.price = price;
        this.area = area;
        this.description = description;
    }

}
