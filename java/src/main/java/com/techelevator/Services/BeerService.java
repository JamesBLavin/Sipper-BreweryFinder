package com.techelevator.Services;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BeerService {

    private BeerDao beerDao;
    @Autowired
    public BeerService(BeerDao beerDao) {
        this.beerDao = beerDao;
    }
    public List<Beer> getAllBeers() {
        return beerDao.getAllBeers();
    }

    public Beer getBeer(int beer_id) {
        return beerDao.getBeer(beer_id);
    }
    public List<Beer> getBeersByBrewery(int brewery_id){
        return beerDao.getBeersByBrewery(brewery_id);
    }

    public Beer addBeer(Beer newBeer) {
        return beerDao.addBeer(newBeer);
    }

    public Beer updateBeer(Beer updatedBeer, int id) {
        return beerDao.updateBeer(updatedBeer, id);
    }

    public int deleteBeer(int beer_id) {
        return beerDao.deleteBeer(beer_id);
    }



}
