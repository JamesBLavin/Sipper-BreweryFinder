BEGIN TRANSACTION;

-- Drops all tables when it is run again
DROP TABLE IF EXISTS users, breweries, beers, reviews CASCADE;

-- Created a table for all users
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- Created a table for all breweries
CREATE TABLE breweries (
    brewery_id SERIAL,
    brewery_name VARCHAR(50) NOT NULL,
    contact_info VARCHAR(500),
    brewery_history VARCHAR(1000),
    operating_hours VARCHAR(300),
    brewery_img_url VARCHAR(300),
    brewery_address VARCHAR(100),
    brewery_city VARCHAR(100),
    brewery_state VARCHAR(50),
    brewery_zip INT,
    is_active BOOLEAN,
    brewer VARCHAR(50),
    CONSTRAINT PK_brewery PRIMARY KEY (brewery_id),
    CONSTRAINT FK_brewery_user FOREIGN KEY (brewer) REFERENCES users (username)
);

-- Created a table for all beers
CREATE TABLE beers (
   beer_id SERIAL,
   brewery_id INT,
   beer_name VARCHAR(50) NOT NULL UNIQUE,
   beer_description VARCHAR(1000),
   abv NUMERIC(3,1),
   ibu INT,
   beer_img_url VARCHAR(200),
   beer_type VARCHAR(30),
   CONSTRAINT PK_beer PRIMARY KEY (beer_id),
   CONSTRAINT FK_beer_brewery FOREIGN KEY(brewery_id) REFERENCES breweries(brewery_id)
);

 --Created table for reviews
CREATE TABLE reviews (
    review_id SERIAL,
    user_id INT NOT NULL,
    beer_id INT NOT NULL,
    star_rating INT,
    review_comments VARCHAR(1000),
    review_img_url VARCHAR(600),
    CONSTRAINT PK_review PRIMARY KEY (review_id),
    CONSTRAINT FK_beer_id FOREIGN KEY(beer_id) REFERENCES beers(beer_id),
    CONSTRAINT FK_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;
