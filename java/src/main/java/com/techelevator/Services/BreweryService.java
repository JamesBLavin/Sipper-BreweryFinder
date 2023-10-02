package com.techelevator.Services;

import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@Service
public class BreweryService {

    private BreweryDao breweryDao;
    @Autowired
    public BreweryService(BreweryDao breweryDao) {
        this.breweryDao = breweryDao;
    }

    public List<Brewery> getAllBreweries(String query, String searchType) {
        List<Brewery> breweries = new ArrayList<>();
        if (query.equalsIgnoreCase("")) {
            breweries = breweryDao.getAllBreweries();
        } else if (searchType.equalsIgnoreCase("brewery_name")) {
            query = "%" + query + "%";
            breweries = breweryDao.getAllBreweriesByName(query);
        } else if (searchType.equalsIgnoreCase("brewery_city")) {
            query = "%" + query + "%";
            breweries = breweryDao.getAllBreweriesByCity(query);
        } else if (searchType.equalsIgnoreCase("brewery_zip")) {
            breweries = breweryDao.getAllBreweriesByZip(Integer.parseInt(query));
        }
        return breweries;
    }

    public Brewery getBreweryByBrewer(String username) {
        return breweryDao.getBreweryByBrewer(username);
    }

    public Brewery getBrewery(int brewery_id) {
        return breweryDao.getBrewery(brewery_id);
    }

    public Brewery addBrewery(Brewery newBrewery) {
            breweryDao.updateUserRoleToBrewer(newBrewery);
        return breweryDao.addBrewery(newBrewery);
    }

    public Brewery updateBrewery(Brewery updatedBrewery, int id){
        return breweryDao.updateBrewery(updatedBrewery, id);
    }
}
