package ru.digitalleague.taxi_company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.taxi_company.api.RatingService;
import ru.digitalleague.taxi_company.mapper.RatingMapper;
import ru.digitalleague.taxi_company.model.RatingModel;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingMapper ratingMapper;


    @Override
    public RatingModel getDriverRating(RatingModel ratingModel) {
        return ratingMapper.getRatingByDriverId(ratingModel);
    }

    @Override
    public void setDriverRating(RatingModel ratingModel) {
        ratingMapper.setRatingByDriverId(ratingModel);
    }
}
