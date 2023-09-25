package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value="http://localhost:8080")
public class BreweryController {
    @Autowired
    private BreweryDao breweryDao;

    @RequestMapping(path="/allBreweries", method= RequestMethod.GET)
    public List<Brewery> getAllBreweries(){
        return breweryDao.getAllBreweries();
    }

    @RequestMapping(path="/brewery/{brewery_id}", method= RequestMethod.GET)
    public Brewery getBrewery(@PathVariable int brewery_id){
        return breweryDao.getBrewery(brewery_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addBrewery", method = RequestMethod.POST)
    public Brewery addBrewery(@RequestBody @Valid Brewery newBrewery) {
        return breweryDao.addBrewery(newBrewery);
    }

    @RequestMapping(path = "updateBrewery/{brewery_id}", method = RequestMethod.PUT)
    public Brewery updateBrewery(@RequestBody @Valid Brewery updateBrewery, @PathVariable int brewery_id) {
        updateBrewery.setBrewery_id(brewery_id);
        try {
            return breweryDao.updateBrewery(updateBrewery);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found", e);
        }
    }

}
