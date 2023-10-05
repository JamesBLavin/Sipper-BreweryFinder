package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;

import java.util.List;

public interface BeerDao {

    public List<Beer> getAllBeers();

    public Beer getBeer(int beer_id);

    public List<Beer> getBeersByBrewery(int brewery_id);

    public Beer addBeer(Beer newBeer);

    public Beer updateBeer(Beer updatedBeer);

    public int deleteBeer(int beer_id);



}
