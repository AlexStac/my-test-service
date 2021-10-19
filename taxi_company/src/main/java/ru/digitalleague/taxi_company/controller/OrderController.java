package ru.digitalleague.taxi_company.controller;

import io.swagger.annotations.ApiOperation;
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
    private OrderService orderService;

    @Autowired
    private TaxiDriverService taxiDriverService;

    @Autowired
    private OrderTotalService orderTotalService;

    /**
     * Метод получает инфо о начале поездки.
     * @param order инфо о заказе
     * */
    @PostMapping("/trip-start")
    @ApiOperation(value = "Контроллер фиксации начала поездки")
    public ResponseEntity<String> startTrip(@RequestBody Order order) {
        taxiDriverService.setDriverBusyIndicatorFalse(order);
        orderService.setStartTripTime(order);
        return ResponseEntity.ok("Поездка началась");
    }

    /**
     * Метод получает инфо об окончании поездки.
     * @param order инфо о заказе
     * */
    @PostMapping("/trip-complete")
    @ApiOperation(value = "Контроллер фиксации окончания поездки")
    public ResponseEntity<String> completeTrip(@RequestBody Order order) {
        taxiDriverService.setDriverBusyIndicatorTrue(order);
        orderService.setEndTripTime(order);
        orderTotalService.saveOrderTotal(order);
        return ResponseEntity.ok("Услуга оказана");
    }
}
