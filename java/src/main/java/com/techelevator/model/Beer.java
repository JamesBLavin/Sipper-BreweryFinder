package com.techelevator.model;

import java.util.Objects;

public class Beer {

    private int beer_id;
    private int brewery_id;
    private String beer_name;
    private String beer_description;

    private double abv;
    private int ibu;
    private String beer_img_url;
    private String beer_type;
    private int avg_rating;

    public int getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(int avg_rating) {
        this.avg_rating = avg_rating;
    }

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

    public int getBrewery_id() {
        return brewery_id;
    }
    public void setBrewery_id(int brewery_id) {
        this.brewery_id = brewery_id;
    }

    public int getIbu() {
        return ibu;
    }

    public void setIbu(int ibu) {
        this.ibu = ibu;
    }

    public String getBeer_img_url() {
        return beer_img_url;
    }

    public void setBeer_img_url(String beer_img_url) {
        this.beer_img_url = beer_img_url;
    }

    public String getBeer_type() {
        return beer_type;
    }

    public void setBeer_type(String beer_type) {
        this.beer_type = beer_type;
    }

    public Beer() {
    }

    public Beer(int brewery_id, String beer_name, String beer_description, double abv, int ibu, String beer_img_url, String beer_type) {
        this.brewery_id = brewery_id;
        this.beer_name = beer_name;
        this.beer_description = beer_description;
        this.abv = abv;
        this.ibu = ibu;
        this.beer_img_url = beer_img_url;
        this.beer_type = beer_type;
    }

    public Beer(int beer_id, int brewery_id, String beer_name, String beer_description, double abv, int ibu, String beer_img_url, String beer_type) {
        this.beer_id = beer_id;
        this.brewery_id = brewery_id;
        this.beer_name = beer_name;
        this.beer_description = beer_description;
        this.abv = abv;
        this.ibu = ibu;
        this.beer_img_url = beer_img_url;
        this.beer_type = beer_type;
    }

    public Beer(int beer_id, int brewery_id, String beer_name, String beer_description, double abv, int ibu, String beer_img_url, String beer_type, int avg_rating) {
        this.beer_id = beer_id;
        this.brewery_id = brewery_id;
        this.beer_name = beer_name;
        this.beer_description = beer_description;
        this.abv = abv;
        this.ibu = ibu;
        this.beer_img_url = beer_img_url;
        this.beer_type = beer_type;
        this.avg_rating = avg_rating;
    }
}
