package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.OrderDetails;
import ru.digitalleague.taxi_company.model.RatingModel;
import ru.digitalleague.taxi_company.model.TaxiDriverInfoModel;

import java.util.List;

@Repository
@Mapper
public interface TaxiDriverMapper {

    @Results(id = "drivers", value = {
            @Result(property = "driverId", column = "driver_id"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "level", column = "level"),
            @Result(property = "minuteCost", column = "minute_cost"),
            @Result(property = "rating", column = "rating")
    })
    @Select("SELECT driver_id, last_name, first_name, level, minute_cost, rating " +
            "FROM taxi_drive_info tdi " +
            "INNER JOIN city_queue cq ON tdi.city_id = cq.city_id " +
            "INNER JOIN car ON tdi.car_id= car.id " +
            "WHERE cq.name = #{city} AND car.model = #{carModel} AND tdi.level = #{level} AND tdi.busy_indicator = true " +
            "ORDER BY rating DESC LIMIT 1")
    TaxiDriverInfoModel getDriver(OrderDetails orderDetails);

    @Select("SELECT minute_cost FROM taxi_drive_info " +
            "WHERE driver_id =  #{driverId}")
    Long getMinuteCostByDriverId(Order order);

    @Update("UPDATE taxi_drive_info SET busy_indicator = false where driver_id = #{driverId}")
    void setBusyIndicatorFalse(Order order);

    @Update("UPDATE taxi_drive_info SET busy_indicator = true where driver_id = #{driverId}")
    void setBusyIndicatorTrue(Order order);

    @Update("UPDATE taxi_drive_info SET rating = #{rating} where driver_id = #{driverId}")
    void setDriverRatingInTaxiDriversById(RatingModel ratingModel);
}
