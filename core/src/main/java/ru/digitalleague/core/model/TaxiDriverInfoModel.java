package ru.digitalleague.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
