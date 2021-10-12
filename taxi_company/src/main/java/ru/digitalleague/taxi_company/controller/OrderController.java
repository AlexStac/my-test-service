package ru.digitalleague.taxi_company.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.service.OrderServiceImpl;

import java.time.OffsetDateTime;

@RestController
public class OrderController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private OrderServiceImpl orderService;

    /**
     * Метод получает инфо о начале поездки.
     * */
    @PostMapping("/trip-start")
    public ResponseEntity<String> startTrip(@RequestBody Order order) {
        order.setStartTrip(OffsetDateTime.now());
        orderService.addStartTrip(order);
        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо об окончании поездки.
     * */
    @PostMapping("/trip-complete")
    public ResponseEntity<String> completeTrip(@RequestBody Order order) {
        order.setEndTrip(OffsetDateTime.now());
        orderService.addEndTrip(order);
        return ResponseEntity.ok("Услуга оказана");
    }
}
