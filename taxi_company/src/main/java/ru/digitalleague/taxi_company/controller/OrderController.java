package ru.digitalleague.taxi_company.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.api.OrderTotalService;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.mapper.TaxiDriverMapper;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.service.OrderServiceImpl;

import java.time.OffsetDateTime;

@RestController
public class OrderController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TaxiDriverService taxiDriverService;

    @Autowired
    private OrderTotalService orderTotalService;

    /**
     * Метод получает инфо о начале поездки.
     * */
    @PostMapping("/trip-start")
    public ResponseEntity<String> startTrip(@RequestBody Order order) {
        taxiDriverService.setDriverBusyIndicatorFalse(order);
        orderService.setStartTripTime(order);
        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо об окончании поездки.
     * */
    @PostMapping("/trip-complete")
    public ResponseEntity<String> completeTrip(@RequestBody Order order) {
        taxiDriverService.setDriverBusyIndicatorTrue(order);
        orderService.setEndTripTime(order);
        orderTotalService.saveOrderTotal(order);
        return ResponseEntity.ok("Услуга оказана");
    }
}
