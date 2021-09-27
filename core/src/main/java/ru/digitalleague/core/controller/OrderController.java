package ru.digitalleague.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.core.model.OrderDetails;
import ru.digitalleague.core.service.TaxiService;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final TaxiService taxiService;

    @PostMapping(value = "/order")
    public void sendOrderToQueue(@RequestBody OrderDetails order){
        taxiService.sendOrderToQueue(order);
    }
}
