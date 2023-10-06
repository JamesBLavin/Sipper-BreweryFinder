package com.techelevator.dao;

import com.techelevator.model.Review;
import com.techelevator.model.User;
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
    public JdbcReviewDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getAllReviews() {
        String sql = "SELECT b.beer_name, review_id, user_id, b.beer_id, star_rating, review_comments, review_img_url FROM reviews r JOIN beers b ON b.beer_id = r.beer_id ORDER BY random();";
        List<Review> results = new ArrayList<>();
        try {
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql);
            while (queryResults.next()){
                Review currentReview = mapReviewAndBeerName(queryResults);
                results.add(currentReview);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }
    @Override
    public List<Review> getReviewsByBeerId(int beer_id) {
        String sql = "SELECT review_id, user_id, beer_id, star_rating, review_comments, review_img_url FROM reviews WHERE beer_id = ? ORDER BY review_id DESC;";
        List<Review> results = new ArrayList<>();
        try {
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql, beer_id);
            while (queryResults.next()){
                Review currentReview = mapReviewAndUsername(queryResults);
                results.add(currentReview);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Review> getAllReviewsFromAUser(int user_id) {
        String sql = "SELECT b.beer_name, review_id, r.user_id, b.beer_id, star_rating, review_comments, review_img_url " +
                        "FROM reviews r JOIN beers b ON b.beer_id = r.beer_id WHERE r.user_id = ? ORDER BY review_id DESC;";
        List<Review> results = new ArrayList<>();
        try {
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql, user_id);
            while (queryResults.next()){
                Review currentReview = mapReviewAndBeerName(queryResults);
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
        String sql = "SELECT review_id, beer_id, star_rating, review_comments, user_id, review_img_url FROM reviews WHERE review_id = ?;";

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
    public String getUsernameByReviewUserId(int user_id) {
        String username = "";
        String sql = "SELECT users.username FROM users JOIN reviews on users.user_id = reviews.user_id WHERE reviews.user_id = ? GROUP BY users.username";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, user_id);
            if (results.next()) {
                username = results.getString("username");
            }
        } catch (Exception e) {
            System.out.println("Error occurred accessing this username.");
            e.getStackTrace();
        }
        return username;
    }


    @Override
    public Review addReview(Review newReview) {
        String sql = "INSERT INTO reviews (beer_id, user_id, star_rating, review_comments, review_img_url) VALUES (?, ?, ?, ?, ?) RETURNING review_id;";

        try {
            Integer newReviewId = jdbcTemplate.queryForObject(sql, int.class, newReview.getBeer_id(), newReview.getUser_id(), newReview.getStar_rating(), newReview.getReview_comments(), newReview.getReview_img_url());
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
    public Review updateReview(Review updatedReview, int id) {
        String sql = "UPDATE reviews SET beer_id = ?, star_rating = ?, review_comments = ?, review_img_url = ? WHERE review_id = ?;";
        updatedReview.setReview_id(id);
        try {
           jdbcTemplate.update(sql, updatedReview.getBeer_id(), updatedReview.getStar_rating(), updatedReview.getReview_comments(), updatedReview.getReview_img_url(), updatedReview.getReview_id());

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
        String review_img_url = row.getString("review_img_url");

        review = new Review(review_id, beer_id, star_rating, review_comments, review_img_url);
        return review;
    }

    private Review mapReviewAndBeerName(SqlRowSet row){
        Review review = new Review();
        int review_id = row.getInt("review_id");
        int beer_id = row.getInt("beer_id");
        int star_rating = row.getInt("star_rating");
        String review_comments = row.getString("review_comments");
        String beer_name = row.getString("beer_name");
        int user_id = row.getInt("user_id");
        String review_img_url = row.getString("review_img_url");

        review = new Review(review_id, beer_id, star_rating, review_comments, beer_name, user_id, review_img_url);
        return review;
    }

    private Review mapReviewAndUsername(SqlRowSet row){
        Review review = new Review();
        int review_id = row.getInt("review_id");
        int beer_id = row.getInt("beer_id");
        int star_rating = row.getInt("star_rating");
        String review_comments = row.getString("review_comments");
        int user_id = row.getInt("user_id");
        String review_img_url = row.getString("review_img_url");

        review = new Review(review_id, beer_id, star_rating, review_comments, user_id, review_img_url);
        return review;
    }

}
