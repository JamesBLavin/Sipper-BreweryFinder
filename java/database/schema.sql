BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS breweries;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE breweries (
    brewery_id SERIAL,
    brewery_name VARCHAR(50) NOT NULL,
    contact_info VARCHAR(500),
    brewery_history VARCHAR(500),
    operating_hours VARCHAR(300),
    brewery_img_url VARCHAR(500),
    brewery_address VARCHAR(500),
    CONSTRAINT PK_brewery PRIMARY KEY (brewery_id)
);

CREATE TABLE beers (
   beer_id SERIAL,
   brewery_id INT,
   beer_name VARCHAR(50) NOT NULL UNIQUE,
   beer_description VARCHAR(500),
   abv NUMERIC(2,1),
   ibu INT,
   beer_rating INT,
   beer_review VARCHAR(500),
   CONSTRAINT PK_beer PRIMARY KEY (beer_id)
);

COMMIT TRANSACTION;
