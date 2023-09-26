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

    private String street_address;
    private String city;
    private String state;
    private int zip;

    private String brewer;
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

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getBrewer() {
        return brewer;
    }

    public void setBrewer(String brewer) {
        this.brewer = brewer;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Brewery() {
    }

    public Brewery(String brewery_name, String contact_info, String brewery_history, String operating_hours, String brewery_img_url,
                   String street_address, String city, String state, int zip, String brewer, boolean isActive) {
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.brewer = brewer;
        this.isActive = isActive;
    }

    public Brewery(int brewery_id, String brewery_name, String contact_info, String brewery_history, String operating_hours,
                   String brewery_img_url, String street, String city, String state, int zip, String brewer, boolean isActive) {
        this.brewery_id = brewery_id;
        this.brewery_name = brewery_name;
        this.contact_info = contact_info;
        this.brewery_history = brewery_history;
        this.operating_hours = operating_hours;
        this.brewery_img_url = brewery_img_url;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.brewer = brewer;
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
                ", street_address='" + street_address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", brewer='" + brewer + '\'' +
                ", isActive=" + isActive +
                '}';
    }


    // equals boolean compares if two breweries are the same


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brewery brewery = (Brewery) o;
        return zip == brewery.zip && isActive == brewery.isActive && Objects.equals(contact_info, brewery.contact_info) && Objects.equals(brewery_history, brewery.brewery_history) && Objects.equals(operating_hours, brewery.operating_hours) && Objects.equals(brewery_img_url, brewery.brewery_img_url) && Objects.equals(street_address, brewery.street_address) && Objects.equals(city, brewery.city) && Objects.equals(state, brewery.state) && Objects.equals(brewer, brewery.brewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact_info, brewery_history, operating_hours, brewery_img_url, street_address, city, state, zip, brewer, isActive);
    }
}
