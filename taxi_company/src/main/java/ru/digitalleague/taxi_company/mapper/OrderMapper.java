package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import ru.digitalleague.taxi_company.model.Order;

@Repository
@Mapper
public interface OrderMapper {

    /**
     * Сохранить заказ.
     *
     * @param order информация о заказе.
     */
    @Insert(" insert into orders (order_id, client_number, driver_id, start_trip, end_trip)" +
            " values(#{orderId}, #{clientNumber}, #{driverId}, #{startTrip}, #{endTrip})")
    void saveOrder(Order order);

    /**
     * Установить время начала заказа.
     */
    @Update("update orders set start_trip = #{startTrip} where order_id = #{orderId}")
    void startTripById(Order order);

    /**
     * Установить время окончания заказа.
     */
    @Update("update orders set end_trip = #{endTrip} where order_id = #{orderId}")
    void endTripById(Order order);
}
