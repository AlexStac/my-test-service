package ru.digitalleague.taxi_company.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.mapper.TaxiDriverMapper;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.RatingModel;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;


/**
 * Сервис обработки информации о водителях.
 */
@Service
@Slf4j
public class TaxiDriverServiceImpl implements TaxiDriverService {

    @Autowired
    private TaxiDriverMapper taxiDriverMapper;

    /**
     * Находит информацию по конкретному водителю.
     * @param orderDetails инфо деталях заказа.
     * */
    @Override
    public TaxiDriverInfoModel getDriver(OrderDetails orderDetails) {
        return taxiDriverMapper.getDriver(orderDetails);
    }

    /**
     * Находит информацию по конкретному водителю.
     * @param order инфо заказа.
     * */
    @Override
    public Long getMinuteCost(Order order) {
        return taxiDriverMapper.getMinuteCostByDriverId(order);
    }

    /**
     * Поменять статус водителя на "занят".
     *
     * @param order инфо заказ.
     */
    @Override
    public void setDriverBusyIndicatorFalse(Order order) {
        taxiDriverMapper.setBusyIndicatorFalse(order);
    }

    /**
     * Поменять статус водителя на "свободен".
     *
     * @param order инфо заказ.
     */
    @Override
    public void setDriverBusyIndicatorTrue(Order order) {
        taxiDriverMapper.setBusyIndicatorTrue(order);
    }

    /**
     * Установить рейтинг водителю.
     *
     * @param ratingModel рейтинг поездки.
     */
    @Override
    public void setDriverRating(RatingModel ratingModel) {
        taxiDriverMapper.setDriverRatingInTaxiDriversById(ratingModel);
    }
}
