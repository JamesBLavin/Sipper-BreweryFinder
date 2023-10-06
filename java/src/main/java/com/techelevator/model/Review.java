package com.techelevator.model;

public class Review {

    //Creating getters and setters for these components being used for the database
    private int review_id;
    private int beer_id;
    private int star_rating;
    private String review_comments;
    private String beer_name;
    private int user_id;

    public String review_img_url;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBeer_name() {
        return beer_name;
    }

    public void setBeer_name(String beer_name) {
        this.beer_name = beer_name;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getBeer_id() {
        return beer_id;
    }

    public void setBeer_id(int beer_id) {
        this.beer_id = beer_id;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    public String getReview_comments() {
        return review_comments;
    }

    public String getReview_img_url() {
        return review_img_url;
    }

    public void setReview_img_url(String review_img_url) {
        this.review_img_url = review_img_url;
    }

    public void setReview_comments(String review_comments) {
        this.review_comments = review_comments;
    }
    //A empty constructor so we can create a new review with no data
    public Review() {
    }
    //A constructor so we can make a new review with data that gets a review_id
    public Review(int beer_id, int star_rating, String review_comments, String review_img_url) {
        this.beer_id = beer_id;
        this.star_rating = star_rating;
        this.review_comments = review_comments;
        this.review_img_url = review_img_url;
    }
    //A constructor with all the components (to retrieve a review from the database)
    public Review(int review_id, int beer_id, int star_rating, String review_comments, String review_img_url) {
        this.review_id = review_id;
        this.beer_id = beer_id;
        this.star_rating = star_rating;
        this.review_comments = review_comments;
        this.review_img_url = review_img_url;
    }

    //A constructor with all the components (+ a beer name)(to retrieve a review from the database)

    public Review(int review_id, int beer_id, int star_rating, String review_comments, String beer_name, int user_id, String review_img_url) {
        this.review_id = review_id;
        this.beer_id = beer_id;
        this.star_rating = star_rating;
        this.review_comments = review_comments;
        this.beer_name = beer_name;
        this.user_id = user_id;
        this.review_img_url = review_img_url;
    }

    public Review(int beer_id, int star_rating, String review_comments, String beer_name, int user_id, String review_img_url) {
        this.beer_id = beer_id;
        this.star_rating = star_rating;
        this.review_comments = review_comments;
        this.beer_name = beer_name;
        this.user_id = user_id;
        this.review_img_url = review_img_url;
    }

    public Review(int review_id, int beer_id, int star_rating, String review_comments, int user_id, String review_img_url) {
        this.review_id = review_id;
        this.beer_id = beer_id;
        this.star_rating = star_rating;
        this.review_comments = review_comments;
        this.user_id = user_id;
        this.review_img_url = review_img_url;
    }
}
