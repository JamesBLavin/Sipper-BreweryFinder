package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcBreweryDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Brewery> listAllBreweries() {
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer FROM breweries ORDER BY brewery_name;";
        //where breweries get stored
        List<Brewery> results = new ArrayList<>();
        try{
            //send query
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql);
            while(queryResults.next()){
                //call helper method to map results
                Brewery currentBrewery = mapBrewery(queryResults);
                //add brewery to list
                results.add(currentBrewery);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Brewery> getAllBreweries() {
        //sql query to select breweries
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer FROM breweries ORDER BY random();";
        //where breweries get stored
        List<Brewery> results = new ArrayList<>();
        try{
            //send query
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql);
            while(queryResults.next()){
                //call helper method to map results
                Brewery currentBrewery = mapBrewery(queryResults);
                //add brewery to list
                results.add(currentBrewery);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Brewery> getAllBreweriesByName(String query) {
        //sql query to select breweries by brewery name
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer FROM breweries WHERE brewery_name ILIKE ? ORDER BY brewery_name;";
        //where breweries get stored
        List<Brewery> results = new ArrayList<>();
        try{
            //send query
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql, query);
            while(queryResults.next()){
                //call helper method to map results
                Brewery currentBrewery = mapBrewery(queryResults);
                //add brewery to list
                results.add(currentBrewery);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Brewery> getAllBreweriesByCity(String query) {
        //sql query to select breweries bt city name
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer FROM breweries WHERE brewery_city ILIKE ? ORDER BY brewery_name;";
        //where breweries get stored
        List<Brewery> results = new ArrayList<>();
        try{
            //send query
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql, query);
            while(queryResults.next()){
                //call helper method to map results
                Brewery currentBrewery = mapBrewery(queryResults);
                //add brewery to list
                results.add(currentBrewery);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Brewery> getAllBreweriesByZip(String query) {
        //sql query to select breweries by zip code
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer FROM breweries WHERE brewery_zip ILIKE ? ORDER BY brewery_name;";
        //where breweries get stored
        List<Brewery> results = new ArrayList<>();
        try{
            //send query
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql, query);
            while(queryResults.next()){
                //call helper method to map results
                Brewery currentBrewery = mapBrewery(queryResults);
                //add brewery to list
                results.add(currentBrewery);
            }
        }catch (Exception e){
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Brewery getBreweryByBrewer(String username) {
        Brewery brewery = null;
        String sql = "SELECT * FROM breweries JOIN users ON breweries.brewer = users.username WHERE users.username = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            if (results.next()) {
                brewery = mapBrewery(results);
            }
        } catch (Exception e) {
            System.out.println(e.getCause() + "||" + e.getStackTrace() + "||" + "||" +e.getMessage());
        }
        return brewery;
    }

    @Override
    public Brewery getBrewery(int brewery_id) {
        Brewery brewery = null;
        // sql query to get a brewery by id
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer FROM breweries WHERE brewery_id = ?";
        try {
            // send query
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, brewery_id);
            if (results.next()) {
                brewery = mapBrewery(results);
            }
        } catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return brewery;
    }

    @Override
    public Brewery addBrewery(Brewery newBrewery) {
        String sql = "INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, true, ?) RETURNING brewery_id;";
        try {
            Integer newBreweryId = jdbcTemplate.queryForObject(sql, Integer.class,
                    newBrewery.getBrewery_name(), newBrewery.getContact_info(),newBrewery.getBrewery_history(), newBrewery.getOperating_hours(),
                    newBrewery.getBrewery_img_url(), newBrewery.getBrewery_address(), newBrewery.getBrewery_city(), newBrewery.getBrewery_state(),
                    newBrewery.getBrewery_zip(), newBrewery.getBrewer());
            newBrewery = getBrewery(newBreweryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation", e);
        }
        return newBrewery;
    }

    @Override
    public void updateUserRoleToBrewer(Brewery brewery) {
        String sql1 = "UPDATE users SET role = 'ROLE_BREWER' WHERE username = ?;";
        jdbcTemplate.update(sql1, brewery.getBrewer());
    }


    @Override
    public Brewery updateBrewery(Brewery updatedBrewery, int id) {

        String sql = "UPDATE breweries SET brewery_name = ?, contact_info = ?, brewery_history = ?, operating_hours = ?," +
                " brewery_img_url = ?, brewery_address = ?, brewery_city = ?, brewery_state = ?, brewery_zip = ?, is_active = ?, " +
                "brewer = ? WHERE brewery_id = ?;";
        updatedBrewery.setBrewery_id(id);
        try {
            jdbcTemplate.update(sql, updatedBrewery.getBrewery_name(), updatedBrewery.getContact_info(), updatedBrewery.getBrewery_history(),
                    updatedBrewery.getOperating_hours(), updatedBrewery.getBrewery_img_url(), updatedBrewery.getBrewery_address(), updatedBrewery.getBrewery_city(),
                    updatedBrewery.getBrewery_state(), updatedBrewery.getBrewery_zip(), updatedBrewery.isActive(), updatedBrewery.getBrewer(), updatedBrewery.getBrewery_id());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DataAccessException("Unable to connect to server or database", e) {
            };
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation", e);
        }
        return updatedBrewery;
    }


    private Brewery mapBrewery(SqlRowSet row){
        Brewery brewery = new Brewery();
        int brewery_id = row.getInt("brewery_id");
        String brewery_name = row.getString("brewery_name");
        String contact_info = row.getString("contact_info");
        String brewery_history = row.getString("brewery_history");
        String operating_hours = row.getString("operating_hours");
        String brewery_img_url = row.getString("brewery_img_url");
        String brewery_address = row.getString("brewery_address");
        String brewery_city = row.getString("brewery_city");
        String brewery_state = row.getString("brewery_state");
        String brewery_zip = row.getString("brewery_zip");
        boolean isActive = row.getBoolean("is_active");
        String brewer = row.getString("brewer");

        brewery = new Brewery(brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url,
                brewery_address, brewery_city, brewery_state, brewery_zip, isActive, brewer);
        return brewery;

    }


}
