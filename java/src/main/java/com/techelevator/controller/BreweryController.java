package com.techelevator.controller;

import com.techelevator.Services.BreweryService;
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
    private BreweryService breweryService;

    @GetMapping(path="/allBreweries")
    public List<Brewery> getAllBreweries(){
        return breweryService.getAllBreweries();
    }

    @GetMapping(path="/brewery/{brewery_id}")
    public Brewery getBrewery(@PathVariable int brewery_id){
        return breweryService.getBrewery(brewery_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/addBrewery")
    public Brewery addBrewery(@RequestBody @Valid Brewery newBrewery) {
        return breweryService.addBrewery(newBrewery);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_BREWER')")
    @PutMapping(path = "/updateBrewery/{brewery_id}")
    public Brewery updateBrewery(@RequestBody @Valid Brewery updateBrewery, @PathVariable int brewery_id) {
        updateBrewery.setBrewery_id(brewery_id);
        try {
            return breweryService.updateBrewery(updateBrewery);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found", e);
        }
    }

}
