package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.Order;

import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.RatingModel;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

import java.util.List;

public interface TaxiDriverService {

    Long getMinuteCost(Order order);

    TaxiDriverInfoModel getDriver(OrderDetails orderDetails);

    void setDriverBusyIndicatorFalse(Order order);

    void setDriverBusyIndicatorTrue(Order order);

    void setDriverRating(RatingModel ratingModel);
}
