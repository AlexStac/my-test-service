package ru.digitalleague.taxi_company.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

import java.util.List;

@Component
@Slf4j
public class OrderListener implements MessageListener {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    OrderService orderService;

    @Autowired
    TaxiDriverService taxiDriverService;

    @Override
    @SneakyThrows
    public void onMessage(Message message) {

        log.info("Received message from rabbitmq " + message);

        Order order = new Order();

        log.info("Received message from rabbitmq " + message);

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] body = message.getBody();
        OrderDetails orderDetails = objectMapper.readValue(body, OrderDetails.class);

        TaxiDriverInfoModel driverDetails = taxiDriverService.getDriver(orderDetails);
        Long driverId = driverDetails.getDriverId();
        log.info("taxi driver id " + driverDetails.getDriverId());
        log.info("К вам приедет {} {}.\n" +
                "Стоимость одной минуты поездки {} рублей.", driverDetails.getFirstName(), driverDetails.getLastName(), driverDetails.getMinuteCost());

        order.setClientNumber(orderDetails.getClientNumber());
        order.setDriverId(driverId);

        orderService.saveOrder(order);
    }
}
