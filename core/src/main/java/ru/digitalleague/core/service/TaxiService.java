package ru.digitalleague.core.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.digitalleague.core.controller.OrderController;
import ru.digitalleague.core.model.OrderDetails;

@Service
@AllArgsConstructor
@Slf4j
public class TaxiService {
        private final RabbitTemplate rabbitTemplate;

        public void sendOrderToQueue(OrderDetails orderDetails){
            rabbitTemplate.convertAndSend("order", orderDetails.toString().getBytes());
        }

}
