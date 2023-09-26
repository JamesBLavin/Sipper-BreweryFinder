BEGIN TRANSACTION;

-- Drops all tables when it is run again
DROP TABLE IF EXISTS users, breweries, beers CASCADE;

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
    brewery_history VARCHAR(500),
    operating_hours VARCHAR(300),
    brewery_img_url VARCHAR(200),
    brewery_address VARCHAR(100),
    brewery_city VARCHAR(100),
    brewery_state VARCHAR(50),
    brewery_zip INT,
    is_active BOOLEAN,
    CONSTRAINT PK_brewery PRIMARY KEY (brewery_id)
);

-- Created a table for all beers
CREATE TABLE beers (
   beer_id SERIAL,
   brewery_id INT,
   beer_name VARCHAR(50) NOT NULL UNIQUE,
   beer_description VARCHAR(500),
   abv NUMERIC(2,1),
   ibu INT,
   beer_rating INT,
   beer_review VARCHAR(500),
   beer_img_url VARCHAR(200),
   beer_type VARCHAR(20),
   CONSTRAINT PK_beer PRIMARY KEY (beer_id),
   CONSTRAINT FK_beer_brewery FOREIGN KEY(brewery_id) REFERENCES breweries(brewery_id)
);

COMMIT TRANSACTION;
