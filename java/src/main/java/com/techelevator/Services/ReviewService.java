package com.techelevator.Services;

import com.techelevator.dao.ReviewDao;
import com.techelevator.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private ReviewDao reviewDao;
    @Autowired
    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }
    public List<Review> getAllReviews() {
        return reviewDao.getAllReviews();
    }
    public List<Review> getReviewsByBeerId(int beer_id) {
        return reviewDao.getReviewsByBeerId(beer_id);
    }
    public List<Review> getAllReviewsFromAUser(int user_id) {
        return reviewDao.getAllReviewsFromAUser(user_id);
    }
    public Review getReview(int review_id) {
        return reviewDao.getReview(review_id);
    }
    public Review addReview(Review newReview) {
        return reviewDao.addReview(newReview);
    }
    public Review updateReview(Review updatedReview, int id) {
        return reviewDao.updateReview(updatedReview, id);
    }
    public int deleteReview(int review_id) {
        return reviewDao.deleteReview(review_id);
    }
    public String getUsernameByReviewUserId(int user_id) {
        return reviewDao.getUsernameByReviewUserId(user_id);
    }
}
