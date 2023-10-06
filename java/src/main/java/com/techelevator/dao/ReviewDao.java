package com.techelevator.dao;

import com.techelevator.model.Review;
import com.techelevator.model.User;

import java.util.List;

public interface ReviewDao {

    public List<Review> getAllReviews();
    public List<Review> getReviewsByBeerId(int beer_id);
    public List<Review> getAllReviewsFromAUser(int user_id);
    public Review getReview(int review_id);
    public String getUsernameByReviewUserId(int user_id);
    public Review addReview(Review newReview);
    public Review updateReview(Review updatedReview, int id);
    public int deleteReview(int review_id);
}
