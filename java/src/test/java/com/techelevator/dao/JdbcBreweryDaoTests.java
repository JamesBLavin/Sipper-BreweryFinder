package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcBreweryDaoTests extends BaseDaoTests {

    private static final Brewery BREWERY_1 = new Brewery(1, "Cool name", "(302)444-7788", "Fun and vibey place", "Mon-Fri 1-10pm", "image.test.com", "123 Fun Road", "Middletwon", "OR", "12345", true, "user1");

    private static final Brewery BREWERY_2 = new Brewery(2, "Lovely Place", "(302)333-9999", "Since 1992", "Mon-Fri 5-10pm", "image.test.org", "123 Lilac Road", "Middletwon", "OR", "12333", true, "user1");
    private static final Brewery BREWERY_3 = new Brewery(3, "Yonkers", "(302)989-2211", "Nice place to hang", "Mon-Fri 2-10pm", "image.test.jpeg", "123 Farm Road", "Middletwon", "OR", "12444", true, "user3");
    private JdbcBreweryDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweryDao(jdbcTemplate);
    }

    @Test
    public void getAllBreweries_BringsBackAllBreweries() {
        List<Brewery> breweries = sut.getAllBreweries();
        Assert.assertEquals("Should return all breweries", 3, breweries.size());
    }

    @Test
    public void getBrewery_ReturnsCorrectBrewery() {
        Brewery brewery1 = sut.getBrewery(1);
        Assert.assertEquals("Should return brewery for brewery_id 1", BREWERY_1.getBrewery_id(), brewery1.getBrewery_id());
    }
    

    @Test
    public void getBrewery_returns_null_when_id_is_not_found(){
        Brewery brewery1 = sut.getBrewery(6789);
        Assert.assertNull(brewery1);
    }

    @Test
    public void addedBrewery_ReturnsNewBrewery(){
        Brewery testBrewery = new Brewery(5,"New Brewery", "(123)456-7890", "New brewery description", "Mon-Fri 9am-5pm", "newbrewery.com", "456 Elm St", "Springfield", "IL", "12345", true, "user4");
        Brewery addedBrewery =sut.addBrewery(testBrewery);

        int newId = addedBrewery.getBrewery_id();
        Assert.assertTrue("This should create a new brewery id that is greater than 0", newId > 0);

        Brewery retrievedBrewery = sut.getBrewery(newId);
        assertBreweriesMatch(addedBrewery, retrievedBrewery);
    }
    
    @Test
    public void updateBrewery_ReturnsUpdatedBrewery() {
        Brewery testBrewery = new Brewery("Updated Name", "(123)456-7890", "New brewery description", "Mon-Fri 9am-5pm", "newbrewery.com", "456 Elm St", "Springfield", "IL", "12345", true, "user1");
        Brewery updatedBrewery = sut.updateBrewery(testBrewery, 1);
        Assert.assertEquals("Updated Name", updatedBrewery.getBrewery_name());
    }



    private void assertBreweriesMatch(Brewery expected, Brewery actual) {
        Assert.assertEquals("The brewery id's do not match", expected.getBrewery_id(), actual.getBrewery_id());
        Assert.assertEquals("The brewery names do not match", expected.getBrewery_name(), actual.getBrewery_name());
        Assert.assertEquals("The contact info does not match", expected.getContact_info(), actual.getContact_info());
        Assert.assertEquals("The brewery histories do not match", expected.getBrewery_history(), actual.getBrewery_history());
        Assert.assertEquals("The operating hours do not match", expected.getOperating_hours(), actual.getOperating_hours());
        Assert.assertEquals("The brewery images do not match", expected.getBrewery_img_url(), actual.getBrewery_img_url());
        Assert.assertEquals("The brewery street addresses do not match", expected.getBrewery_address(), actual.getBrewery_address());
        Assert.assertEquals("The brewery city addresses do not match", expected.getBrewery_city(), actual.getBrewery_city());
        Assert.assertEquals("The brewery states do not match", expected.getBrewery_state(), actual.getBrewery_state());
        Assert.assertEquals("The brewery zips do not match", expected.getBrewery_zip(), actual.getBrewery_zip());
        Assert.assertEquals("The breweries do not have the same active/inactive status", expected.isActive(), actual.isActive());
        Assert.assertEquals("Brewers do not match", expected.getBrewer(), actual.getBrewer());
    }


}
