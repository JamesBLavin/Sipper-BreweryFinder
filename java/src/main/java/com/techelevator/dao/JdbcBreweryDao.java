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
    public JdbcBreweryDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Brewery> getAllBreweries() {
        //sql query to select breweries
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active FROM breweries ORDER BY brewery_name;";
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
    public Brewery getBrewery(int brewery_id) {
        Brewery brewery = null;
        // sql query to get a brewery by id
        String sql = "SELECT brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, " +
                "brewery_address, brewery_city, brewery_state, brewery_zip, is_active FROM breweries WHERE brewery_id = ?";
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
    public Brewery updateBrewery(Brewery updatedBrewery) {
        Brewery brewery = null;
        String sql = "UPDATE breweries SET brewery_name = ?, contact_info = ?, brewery_history = ?, operating_hours = ?," +
                " brewery_img_url = ?, brewery_address = ?, brewery_city = ?, brewery_state = ?, brewery_zip = ? is_active = ? " +
                "WHERE brewery_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, brewery.getBrewery_name(), brewery.getContact_info(), brewery.getBrewery_history(),
                    brewery.getOperating_hours(), brewery.getBrewery_img_url(), brewery.getBrewery_address(), brewery.getBrewery_city(),
                    brewery.getBrewery_state(), brewery.getBrewery_zip(), brewery.isActive());

            if (numberOfRows == 0) {
                throw new DataAccessException("Zero rows affected, expected at least one") {
                };
            } else {
                updatedBrewery = getBrewery(brewery.getBrewery_id());
            }
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
        int brewery_zip = row.getInt("brewery_zip");
        boolean isActive = row.getBoolean("is_active");

        brewery = new Brewery(brewery_id, brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url,
                brewery_address, brewery_city, brewery_state, brewery_zip, isActive);
        return brewery;

    }
}
