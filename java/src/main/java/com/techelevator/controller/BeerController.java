package com.techelevator.controller;

import com.techelevator.dao.BeerDao;
import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value="http://localhost:8080")
public class BeerController {
    private BeerDao beerDao;

    @RequestMapping(path="/allBeers", method= RequestMethod.GET)
    public List<Beer> getAllBeers(){
        return beerDao.getAllBeers();
    }

    @RequestMapping(path="/beer/{beer_id}", method= RequestMethod.GET)
    public Beer getBeer(@PathVariable int beer_id){
        return beerDao.getBeer(beer_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addBeer", method = RequestMethod.POST)
    public Beer addBeer(@RequestBody @Valid Beer newBeer) {
        return beerDao.addBeer(newBeer);
    }

    @RequestMapping(path = "updateBeer/{beer_id}", method = RequestMethod.PUT)
    public Beer updateBeer(@RequestBody @Valid Beer updateBeer, @PathVariable int beer_id) {
        updateBeer.setBeer_id(beer_id);
        try {
            return beerDao.updateBeer(updateBeer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found", e);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/deleteBeer/{beer_id}", method = RequestMethod.DELETE)
    public void deleteBeer(@PathVariable int beer_id) {
        try {
            int deletedBeerId = beerDao.deleteBeer(beer_id);
            if (deletedBeerId == -1) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Beer not found with ID: " + beer_id);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting beer with ID: " + beer_id, e);
        }
    }

    @RequestMapping(path = "/beer/{beer_id}/ratingReview", method = RequestMethod.GET)
    public Beer getBeerRatingAndReview(@PathVariable int beer_id) {
        return beerDao.getBeerRatingAndReview(beer_id);
    }

}
