package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {

    public List<Brewery> getAllBreweries();
    public List<Brewery> getAllBreweriesByName();
    public List<Brewery> getAllBreweriesByCity();
    public List<Brewery> getAllBreweriesByZip();
    public Brewery getBrewery(int brewery_id);

    public Brewery addBrewery(Brewery newBrewery);

    public Brewery updateBrewery(Brewery updatedBrewery);

    public void updateUserRoleToBrewer(Brewery brewery);

}
