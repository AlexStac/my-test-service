package ru.digitalleague.taxi_company.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.taxi_company.api.RatingService;
import ru.digitalleague.taxi_company.api.TaxiDriverService;
import ru.digitalleague.taxi_company.model.RatingModel;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@Slf4j
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private TaxiDriverService taxiDriverService;

    /**
     * Метод рассчитывает средний рейтинг водителя.
     * @param ratingModel инфо о выставленом рейтинге
     * */
    @PostMapping("/rating")
    @ApiOperation(value = "Контроллер учёта рейтинга водителя")
    public ResponseEntity<String> addDriverRating(@RequestBody RatingModel ratingModel) {

        RatingModel rating = ratingService.getDriverRating(ratingModel);
        int counrRating = rating.getCountRating();
        BigDecimal newRating = ((rating.getRating().multiply(BigDecimal.valueOf(counrRating))).add(ratingModel.getRating())).divide(BigDecimal.valueOf(counrRating +1), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);

        ratingModel.setRating(newRating);
        ratingModel.setCountRating(counrRating + 1);
        ratingService.setDriverRating(ratingModel);
        taxiDriverService.setDriverRating(ratingModel);

        return ResponseEntity.ok("Спасибо за оценку");
    }
}
