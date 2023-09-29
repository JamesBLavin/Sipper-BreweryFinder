BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer) VALUES ('Cool name', '(302)444-7788', 'Fun and vibey place', 'Mon-Fri 1-10pm', 'image.test.com', '123 Fun Road', 'Middletown', 'OR', 12345, true, 'user1');
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer) VALUES ('Lovely Place', '(302)333-9999', 'Since 1992', 'Mon-Fri 5-10pm', 'image.test.org', '123 Lilac Road', 'Middletown', 'OR', 12333, true, 'user2');
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active, brewer) VALUES ('Yonkers', '(302)989-2211', 'Nice place to hang', 'Mon-Fri 2-10pm', 'image.test.jpeg', '123 Farm Road', 'Middletown', 'OR', 12444, true, 'user3');

INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type) VALUES (1, 'beer1', 'This is beer', 1.1, 10, 'http://beer1.com', 'IPA');
INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type) VALUES (1, 'beer2', 'This is another beer', 2.2, 20, 'http://beer2.com', 'Stout');
INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_img_url, beer_type) VALUES (2, 'beer3', 'This is even more beer', 3.3, 30, 'http://beer3.com', 'Lager');

INSERT INTO reviews (beer_id, star_rating, review_comments) VALUES (1, 5, 'Great beer.');
INSERT INTO reviews (beer_id, star_rating, review_comments) VALUES (2, 5, 'Good beer.');
INSERT INTO reviews (beer_id, star_rating, review_comments) VALUES (3, 5, 'Ok beer.');

COMMIT TRANSACTION;
