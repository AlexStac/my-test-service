package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import ru.digitalleague.taxi_company.model.Order;

@Repository
@Mapper
public interface OrderMapper {

    /**
     * Сохранить заказ в таблицу orders.
     *
     * @param order информация о заказе.
     */
    @Insert(" insert into orders (client_number, driver_id)" +
            " values( #{clientNumber}, #{driverId})")
    void saveOrderByDriverClient(Order order);

    /**
     * Найти номер заказа из таблицы orders.
     *
     * @param order информация о заказе.
     */
    @Select("select oder_id from orders " +
            "where driver_id = #{driverId} and client_number = #{clientNumber}" +
            "order by order_id DESC limit 1")
    Long getOrderIdByDriverClient(Order order);

    /**
     * Найти время начала и окончания поездки.
     *
     * @param order информация о заказе.
     */
    @Results(id = "order", value = {
            @Result(property = "startTrip", column = "start_trip"),
            @Result(property = "endTrip", column = "end_trip")
    })
    @Select("select start_trip, end_trip from orders " +
            "where order_id = #{orderId}")
    Order getOrderTimeByOrderId(Order order);

    /**
     * Установить время начала заказа.
     *
     * @param order информация о заказе.
     */
    @Update("update orders set start_trip = now() where order_id = #{orderId}")
    void startTripById(Order order);

    /**
     * Установить время окончания заказа.
     *
     * @param order информация о заказе.
     */
    @Update("update orders set end_trip = now() where order_id = #{orderId}")
    void endTripById(Order order);
}
