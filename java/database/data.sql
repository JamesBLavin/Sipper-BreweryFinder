BEGIN TRANSACTION;

-- Created users to put it in the database
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-- Created breweries to put in the database
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Autumn Arch', '(302)-294-1126', 'Local brewery located in Delaware. Opened in 2023.', 'Wed: 4-9pm, Thurs: 3-10pm, Fri: 12-10pm, Sat: 12-10pm, Sun: 12-8pm', 'https://s3-media0.fl.yelpcdn.com/bphoto/9UOIKbaZNCsSQ0f0Cwi2LA/348s.jpg', '810 Pencader Drive Suite C', 'Newark', 'DE', 19702, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Volunteer Brewing Company', '(302)-464-0822', 'The Taphouse @ Volunteer Brewing is located on Main Street in the heart of downtown Middletown in a renovated home originally built in the early 1800’s. As a residence, the Main Street home has been host to countless family gatherings and precious family milestone’s through many generations. We welcome you to visit and make new memories with family and friends.', 'Mon-Wed: Closed, Thurs: 3pm-9pm, Fri: 3pm-10pm, Sat: Noon-10pm, Sun: Noon-6pm', 'https://static.wixstatic.com/media/e0b006_d311a4d758b04be4ba49eddf00db9e3f~mv2.jpg/v1/fill/w_214,h_184,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/714E00CB-B640-47E9-B63A-61CD2C28A894_JPG.jpg', '116 W Main St', 'Middletown', 'DE', 19709, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Brick Works Brewing and Eats', '(302)-508-2523', 'Brick Works Brewing & Eats was founded in 2016 in Smyrna, Delaware. Focused on producing the highest quality beverages and menu items, the brewpub prides itself on utilizing locally sourced ingredients for both its beers and its foods. For years, owners Ryan Maloney and Kevin Reading spoke about working on a project together. But, the right opportunity had not yet presented itself. Shortly after the fall of 2015, a property developer in Smyrna approached Reading with a restaurant location that could not be beaten, and thus came the concept of a brewpub.', 'Mon: 3-9pm, Tues: 3pm-9pm, Wed: 3pm-9pm, Thurs: 11am-9pm, Fri: 11am-10pm, Sat: 11am-10pm, Sun: 11am-9pm', 'https://static.spotapps.co/spots/57/d57588f7eb487dbbe34d797a3756d6/medium', '230 South Dupont Boulevard', 'Smyrna', 'DE', 19977, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Iron Hill Brewery', '(302)-472-2739', 'Kevin Finn, one of those Delaware locals, receives a homebrewing kit from his wife for his wife for his birthday.What starts as a hobby soon becomes a passion', 'Mon: 11am-10pm, Tues: 11am-10pm, Wed: 11am-10pm, Thurs: 11am-10pm, Fri: 11am-10:30pm, Sat: 11am-10:30pm, Sun: 11am-9pm', 'https://assets.simpleviewinc.com/simpleview/image/upload/c_limit,q_75,w_1200/v1/crm/wilmington/RIVERFRONT_Iron-Hill-Brewery-Exterior-355995005056b3a_355997a2-5056-b3a8-495081b6d5a23b1e.jpg', '620 JUSTISON ST', 'Wilmington', 'DE', 19801, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Revelation Craft Brewery Company', '(302)-212-5674', 'Local brewing company founded in 2019', 'Mon-Thurs: 11am-9pm, Fri-Sat: 11am-10pm, Sun: 11am-9pm', 'https://revbeer.com/wp-content/uploads/2021/03/Rev-Home-Page-PIc-Update.jpg.', '19841 CENTRAL STREET', 'REHOBOTH BEACH', 'DE', 19971, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Blue Earl Brewery Company', '(302)-653-2337', 'The founder of our brewery Ronnie “Blue” Earl Price is a man of simple tastes, always on the hunt for great music, gourmet food, and exceptional craft beer. The simplicity of the blues had always drawn him in, the soulfulness, the earthiness of the style made him feel good inside. Barbecue is to food as blues is to music he would always say, nothing fast about the blues or barbecue, too fast with the blues and you lose the feeling, too fast with barbecue and, well, it just ain’t no good. Finding a good beer had always been a challenge. American beers had lost all their former goodness with mass production and mass marketing. They had lost the feeling. He decided that if it couldn’t be bought, he would have to brew it himself.', 'Mon: 12pm-6pm, Tues: 3am-9pm, Wed: 3pm-9pm, Thurs: 12pm-10pm, Fri: 12pm-11pm, Sat: 12pm-11pm, Sun: 12pm-6pm', 'https://blueearlbrewing.com/wp-content/uploads/2022/10/313515532_674164377465186_7189830740580515757_n-2048x1536.jpg', '210 Artisan Dr', 'Smyrna', 'DE', 19977, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Dewey Beer Company', '(302)-329-9759', 'Dewey Beer Company opened its doors for the first time in 2009 with a desire to bring incredible craft brews to the First State.', 'Mon-Sun: 12pm-9pm', 'https://www.delawareonline.com/gcdn/presto/2021/01/14/PWIL/1db165d3-4064-4cde-a348-9cb81ebca681-IMG_4639.jpeg?crop=4031,2267,x1,y603&width=3200&height=1800&format=pjpg&auto=webp', '21241 Iron Throne Drive', 'Milton', 'DE', 19968, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Fordham & Dominion Brewing Company', '(302)-678-4810', 'Based on our shared values and a common philosophy of quality brewing, Fordham and Dominion joined forces in 2007 and consolidated operations in 2009. The First State is now home to the Fordham & Dominion Brewing Co., where beer lovers from near and far are able to stop by, get to know us, and enjoy our handcrafted beer and soda. Our roots run deep throughout the Mid-Atlantic region and we remain dedicated to our craft.', 'Mon: Closed, Tues-Thurs: 3pm-8pm, Fri-Sat: 12pm-9pm, Sun: 1pm-6pm', 'https://www.visitdelaware.com/sites/default/files/styles/listing_slideshow/public/listing_images/profile/4150/0-pint-glass1-d6b69aaf5056b3a_d6b69bda-5056-b3a8-49603f0169dc03d8.jpg?itok=HFcj_xVb', '1284 McD Drive', 'Dover', 'DE', 19901, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Crooked Hammock Brewery', '(302)-644-7837', 'How did we get here? Well at some point he had enough, and Rich Garrahan decided to ditch his suit and tie to build his own little slice of heaven.  Rich envisioned a place where his worries were left at the door. He wanted what a lot of us want at one time or another: He wanted an escape. For him, that means a big backyard with tons of yard games, plenty of homemade craft beer, and a never-ending cookout where the burgers are as good as the conversation.', 'Mon-Thurs: 11am-9pm, Fri-Sat: 11am-10pm, Sun: 11am-9pm', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOnEJyG1QDA1gpUbtpU38sxmyvZoUiRVnrC5Mk-Xb4CQ5vtLZAbd-SxxQbG2wTFFYieoY&usqp=CAU', '36707 Crooked Hammock Way', 'Lewes', 'DE', 19958, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Argilla Brewing Company', '(302) 731-8200', 'Some foods were made to pair with a beer, like pizza. And Argilla Brewing is what happens when a couple of home brew do-it-yourselfers love that pairing and own a well-loved pizzeria. This nanobrewery uses a 1.5-barrel system on-site at Pietro’s Pizza. So, its brewers are constantly experimenting with new tastes and ideas.',  'Mon: 12-9pm, Tues: 12-9pm, Wed: 12-9pm, Thurs: 12-10pm, Fri: 12-10pm, Sat: 12-10pm, Sun: 12-10pm', 'https://www.visitdelaware.com/sites/default/files/styles/listing_slideshow/public/listing_images/profile/5294/0-argilla_web0_566ef1f1-5056-b3a8-491c4b7ea605c329.jpg?itok=pREJAtMt', '2667 Kirkwood Highway', 'Newark', 'DE', 19711, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Musings Fermentation Underground', '(302) 722-5759', 'Established in 2022, Musings Fermentation Underground is a barrel-aged brewery that draws its inspiration from old world Belgian brewing traditions. Using locally sourced ingredients, our spontaneous fermentations are patiently aged to produce the finest blends of artisanal, wild and sour beers and kombucha you’ll ever enjoy.',  'Mon: 12-9pm, Tues: 12-9pm, Wed: 12-9pm, Thurs: 12-10pm, Fri: 12-10pm, Sat: 12-10pm, Sun: 12-10pm', 'https://musingsbrews.com/wp-content/uploads/2023/01/video.webp', '674 Pencader Drive', 'Newark', 'DE', 19711, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Stitch House Brewery', '302-250-4280', 'Located among the lively N. Market Street in Downtown Wilmington, you will feel the true heart of the city at this spot. Including a savory menu to pair with one of their german style house-brewed beers, live music and creative atmosphere. Dining room & bar are open - walk-ins are welcome, and takeout and curbside available.',  'Mon: 11am-10pm, Tues: 11am-10pm, Wed: 11am-10pm, Thurs: 11am-10pm, Fri: 11am-10pm, Sat: 11am-10pm, Sun: 12-10pm', 'https://assets.simpleviewinc.com/simpleview/image/upload/c_fill,h_768,q_75,w_959/v1/crm/wilmington/30441102_1963349317040484_749484248557158400_n0-353b10255056b3a_353b10f8-5056-b3a8-49fc11606b77a146.jpg', '829 N. Market Street', 'Wilmington', 'DE', 19801, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Dogfish Head Brewings & Eats', '(302) 226-2739', 'Located on the main shopping and entertainment strip in Rehoboth, the "pub," as it’s known among Dogfish aficionados, is thought of as the birthplace and soul of the famous brewery. There is an intriguing menu filled plus pub-only and hard-to-find Dogfish beer. There’s often live entertainment, pairing dinners, spirits tastings and much more.',  'Mon: 11am-10pm, Tues: 11am-10pm, Wed: 11am-10pm, Thurs: 11am-10pm, Fri: 11am-10pm, Sat: 11am-10pm, Sun: 11am-10pm', 'https://www.dogfish.com/files/media/inn/coworker-dinner-2017-3.jpg', '20 Rehoboth Avenue', 'Rehoboth Beach', 'DE', 19971, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Wilmington Brew Works', '(302) 722-4828', 'Wilmington Brew Works is housed in a former laboratory with a alluring patio. The brewery makes t additional styles with innovative craftsmanship.  WBW aims to offer a wide range of styles and rotate their products frequently.  The beer hunter will rejoice in the opportunity to try something new in the family friendly local atmosphere.  Different offerings will highlight all types of fermentation; so whether you enjoy a crisp clean lager, a hazy IPA or a wild, funky, or tart beer, Wilmington Brew Works have what you seek.',  'Mon: 5-9pm, Tues: 5-9pm, Wed: 3-10pm, Thurs: 3-10pm, Fri: 12-10pm, Sat: 12-10pm, Sun: 12-6pm', 'https://assets.simpleviewinc.com/simpleview/image/upload/c_limit,q_75,w_1200/v1/crm/wilmington/PXL_20210521_204330481_9165B334-3182-44F0-89C9740363E6AB07_aeaa003c-add9-4e37-bd54a771e2823e2d.jpg', '3129 Miller Road', 'Wilmington', 'DE', 19802, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Midnight Oil Brewing Company', '(302) 286-7641', 'Just by looking at the name of the brews and their social media you can tell that this brewery knows how to put the fun in craft beverage. Enjoy rotating food trucks, farmers markets, and lagers, IPAS, stouts and more that have brewed the midnight oil to be as good as they are.', 'Mon: 2-10pm, Tues: 2-10pm, Wed: 2-10pm, Thurs: 2-10pm, Fri: 11am-11pm, Sat: 11am-11pm, Sun: 11am-11pm', 'https://images.squarespace-cdn.com/content/v1/64dd0da0b207d0264cc424a1/1694457782678-3CPPIMY17YM1P6Y9JI68/850_6672.jpg?format=500w', '674 Pencader Drive', 'Newark', 'DE', 19702, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Bellefonte Brewing Company', '(302) 407-6765', 'Just by looking at the name of the brews and their social media you can tell that this brewery knows how to put the fun in craft beverage. Enjoy rotating food trucks, farmers markets, and lagers, IPAS, stouts and more that have brewed the midnight oil to be as good as they are.', 'Mon: 2-10pm, Tues: 2-10pm, Wed: 2-10pm, Thurs: 2-10pm, Fri: 11am-11pm, Sat: 11am-11pm, Sun: 11am-11pm', 'https://www.visitdelaware.com/sites/default/files/styles/listing_slideshow/public/listing_images/profile/5748/0-bellefonte_brewing_web1_566f584d-5056-b3a8-497d580ea02bcfa1.jpg?itok=yAePz5HU', '3605 Old Capitol Trail', 'Wilmington', 'DE', 19808, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Dew Point Brewing Company', '(302) 235-8429', 'Alexa Hoffman became interested in craft brewing while in college at the University of South Carolina in 2008. Alexa didn’t realize it would one day turn into a family business. Her brother, Cody Hoffman, who was 16 years old, would catch the bug while helping his father brew beer with the home brewing kit. The next couple stops in Cody’s journey were Twin Lakes Brewing Company in Greenville, DE and then 8-months in brewing school in England. A few months after returning from England, his father had an idea… In October 2013, after more than a year of searching for the right location for the brewery and tasting room, John came across a dilapidated building in the Garrett Snuff Mill complex, built in 1901. John instantly felt right at home because his family had lived near Yorklyn for the past 30 years.', 'Wed: 4-9pm, Thurs: 4-9pm, Fri: 3-10pm, Sat: 1-10pm, Sun: 1-8pm', 'https://images.squarespace-cdn.com/content/v1/58ae54b6579fb308719b3959/1492536372067-GRVOWNT9WJQ0MGHGVCA9/Dewpoint_generic.jpg?format=2500w', '2878 Creek Road', 'Yorklyn', 'DE', 19736, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Thompson Island Brewing Company', '(302) 226-4677', 'Thompson Island Brewing Company is an independent craft brewery & restaurant that celebrates the Coastal Delaware lifestyle. Located in Rehoboth Beach, the brewery is named after an island in the Rehoboth Bay and is reminiscent of a beach picnic and bonfire of your childhood. The beer menu showcases Thompson Island original brews along with rotating taps featuring other local breweries. Our nationally recognized culinary team draws inspiration from local farms, beaches and bays and consistently serves beautiful, simple food and fresh homemade beer.', 'Mon: 11:30am-10pm, Tues: 11:30am-10pm, Weds: 11:30am-10pm, Thurs: 11:30am-10pm, Fri: 11:30am-10pm, Sat: 11:30am-10pm, Sun: 11:30am-10pm', 'https://images.squarespace-cdn.com/content/v1/5c8fab1193a6322d488120c9/1572276363231-PCFIG899HJAJBV0AZ7L4/yGt9FH3A.jpeg?format=2500w', '30133 Veterans Way', 'Rehoboth Beach', 'DE', 19971, true);
INSERT INTO breweries (brewery_name, contact_info, brewery_history, operating_hours, brewery_img_url, brewery_address, brewery_city, brewery_state, brewery_zip, is_active) VALUES ('Big Oyster Brewery', '(302) 644-2621', 'Look for the big red barn, and the brews bursting with great flavor. Enjoy tasty eats, tasty flights, and a spacious relaxing backyard view. Big Oyster is a must stop spot for oyster lovers, and unique brew lovers alike.', 'Mon: 11:30am-9pm, Tues: 11:30am-9pm, Weds: 11:30am-9pm, Thurs: 11:30am-9pm, Fri: 11:30am-9pm, Sat: 11:30am-9pm, Sun: 11:30am-9pm', 'https://cdn.craftbeer.com/wp-content/uploads/20200507105619/HartonAndrew-1-scaled.jpg', '1007 Kings Highway', 'Lewes', 'DE', 19958, true);


