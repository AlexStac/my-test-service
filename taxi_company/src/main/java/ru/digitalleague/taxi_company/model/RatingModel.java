package ru.digitalleague.taxi_company.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RatingModel {
    /**
     * Идентификатор водителя.
     */
    private Long driverId;

    /**
     * Идентификатор поездки.
     */
    private BigDecimal rating;

    /**
     * Идентификатор поездки.
     */
    private int countRating;
}
