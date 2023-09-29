package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    public List<Review> getAllReviews();
    public Review getReview(int review_id);
    public Review addReview(Review newReview);
    public Review updateReview(Review updatedReview, int id);
    public int deleteReview(int review_id);
}
