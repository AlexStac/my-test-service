package ru.digitalleague.core.model;

public class Order {

    /**
     * Идентификатор клиента.
     */
    private Long clientNumber;

    /**
     * Желаемый класс поездки (бизнес, эконом, и т.п.)
     */
    private int level;

    /**
     * Должна быть enum.
     */
    private String carModel;

    /**
     * Название города.
     */
    private String city;
}
