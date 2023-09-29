BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');
INSERT INTO private static final Brewery BREWERY_1 = new Brewery("Cool name", "(302)444-7788", "Fun and vibey place", "Mon-Fri 1-10pm", "image.test.com", "123 Fun Road", "Middletwon", "OR", 12345, true, "Joe");
INSERT INTO private static final Brewery BREWERY_2 = new Brewery("Lovely Place", "(302)333-9999", "Since 1992", "Mon-Fri 5-10pm", "image.test.org", "123 Lilac Road", "Middletwon", "OR", 12333, true, "Jim");
INSERT INTO private static final Brewery BREWERY_3 = new Brewery("Yonkers", "(302)989-2211", "Nice place to hang", "Mon-Fri 2-10pm", "image.test.jpeg", "123 Farm Road", "Middletwon", "OR", 12444, true, "Josh");


COMMIT TRANSACTION;
