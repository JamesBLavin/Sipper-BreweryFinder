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

    private Beer testBeer;
    private JdbcBeerDao sut;

    @Before
    public void setUp() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBeerDao(jdbcTemplate);
        testBeer = new Beer(0,1, "Test Beer", "Testing", 9.9, 50, "test.com", "Beer");

    }

    @Test
    public void getAllBeers() {
        List<Beer> beers = sut.getAllBeers();
        Assert.assertEquals("This should return all beers", 3, beers.size());
    }

    @Test
    public void getBeer_returns_correct_beer() {
        Beer beer1 = sut.getBeer(1);
        assertBeersMatch(BEER_1, beer1);
    }


    @Test
    public void getBeerByBrewery_returns_correct_beers_for_brewery() {
        List<Beer> beers1 = sut.getBeersByBrewery(1);
        Assert.assertEquals("You should get 2 beers for brewery_id 1", 2, beers1.size());
        assertBeersMatch(BEER_1, beers1.get(0));
        assertBeersMatch(BEER_2, beers1.get(1));

        List<Beer> beers2 = sut.getBeersByBrewery(2);
        Assert.assertEquals("You should get 1 beer for brewery_id 2", 1, beers2.size());
        assertBeersMatch(BEER_3, beers2.get(0));
    }
    @Test
    public void getBeerByBrewery_returns_null_when_brewery_id_is_not_found() {
        List<Beer> beers1 = sut.getBeersByBrewery(99);
        Assert.assertEquals("This id does exist", 0,beers1.size());

    }

    @Test
    public void addBeer_returns_beer_with_id_and_expected_values() {
        Beer addedBeer = sut.addBeer(testBeer);

        int newId = addedBeer.getBeer_id();
        Assert.assertTrue(newId > 0);

        Beer retrievedBeer = sut.getBeer(newId);
        assertBeersMatch(addedBeer, retrievedBeer);
    }

    @Test
    public void updateBeer_has_expected_values_when_retrieved() {
        Beer beerToUpdate = sut.getBeer(1);

        beerToUpdate.setBrewery_id(2);
        beerToUpdate.setBeer_name("Updated Beer");
        beerToUpdate.setBeer_description("Im a updated Beer");
        beerToUpdate.setAbv(8.3);
        beerToUpdate.setIbu(99);
        beerToUpdate.setBeer_img_url("testimage.com");
        beerToUpdate.setBeer_type("Beer");

        sut.updateBeer(beerToUpdate);

        Beer retrievedBeer = sut.getBeer(1);
        assertBeersMatch(beerToUpdate, retrievedBeer);
    }

//    @Test
//    public void deleteBeer_beer_cant_be_retrieved() {
//        sut.deleteBeer(1);
//
//        Beer retrievedBeer = sut.getBeer(1);
//        Assert.assertNull(retrievedBeer);
//    }

    private void assertBeersMatch(Beer expected, Beer actual) {
        Assert.assertEquals("the beer_id do not match",expected.getBeer_id(), actual.getBeer_id());
        Assert.assertEquals("the brewery_id do not match",expected.getBrewery_id(), actual.getBrewery_id());
        Assert.assertEquals("the beer_name do not match",expected.getBeer_name(), actual.getBeer_name());
        Assert.assertEquals("the beer_description do not match",expected.getBeer_description(), actual.getBeer_description());
        Assert.assertEquals("the abv do not match",expected.getAbv(), actual.getAbv(), 0.1);
        Assert.assertEquals("the ibu do not match",expected.getIbu(), actual.getIbu());
        Assert.assertEquals("the beer_img_url do not match",expected.getBeer_img_url(), actual.getBeer_img_url());
        Assert.assertEquals("the beer_type do not match",expected.getBeer_type(), actual.getBeer_type());



    }

}
