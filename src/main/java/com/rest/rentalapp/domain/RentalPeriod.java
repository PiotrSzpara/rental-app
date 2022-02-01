package com.rest.rentalapp.domain;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.Period;

@Embeddable
class RentalPeriod {
    private LocalDate begin;
    private LocalDate end;

    public RentalPeriod() {
    }

    public RentalPeriod(LocalDate start, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }
    public int countDays() {
        return Period.between(begin, end).getDays(); }

    public LocalDate getStart() { return begin; }

    public void setStart(LocalDate start) { this.begin = begin; }

    public LocalDate getEnd() { return end; }

    public void setEnd(LocalDate end) { this.end = end; }
}
