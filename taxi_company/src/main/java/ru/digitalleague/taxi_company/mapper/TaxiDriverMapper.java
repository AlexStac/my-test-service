package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
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
            @Result(property = "createDttm", column = "create_dttm"),
            @Result(property = "minuteCost", column = "minute_cost"),
            @Result(property = "busyIndicator", column = "busy_indicator"),
            @Result(property = "rating", column = "rating"),
            @Result(property = "cityId", column = "city_id"),
            @Result(property = "carId", column = "car_id")
    })
    @Select("SELECT driver_id, last_name, first_name, level, car_model, create_dttm FROM taxi_drive_info")
    List<TaxiDriverInfoModel> getAllDrivers();
}
