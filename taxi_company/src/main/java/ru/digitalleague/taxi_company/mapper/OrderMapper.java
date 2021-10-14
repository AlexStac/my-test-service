package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    @Insert(" insert into orders (client_number, driver_id)" +
            " values( #{clientNumber}, #{driverId})")
    void saveOrderByDriverClient(Order order);

    @Select("select oder_id from orders " +
            "where driver_id = #{driverId} and client_number = #{clientNumber}" +
            "order by order_id DESC limit 1")
    Long getOrderIdByDriverClient(Order order);



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
