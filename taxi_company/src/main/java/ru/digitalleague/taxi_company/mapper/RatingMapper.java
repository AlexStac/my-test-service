package ru.digitalleague.taxi_company.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;
import ru.digitalleague.taxi_company.model.Order;
import ru.digitalleague.taxi_company.model.RatingModel;

@Repository
@Mapper
public interface RatingMapper {

    /**
     * Найти рейтинг водителя и количество оценок из таблицы driver_rating.
     *
     * @param ratingModel инфо рейтинга.
     */
    @Results(id = "rating", value = {
            @Result(property = "rating", column = "rating"),
            @Result(property = "countRating", column = "count_rating")
    })
    @Select("select rating, count_rating from driver_rating " +
            "where driver_id = #{driverId}")
    RatingModel getRatingByDriverId(RatingModel ratingModel);

    /**
     * Обновить рейтинг водителя и количество оценок из таблицы driver_rating.
     *
     * @param ratingModel инфо рейтинга.
     */
    @Update("update driver_rating " +
            "set rating = #{rating}, count_rating = #{countRating} " +
            "where driver_id = #{driverId}")
    void setRatingByDriverId(RatingModel ratingModel);
}
