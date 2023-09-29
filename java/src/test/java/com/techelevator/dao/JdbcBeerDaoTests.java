package com.techelevator.dao;

import com.techelevator.model.Beer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class JdbcBeerDaoTests extends BaseDaoTests {

    protected static final Beer BEER_1 = new Beer(1,1, "beer1", "This is beer", 1.1, 10, "http://beer1.com", "IPA");
    protected static final Beer BEER_2 = new Beer(2,1, "beer2", "This is another beer", 2.2, 20, "http://beer2.com", "Stout");
    protected static final Beer BEER_3 = new Beer(3,2, "beer3", "This is even more beer", 3.3, 30, "http://beer3.com", "Lager");

    private JdbcBeerDao sut;

    @Before
    public void setUp() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBeerDao(jdbcTemplate);
    }

    @Test
    public void getAllBeers() {
        List<Beer> beers = sut.getAllBeers();
        Assert.assertEquals("This should return all beers", 3, beers.size());
    }

    @Test
    public void getBeerById() {
        Beer beer1 = sut.getBeer(1);
        Assert.assertEquals(1, BEER_1.getBeer_id());
    }


}