-- Created beers to put in the database
INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_rating, beer_review, beer_img_url, beer_type) VALUES ('1', 'Pumpkin Loaf', 'It’s all the classic fall spices forged atop a smooth & respectable German Bock backbone.  Strong layers of pumpkin bread and autumn vibes fade into a sweet caramel finish.', 7.1, 35, 4, 'This Jawn good bro', 'https://vinepair.com/wp-content/uploads/2020/10/weask_pumpkinale_social.jpg', 'Ale');
INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_rating, beer_review, beer_img_url, beer_type) VALUES ('2', 'Cloudy Not Hazy', 'A traditional German style wheat beer brewed with a low flocculating German yeast strain that creates notes of clove and banana. This yeast produces a beer with a cloudy appearance long before hazy beers became a thing.', 5.0, 10, 3, 'This stuff be bussin!', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Hefeweizen_Glass.jpg/330px-Hefeweizen_Glass.jpg', 'Wheat Beer');
INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_rating, beer_review, beer_img_url, beer_type) VALUES ('3', 'Blue Moon', 'A wheat beer brewed with orange peel for a subtle sweetness and bright, citrus aroma. Blue Moon® Belgian White Belgian-Style Wheat Ale is garnished with an orange slice to heighten the citrus aroma and taste.', 5.4, 13, 5, 'Best Beer on god!', 'https://siestaspirits.com/cdn/shop/products/blue_moon_bot_glass.jpg?v=1571264406', 'Wheat Ale');
INSERT INTO beers (brewery_id, beer_name, beer_description, abv, ibu, beer_rating, beer_review, beer_img_url, beer_type) VALUES ('4', 'Iron Hill Light Lager', 'Our lightest beer. Brewed to give a crisp, clean, refreshing taste with very subtle malt and hop flavor.', 4.0, 10, 2, 'This Jawn triflin bruh!', 'https://media-cdn.tripadvisor.com/media/photo-m/1280/16/27/86/44/iron-hill-light-lager.jpg', 'Lager');


