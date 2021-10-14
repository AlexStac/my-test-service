package ru.digitalleague.taxi_company.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class TaxiDriverInfoModel {

    /**
     * Идентификатор водителя.
     */
    private Long driverId;

    /**
     * Фамилия.
     */
    private String lastName;

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Уровень автомобиля.
     */
    private int level;

    /**
     * Дата создания.
     */
    private OffsetDateTime createDttm;

    /**
     * Стоимость одной минуты.
     */
    private int minuteCost;

    /**
     * Индикатор занятости водителя (true - свободен).
     */
    private boolean busyIndicator;

    /**
     * Рейтинг водителя.
     */
    private int rating;

    /**
     * id города.
     */
    private int cityId;

    /**
     * id автомобился.
     */
    private int carId;
}