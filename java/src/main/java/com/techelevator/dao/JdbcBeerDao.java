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
public class JdbcBeerDao implements BeerDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcBeerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Beer> getAllBeers() {
        String sql1 = "SELECT AVG(reviews.star_rating) AS avg_stars, beers.beer_id, brewery_id, beer_name, " +
                "beer_description, abv, ibu, beer_img_url, beer_type " +
                "FROM reviews JOIN beers ON beers.beer_id = reviews.beer_id " +
                "GROUP BY beers.beer_id ORDER BY beer_id;";
        String sql2 = "SELECT beer_id, brewery_id, beer_name, " +
                "beer_description, abv, ibu, beer_img_url, beer_type " +
                "FROM beers ORDER BY beer_id;";
        List<Beer> results = new ArrayList<>();
        try {
            SqlRowSet queryResults1 = jdbcTemplate.queryForRowSet(sql1);
            while (queryResults1.next()) {
                Beer currentBeer = mapBeerAndAvg(queryResults1);
                results.add(currentBeer);
            }
            SqlRowSet queryResults2 = jdbcTemplate.queryForRowSet(sql2);
            while (queryResults2.next()) {
                boolean found = false;
                Beer currentBeer = mapBeer(queryResults2);
                for (Beer beer : results) {
                    if (beer.getBeer_id() == currentBeer.getBeer_id()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    results.add(currentBeer);
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public Beer getBeer(int beer_id) {
        String sql1 = "SELECT AVG(reviews.star_rating) AS avg_stars, beers.beer_id, brewery_id, beer_name, " +
                "beer_description, abv, ibu, beer_img_url, beer_type " +
                "FROM reviews JOIN beers ON beers.beer_id = reviews.beer_id " +
                "WHERE beers.beer_id = ?" +
                "GROUP BY beers.beer_id ORDER BY beer_id;";
        String sql2 = "SELECT beer_id, brewery_id, beer_name, " +
                "beer_description, abv, ibu, beer_img_url, beer_type " +
                "FROM beers WHERE beer_id = ? ORDER BY beer_id;";
        List<Beer> results = new ArrayList<>();
        try {
            SqlRowSet queryResults1 = jdbcTemplate.queryForRowSet(sql1, beer_id);
            while (queryResults1.next()) {
                Beer currentBeer = mapBeerAndAvg(queryResults1);
                results.add(currentBeer);
            }
            SqlRowSet queryResults2 = jdbcTemplate.queryForRowSet(sql2, beer_id);
            while (queryResults2.next()) {
                boolean found = false;
                Beer currentBeer = mapBeer(queryResults2);
                for (Beer beer : results) {
                    if (beer.getBeer_id() == currentBeer.getBeer_id()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    results.add(currentBeer);
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return results.get(0);
    }

    @Override
    public List<Beer> getBeersByBrewery(int brewery_id) {
        String sql = "SELECT * FROM beers WHERE brewery_id = ?;";
        List<Beer> beers = new ArrayList<>();

        try {
            SqlRowSet queryResults = jdbcTemplate.queryForRowSet(sql, brewery_id);
            while (queryResults.next()) {
                Beer currentBeer = mapBeer(queryResults);
                beers.add(currentBeer);
            }
        } catch (Exception e) {
            System.out.println("Error occurred when connecting to the database. Exception is: ");
            e.printStackTrace();
        }
        return beers;
    }


    @Override
    public Beer addBeer(Beer newBeer) {
        String sql = "INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING beer_id";
        try {
            int newBeerId = jdbcTemplate.queryForObject(sql, int.class,
                    newBeer.getBrewery_id(), newBeer.getBeer_name(), newBeer.getBeer_description(), newBeer.getAbv(), newBeer.getIbu(), newBeer.getBeer_img_url(), newBeer.getBeer_type());
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
    public Beer updateBeer(Beer updatedBeer, int id) {
        String sql = "UPDATE beers SET brewery_id = ?, beer_name = ?, beer_description = ?, abv = ?, ibu = ?, beer_img_url = ?, beer_type = ? WHERE beer_id = ?";

        updatedBeer.setBeer_id(id);
        try {
            jdbcTemplate.update(sql, updatedBeer.getBrewery_id(), updatedBeer.getBeer_name(), updatedBeer.getBeer_description(), updatedBeer.getAbv(), updatedBeer.getIbu(), updatedBeer.getBeer_img_url(), updatedBeer.getBeer_type(), updatedBeer.getBeer_id());

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
        String sql =    "DELETE FROM reviews WHERE beer_id = ?; " +
                        "DELETE FROM beers WHERE beer_id = ?;";

        int numberOfRowsDeleted = 0;
        try {
            numberOfRowsDeleted = jdbcTemplate.update(sql, beer_id, beer_id);
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


    private Beer mapBeer(SqlRowSet row) {
        Beer beer = new Beer();
        int beer_id = row.getInt("beer_id");
        int brewery_id = row.getInt("brewery_id");
        String beer_name = row.getString("beer_name");
        String beer_description = row.getString("beer_description");
        Double abv = row.getDouble("abv");
        int ibu = row.getInt("ibu");
        String beer_img_url = row.getString("beer_img_url");
        String beer_type = row.getString("beer_type");

        beer = new Beer(beer_id, brewery_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type);
        return beer;
    }

    private Beer mapBeerAndAvg(SqlRowSet row) {
        Beer beer = new Beer();
        int beer_id = row.getInt("beer_id");
        int brewery_id = row.getInt("brewery_id");
        String beer_name = row.getString("beer_name");
        String beer_description = row.getString("beer_description");
        Double abv = row.getDouble("abv");
        int ibu = row.getInt("ibu");
        String beer_img_url = row.getString("beer_img_url");
        String beer_type = row.getString("beer_type");
        int avg_rating = (int) row.getDouble("avg_stars");

        beer = new Beer(beer_id, brewery_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type, avg_rating);
        return beer;
    }
}
