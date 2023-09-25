package com.techelevator.model;

import java.util.Objects;

public class Beer {

    private int beer_id;
    private String beer_name;
    private String beer_description;

    private double abv;
    private int ibu;

    private int beer_rating;

    private String beer_review;

    public int getBeer_id() {
        return beer_id;
    }

    public void setBeer_id(int beer_id) {
        this.beer_id = beer_id;
    }

    public String getBeer_name() {
        return beer_name;
    }

    public void setBeer_name(String beer_name) {
        this.beer_name = beer_name;
    }

    public String getBeer_description() {
        return beer_description;
    }

    public void setBeer_description(String beer_description) {
        this.beer_description = beer_description;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public int getBeer_rating() {
        return beer_rating;
    }

    public void setBeer_rating(int beer_rating) {
        this.beer_rating = beer_rating;
    }

    public String getBeer_review() {
        return beer_review;
    }

    public void setBeer_review(String beer_review) {
        this.beer_review = beer_review;
    }

    public Beer() {
    }

    public Beer(String beer_name, String beer_description, double abv, int ibu, int beer_rating, String beer_review) {
        this.beer_name = beer_name;
        this.beer_description = beer_description;
        this.abv = abv;
        this.ibu = ibu;
        this.beer_rating = beer_rating;
        this.beer_review = beer_review;
    }

    public Beer(int beer_id, String beer_name, String beer_description, double abv, int ibu, int beer_rating, String beer_review) {
        this.beer_id = beer_id;
        this.beer_name = beer_name;
        this.beer_description = beer_description;
        this.abv = abv;
        this.ibu = ibu;
        this.beer_rating = beer_rating;
        this.beer_review = beer_review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Double.compare(beer.abv, abv) == 0 && ibu == beer.ibu && beer_rating == beer.beer_rating && Objects.equals(beer_description, beer.beer_description) && Objects.equals(beer_review, beer.beer_review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beer_description, abv, ibu, beer_rating, beer_review);
    }
}
