package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.OrderDetails;

public interface TaxiDriverService {

    Long getDriverId(OrderDetails orderDetails);

    void setDriverBusyIndicator(Long driverId);
}
