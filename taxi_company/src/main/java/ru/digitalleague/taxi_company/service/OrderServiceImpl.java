package ru.digitalleague.taxi_company.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.digitalleague.taxi_company.api.OrderService;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.model.Order;

/**
 * Сервис обработки заказов.
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * Сохраняет заказ по id клиента и водителя.
     * @param order инфо заказа
     * */
    @Override
    public void saveOrder(Order order) {

        orderMapper.saveOrderByDriverClient(order);
        System.out.println("Order saved");
    }

    /**
     * Находит заказ по id клиента и водителя.
     * @param order инфо заказа
     * */
    @Override
    public Long getOrderIdByDriverClient(Order order) {
        return orderMapper.getOrderIdByDriverClient(order);
    }

    /**
     * Находит время заказа по id клиента и водителя.
     * @param order инфо заказа
     * */
    @Override
    public Order getOrderTime(Order order) {
        return orderMapper.getOrderTimeByOrderId(order);
    }

    /**
     * Устанавливает время начала поездки.
     * @param order инфо заказа
     * */
    @Override
    public void setStartTripTime(Order order) {
        orderMapper.startTripById(order);
        System.out.println("Set order start");
    }
    /**
     * Устанавливает время окончания поездки.
     * @param order инфо заказа
     * */
    @Override
    public void setEndTripTime(Order order) {
        orderMapper.endTripById(order);
        System.out.println("Set order end");

    }
}
