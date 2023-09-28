package com.techelevator.dao;

import com.techelevator.Services.BreweryService;
import com.techelevator.model.Brewery;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BreweryDaoTests extends BaseDaoTests {

    private static final Brewery BREWERY_1 = new Brewery("Cool name", "(302)444-7788", "Fun and vibey place", "Mon-Fri 1-10pm", "image.test.com", "123 Fun Road", "Middletwon", "OR", 12345, true, "Joe");

    private static final Brewery BREWERY_2 = new Brewery("Lovely Place", "(302)333-9999", "Since 1992", "Mon-Fri 5-10pm", "image.test.org", "123 Lilac Road", "Middletwon", "OR", 12333, true, "Jim");
    private static final Brewery BREWERY_3 = new Brewery("Yonkers", "(302)989-2211", "Nice place to hang", "Mon-Fri 2-10pm", "image.test.jpeg", "123 Farm Road", "Middletwon", "OR", 12444, true, "Josh");
    private JdbcBreweryDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcBreweryDao(dataSource);
    }

    @Test
    public void getAllBreweries_BringsBackAllBreweries() {
        List<Brewery> breweries = sut.getAllBreweries();
        Assert.assertEquals("Should return all breweries", 19, breweries.size());
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
    }




}
