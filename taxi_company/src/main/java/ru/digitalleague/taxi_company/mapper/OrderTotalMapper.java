package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.Order;

@Repository
@Mapper
public interface OrderTotalMapper {

    /**
     * Сохранить стоимость определённой поездки в таблицу order_total.
     *
     * @param orderId id заказа.
     * @param sum цена поездки.
     */
    @Insert("insert into order_total (order_id , sum)" +
            " values( #{orderId}, #{sum})")
    void saveOrderTotalByOrderId(Long orderId , Long sum);
}
