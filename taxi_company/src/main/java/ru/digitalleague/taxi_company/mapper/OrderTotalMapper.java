package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.Order;

@Repository
@Mapper
public interface OrderTotalMapper {

    @Insert(" insert into order_total (order_id, sum)" +
            " values( #{order_id}, #{sum})")
    void saveOrderTotalByOrderId(Order order, Long sum);
}
