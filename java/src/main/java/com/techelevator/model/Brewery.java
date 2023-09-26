package com.techelevator.model;

import java.util.Objects;

public class Brewery {

    //these are the 5 required properties to show when a user views brewery info, plus an id

    private int brewery_id;
    private String brewery_name;

    private String contact_info;

    private String brewery_history;

    private String operating_hours;

    private String brewery_img_url;

    private String brewery_address;

    private boolean isActive;

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


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Brewery() {
    }

    public Brewery(String brewery_name, String contact_info, String brewery_history, String operating_hours, String brewery_img_url, String brewery_address, String brewer, boolean isActive) {
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.brewery_address = brewery_address;
        this.isActive = isActive;
    }

    public Brewery(int brewery_id, String brewery_name, String contact_info, String brewery_history, String operating_hours, String brewery_img_url, String brewery_address, boolean isActive) {
        this.brewery_id = brewery_id;
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.brewery_address = brewery_address;
        this.isActive = isActive;
    }

    // to string

    @Override
    public String toString() {
        return "Brewery{" +
                "brewery_id=" + brewery_id +
                ", brewery_name='" + brewery_name + '\'' +
                ", contact_info='" + contact_info + '\'' +
                ", brewery_history='" + brewery_history + '\'' +
                ", operating_hours='" + operating_hours + '\'' +
                ", brewery_img_url='" + brewery_img_url + '\'' +
                ", brewery_address='" + brewery_address + '\'' +
                '}';
    }

    // equals boolean compares if two breweries are the same

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brewery brewery = (Brewery) o;
        return contact_info.equals(brewery.contact_info) && brewery_history.equals(brewery.brewery_history) && operating_hours.equals(brewery.operating_hours) && brewery_img_url.equals(brewery.brewery_img_url) && brewery_address.equals(brewery.brewery_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address);
    }
}
