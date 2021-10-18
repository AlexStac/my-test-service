package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.Order;

/**
 * Сервис обработки заказов.
 * */
public interface OrderService {

    void saveOrder(Order order);

    Long getOrderIdByDriverClient(Order order);

    Order getOrderTime(Order order);

    void setStartTripTime(Order order);

    void setEndTripTime(Order order);
}
