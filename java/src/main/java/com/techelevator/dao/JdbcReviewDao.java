package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcReviewDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Review> getAllReviews() {
        String sql = "SELECT review_id, beer_id, star_rating, review_comments FROM reviews;";
        List<Review> results = new ArrayList<>();
        try {
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql);
            while (queryResults.next()){
                Review currentReview = mapReview(queryResults);
                results.add(currentReview);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Review getReview(int review_id) {
        Review review = null;
        String sql = "SELECT review_id, beer_id, star_rating, review_comments FROM reviews WHERE review_id = ?;";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, review_id);
            if(results.next()) {
                review = mapReview(results);
            }
        }catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public Review addReview(Review newReview) {
        String sql = "INSERT INTO reviews (beer_id, star_rating, review_comments) VALUES (?, ?, ?) RETURNING review_id;";

        try {
            Integer newReviewId = jdbcTemplate.queryForObject(sql, int.class, newReview.getBeer_id(), newReview.getStar_rating(), newReview.getReview_comments());
            newReview = getReview(newReviewId);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation", e);
        }

        return newReview;
    }

    @Override
    public Review updateReview(Review updatedReview) {
        Review review = null;
        String sql = "UPDATE reviews SET beer_id = ?, star_rating = ?, review_comments = ? WHERE review_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, review.getBeer_id(), review.getStar_rating(), review.getReview_comments());

            if (numberOfRows == 0){
                throw new DataAccessException("Zero rows affected, expected at least one") {
                };
            } else {
                updatedReview = getReview(review.getReview_id());
            }
        }catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation", e);
        }
        return updatedReview;
    }

    @Override
    public int deleteReview(int review_id) {
        int numberOfRowsDeleted = 0;
        String sql = "DELETE FROM reviews WHERE review_id = ?;";

        try {
            numberOfRowsDeleted = jdbcTemplate.update(sql, review_id);
        }catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        }
        return numberOfRowsDeleted;
    }

    private Review mapReview(SqlRowSet row){
        Review review = new Review();
        int review_id = row.getInt("review_id");
        int beer_id = row.getInt("beer_id");
        int star_rating = row.getInt("star_rating");
        String review_comments = row.getString("review_comments");

        review = new Review(review_id, beer_id, star_rating, review_comments);
        return review;
    }
}