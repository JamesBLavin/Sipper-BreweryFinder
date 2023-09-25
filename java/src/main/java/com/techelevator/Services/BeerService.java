package com.techelevator.Services;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BeerService {
    @Autowired
    private BeerDao beerDao;
    public BeerService(BeerDao beerDao) {
        this.beerDao = beerDao;
    }
    public List<Beer> getAllBeers() {
        return beerDao.getAllBeers();
    }

    public Beer getBeer(int beer_id) {
        return beerDao.getBeer(beer_id);
    }

    public Beer addBeer(Beer newBeer) {
        return beerDao.addBeer(newBeer);
    }

    public Beer updateBeer(Beer updatedBeer) {
        return beerDao.updateBeer(updatedBeer);
    }

    public int deleteBeer(int beer_id) {
        return beerDao.deleteBeer(beer_id);
    }

    public Beer getBeerRatingAndReview(int beer_id) {
        return beerDao.getBeerRatingAndReview(beer_id);
    }

}