--Created beer reviews
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Pumpkin Loaf', 5, 'This beer is perfect for the fall. It made me feel warm and cozy.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Pumpkin Loaf', 3, 'Pumpkin Loaf is alright, but this place should just stick to the classic flavors we all know and love.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Pumpkin Loaf', 5, 'BBE. Best. Beer. Ever');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Iron Hill Light Lager', 5, 'My all time favorite beer. I recommend it to all beer lovers');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Iron Hill Light Lager', 1, 'Disgusting. Wouldn''t drink it again, if you paid me.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Iron Hill Light Lager', 4, 'Subtle, yet strong. Just the way I like it.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('American Blonde', 4, 'Mediocre.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('American Blonde', 2, 'Not the worst I''ve ever had.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('American Blonde', 5, 'This beer is just a classic. Plain and simple.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Hollowed Winter', 1, 'The name is fitting. This beer reminds me a dark, cold place I do not want to visit.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Hollowed Winter', 1, 'You might as well drink toilet water if you''re thinking of trying this.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Hollowed Winter', 4, 'Par for the course.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Supersaurus Rex', 4, 'Super close to being one of my favorites, but not quite there yet.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Supersaurus Rex', 3, 'Only tried this beer for the name. Nothing to write home about.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Supersaurus Rex', 1, 'Just as the name implies, this beer is childish. Give me something strong.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Bolaris Winter Ale', 1, 'Bolaris? More like Yuck-aris!.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Bolaris Winter Ale', 2, 'Meh, it''s not the worst. The recipe could use some revamping for sure.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Bolaris Winter Ale', 5, 'Would rate this 10 stars if I could!');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Belgian Amber/Dubbel Doink', 3, 'This beer needs to pick a vibe and stick to it.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Belgian Amber/Dubbel Doink', 4, 'Fantastic beer.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Belgian Amber/Dubbel Doink', 2, 'I''ve tasted much better than this.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Pickette Fence Double IPA', 5, 'Makes me feel like I''m at home having a grand old time.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Pickette Fence Double IPA', 1, 'Worst tasting drink I''ve ever had.);
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Pickette Fence Double IPA', 3, 'Not a fan of IPAs to be honest, but this one isn''t half bad.);
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Just a Small Town gourd', 2, 'Does not do the song justice.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Just a Small Town gourd', 3, 'Almost as good as the Journey song.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Just a Small Town gourd', 5, 'I''m just a small town girl who loves this beer.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Drop Towel', 5, 'This beer is heaven in a glass.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Drop Towel', 1, 'I''m at a loss for words. Not in a good way.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Drop Trowel', 3, 'Would have liked a higher abu.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Chocolate Covered Pretzel Stout', 1, 'Wish I was having pretzels instead of this..');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Chocolate Covered Pretzel Stout', 3, 'This beer is a hit with my friends.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Chocolate Covered Pretzel Stout', 4, 'Just like reaching for pretzels, I couldn''t stop reaching for another sip of this drink.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Citrus Mistress', 2, 'Feels like I''m on vacation with every sip.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Citrus Mistress', 4, 'Unexpected delight.');
INSERT INTO reviews (beer_name, star_rating, review_comments) VALUES ('Citrus Mistress', 4, 'It''s a bittersweet beer.');



COMMIT TRANSACTION;
