package com.techelevator.controller;

import com.techelevator.Services.BeerService;
import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value="http://localhost:8080")
public class BeerController {
    @Autowired
    private BeerService beerService;

    @GetMapping(path="/allBeers")
    public List<Beer> getAllBeers(){
        return beerService.getAllBeers();
    }

    @GetMapping(path="/beer/{beer_id}")
    public Beer getBeer(@PathVariable int beer_id){
        return beerService.getBeer(beer_id);
    }

    @GetMapping(path = "/beers/{brewery_id}")
    public List<Beer> getBeersByBrewery(@PathVariable int brewery_id){
        return beerService.getBeersByBrewery(brewery_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/addBeer")
    public Beer addBeer(@RequestBody @Valid Beer newBeer) {
        return beerService.addBeer(newBeer);
    }

    @PutMapping(path = "/updateBeer/{beer_id}")
    public Beer updateBeer(@RequestBody @Valid Beer updateBeer, @PathVariable int beer_id) {
        updateBeer.setBeer_id(beer_id);
        try {
            return beerService.updateBeer(updateBeer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found", e);
        }
    }

    @DeleteMapping(path = "/deleteBeer/{beer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable int beer_id) {
        try {
            beerService.deleteBeer(beer_id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error deleting beer");
        }
    }

}
