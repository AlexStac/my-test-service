package ru.digitalleague.taxi_company.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.mapper.OrderMapper;
import ru.digitalleague.taxi_company.mapper.TaxiDriverMapper;
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
    public void setDriverBusyIndicator(Long driverId) {
        taxiDriverMapper.setBusyIndicator(driverId);
    }


}
