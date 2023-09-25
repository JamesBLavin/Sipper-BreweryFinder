package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    public List<Brewery> getAllBreweries();
    public Brewery getBrewery(int brewery_id);

    public Brewery addBrewery(Brewery newBrewery);

    public Brewery updateBrewery(Brewery updatedBrewery);

}
