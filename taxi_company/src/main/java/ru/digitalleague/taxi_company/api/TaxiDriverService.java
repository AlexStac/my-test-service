package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.Order;

import ru.digitalleague.taxi_company.model.OrderDetails;

public interface TaxiDriverService {

    Long getDriverId(OrderDetails orderDetails);

    Long getMinuteCost(Order order);

    void setDriverBusyIndicatorFalse(Order order);

    void setDriverBusyIndicatorTrue(Order order);
}
