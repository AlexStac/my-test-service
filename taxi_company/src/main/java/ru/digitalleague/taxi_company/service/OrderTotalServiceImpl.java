package ru.digitalleague.taxi_company.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.api.OrderTotalService;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.mapper.OrderTotalMapper;
import ru.digitalleague.taxi_company.model.Order;

import java.time.Duration;

@Service
@Slf4j
public class OrderTotalServiceImpl implements  OrderTotalService{

    @Autowired
    private OrderTotalMapper orderTotalMapper;

    @Autowired
    private TaxiDriverService taxiDriverService;

    @Autowired
    private OrderService orderService;

    @Override
    public void saveOrderTotal(Order order) {
        Order orderTime = orderService.getOrderTime(order);
        Long tripTime = Duration.between(orderService.getOrderTime(order).getStartTrip(), orderService.getOrderTime(order).getEndTrip()).toMinutes();
        log.info("Длительность поездки составила {} минут", tripTime);

        Long trimSum = tripTime * taxiDriverService.getMinuteCost(order);
        log.info("Стоимость поездки составила {} рублей", trimSum);
        orderTotalMapper.saveOrderTotalByOrderId(order.getOrderId(), trimSum);
    }
}
