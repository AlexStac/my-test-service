package ru.digitalleague.taxi_company.api;

import ru.digitalleague.taxi_company.model.RatingModel;

public interface RatingService {

    RatingModel getDriverRating(RatingModel ratingModel);

    void setDriverRating(RatingModel ratingModel);
}
