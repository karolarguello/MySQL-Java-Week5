CREATE database IF NOT EXISTS coffee_shops;
use coffee_shops;
DROP TABLE IF EXISTS drinks;
DROP TABLE IF EXISTS coffee_shops;

CREATE TABLE coffee_shops(
	id int(10) NOT NULL auto_increment,
	name varchar(50),
	PRIMARY KEY (id)
);

CREATE TABLE drinks(
	id int(10) NOT NULL auto_increment,
	coffee_shops_id int(10) NOT NULL,
	drink_name varchar(30) NOT NULL,
	drink_price decimal(2,2) NOT NULL,
	drink_availability varchar(30),
	drink_type varchar(30),
	PRIMARY KEY (id),
	FOREIGN KEY(coffee_shops_id) references coffee_shops(id)
);