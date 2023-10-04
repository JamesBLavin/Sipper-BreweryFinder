package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcReviewDaoTests extends BaseDaoTests {
    private static final Review REVIEW_1 = new Review( 1, 1, 5, "Great beer.", "image.jpeg");
    private static final Review REVIEW_2 = new Review(2, 2, 5, "Good Beer.", "image.jpeg");
    private static final Review REVIEW_3 = new Review(3, 3, 5, "Ok beer", "image.jpeg");

    private JdbcReviewDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcReviewDao(jdbcTemplate);
    }

    @Test
    public void getAllReviews_BringsBackReviews() {
        List<Review> reviews = sut.getAllReviews();
        Assert.assertEquals("Should return all reviews", 3, reviews.size());
    }

    @Test
    public void getReview_ReturnsCorrectReview() {
        Review review1 = sut.getReview(1);
        Assert.assertEquals("Should return brewery for review_id 1", REVIEW_1.getReview_id(), review1.getReview_id());
    }


    @Test
    public void getReview_returns_null_when_id_is_not_found(){
        Review review1 = sut.getReview(5566);
        Assert.assertNull(review1);
    }

    @Test
    public void addReview_ReturnsNewReview(){
        Review testReview = new Review(2, 3, "Meh.", "Beer5", 1, "image.jpeg");
        Review addedReview =sut.addReview(testReview);
        int newId = addedReview.getReview_id();
        Assert.assertTrue("This should create a new review id that is greater than 0", newId > 0);
        Review retrievedReview = sut.getReview(newId);
        Assert.assertEquals(addedReview.getStar_rating(), retrievedReview.getStar_rating());
    }

    @Test
    public void updateBrewery_ReturnsUpdatedBrewery() {
        Review testReview = new Review(2, 3, "Meh.", "image.jpeg");
        Review updatedReview = sut.updateReview(testReview, 1);
        Assert.assertEquals(testReview, updatedReview);
    }



    private void assertReviewsMatch(Review expected, Review actual) {
        Assert.assertEquals("The reviewers do not match", expected.getUser_id(), actual.getUser_id());
        Assert.assertEquals("The review ids do not match", expected.getReview_id(), actual.getReview_id());
        Assert.assertEquals("The beer ids do not match", expected.getBeer_id(), actual.getReview_id());
        Assert.assertEquals("The star ratings do not match", expected.getStar_rating(), actual.getStar_rating());
        Assert.assertEquals("The review comments do not match", expected.getReview_comments(), actual.getReview_comments());
    }

}
