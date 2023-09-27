package com.techelevator.dao;

import com.techelevator.model.Beer;
import com.techelevator.model.Brewery;
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
public class JdbcBeerDao implements BeerDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcBeerDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Beer> getAllBeers() {
        String sql = "SELECT beer_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type";
        List<Beer> results = new ArrayList<>();
        try{
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql);
            while(queryResults.next()){
                Beer currentBeer = mapBeer(queryResults);
                results.add(currentBeer);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Beer getBeer(int beer_id) {
        Beer beer = null;
        String sql = "SELECT beer_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type FROM beers WHERE beer_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beer_id);
            if (results.next()) {
                beer = mapBeer(results);
            }
        } catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return beer;
    }

    @Override
    public Beer addBeer(Beer newBeer) {
        String sql = "INSERT INTO beers (beer_name, beer_description, abv, ibu, beer_img_url, beer_type) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            int newBeerId = jdbcTemplate.queryForObject(sql, int.class,
                    newBeer.getBeer_name(), newBeer.getBeer_description(), newBeer.getAbv(), newBeer.getIbu(), newBeer.getBeer_img_url(), newBeer.getBeer_type());
            newBeer = getBeer(newBeerId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation", e);
        }
        return newBeer;
    }

    @Override
    public Beer updateBeer(Beer updatedBeer) {
        Beer beer = null;
        String sql = "UPDATE beers SET beer_name = ?, beer_description = ?, abv = ?, ibu = ?, beer_img_url = ?, beer_type = ? WHERE beer_id = ?";
        try {
            int numberOfRows = jdbcTemplate.update(sql, beer.getBeer_name(), beer.getBeer_description(), beer.getAbv(), beer.getIbu(), beer.getBeer_img_url(), beer.getBeer_type());

            if (numberOfRows == 0) {
                throw new DataAccessException("Zero rows affected, expected at least one") {
                };
            } else {
                updatedBeer = getBeer(beer.getBeer_id());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation", e);
        }
        return updatedBeer;
    }

    @Override
    public int deleteBeer(int beer_id) {
        Beer deletedBeer = getBeer(beer_id);
        String sql = "DELETE FROM beers WHERE beer_id = ?";
        int numberOfRowsDeleted;
        try {
            numberOfRowsDeleted = jdbcTemplate.update(sql, beer_id);
            if (numberOfRowsDeleted == 0) {
                throw new DataAccessException("Zero rows deleted, no beer found with ID: " + beer_id) {
                };
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        }
        return numberOfRowsDeleted;
    }


    @Override
    public Beer getBeerRatingAndReview(int beer_id) {
        Beer beer = null;
        String sql = "SELECT beer_rating, beer_review FROM beers WHERE beer_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, beer_id);
            if (results.next()) {
                beer = mapBeer(results);
            }
        } catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return beer;
    }

    private Beer mapBeer(SqlRowSet row){
        Beer beer = new Beer();
        int beer_id = row.getInt("beer_id");
        String beer_name = row.getString("beer_name");
        String beer_description = row.getString("beer_description");
        Double abv = row.getDouble("abv");
        int ibu = row.getInt("ibu");
        String beer_img_url = row.getString("beer_img_url");
        String beer_type = row.getString("beer_type");

        beer = new Beer(beer_name,beer_description, abv, ibu, beer_img_url, beer_type);
        return beer;
    }
}
