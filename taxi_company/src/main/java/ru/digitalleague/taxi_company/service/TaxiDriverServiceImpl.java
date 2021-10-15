package ru.digitalleague.taxi_company.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.mapper.TaxiDriverMapper;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;

@Service
@Slf4j
public class TaxiDriverServiceImpl implements TaxiDriverService {

    @Autowired
    private TaxiDriverMapper taxiDriverMapper;

    @Override
    public Long getDriverId(OrderDetails orderDetails) {
        return taxiDriverMapper.getDriverIdByCityCarLevel(orderDetails);
    }

    @Override
    public Long getMinuteCost(Order order) {
        return taxiDriverMapper.getMinuteCostByDriverId(order);
    }

    @Override
    public void setDriverBusyIndicatorFalse(Order order) {
        taxiDriverMapper.setBusyIndicatorFalse(order);
    }

    @Override
    public void setDriverBusyIndicatorTrue(Order order) {
        taxiDriverMapper.setBusyIndicatorTrue(order);
    }


}
