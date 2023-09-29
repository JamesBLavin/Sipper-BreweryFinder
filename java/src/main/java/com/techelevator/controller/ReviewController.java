package com.techelevator.controller;

import com.techelevator.Services.ReviewService;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:8080")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping(path = "/allReviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping(path = "/review/{review_id}")
    public Review getReview(@PathVariable int review_id) {
        return reviewService.getReview(review_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/addReview")
    public Review addReview(@RequestBody @Valid Review newReview) {
        return reviewService.addReview(newReview);
    }

    @PutMapping(path = "/updateReview/{review_id}")
    public Review updateReview(@RequestBody @Valid Review updateReview, @PathVariable int review_id) {
        updateReview.setReview_id(review_id);
        try {
            return reviewService.updateReview(updateReview, review_id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found", e);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/deleteReview/{review_id}")
    public void deleteReview(@PathVariable int review_id) {

        try {
            reviewService.deleteReview(review_id);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting beer with ID: " + review_id, e);
        }
    }
}
