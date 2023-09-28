package com.techelevator.model;

import java.util.Objects;

public class  Brewery {

    //these are the 5 required properties to show when a user views brewery info, plus an id

    private int brewery_id;
    private String brewery_name;

    private String contact_info;

    private String brewery_history;

    private String operating_hours;

    private String brewery_img_url;
    private String brewery_address;
    private String brewery_city;
    private String brewery_state;
    private int brewery_zip;

    private boolean isActive;
    private String brewer;

    // getters and setters for each

    public int getBrewery_id() {
        return brewery_id;
    }

    public void setBrewery_id(int brewery_id) {
        this.brewery_id = brewery_id;
    }

    public String getBrewery_name() {
        return brewery_name;
    }

    public void setBrewery_name(String brewery_name) {
        this.brewery_name = brewery_name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getBrewery_history() {
        return brewery_history;
    }

    public void setBrewery_history(String brewery_history) {
        this.brewery_history = brewery_history;
    }

    public String getOperating_hours() {
        return operating_hours;
    }

    public void setOperating_hours(String operating_hours) {
        this.operating_hours = operating_hours;
    }

    public String getBrewery_img_url() {
        return brewery_img_url;
    }

    public void setBrewery_img_url(String brewery_img_url) {
        this.brewery_img_url = brewery_img_url;
    }

    public String getBrewery_address() {
        return brewery_address;
    }

    public void setBrewery_address(String brewery_address) {
        this.brewery_address = brewery_address;
    }

    public String getBrewery_city() {
        return brewery_city;
    }

    public void setBrewery_city(String brewery_city) {
        this.brewery_city = brewery_city;
    }

    public String getBrewery_state() {
        return brewery_state;
    }

    public void setBrewery_state(String brewery_state) {
        this.brewery_state = brewery_state;
    }

    public int getBrewery_zip() {
        return brewery_zip;
    }

    public void setBrewery_zip(int brewery_zip) {
        this.brewery_zip = brewery_zip;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getBrewer() {
        return brewer;
    }

    public void setBrewer(String brewer) {
        this.brewer = brewer;
    }

    public Brewery() {
    }

    public Brewery(String brewery_name, String contact_info, String brewery_history, String operating_hours, String brewery_img_url, String brewery_address, String brewery_city, String brewery_state, int brewery_zip, boolean isActive, String brewer) {
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.brewery_address = brewery_address;
        this.brewery_city = brewery_city;
        this.brewery_state = brewery_state;
        this.brewery_zip = brewery_zip;
        this.isActive = isActive;
        this.brewer = brewer;
    }

    public Brewery(int brewery_id, String brewery_name, String contact_info, String brewery_history, String operating_hours, String brewery_img_url, String brewery_address, String brewery_city, String brewery_state, int brewery_zip, boolean isActive, String brewer) {
        this.brewery_id = brewery_id;
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.brewery_address = brewery_address;
        this.brewery_city = brewery_city;
        this.brewery_state = brewery_state;
        this.brewery_zip = brewery_zip;
        this.isActive = isActive;
        this.brewer = brewer;
    }

    public Brewery(int brewery_id, String brewery_name, String contact_info, String brewery_history, String operating_hours, String brewery_img_url, String brewery_address, String brewery_city, String brewery_state, int brewery_zip, boolean isActive) {
        this.brewery_id = brewery_id;
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.brewery_address = brewery_address;
        this.brewery_city = brewery_city;
        this.brewery_state = brewery_state;
        this.brewery_zip = brewery_zip;
        this.isActive = isActive;
    }
}
