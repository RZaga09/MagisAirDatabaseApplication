-- I created this mock database and populated it with data so we can explore the 
-- principles behind connecting a server to the application we are building. If
-- some of the data here sounds nonsensical, that's because it partly is and is
-- only meant to fill the database with data we can retrieve. Feel free to add
-- more mock data if you want.

-- We'll replace this database with the database schema for our project once it
-- becomes available. Hopefully by the time we replace the database we would have
-- become familiar with conneceting an application to a database. ~ ray

-- created on 10/31/2022

-- SCHEMA SQL
CREATE DATABASE booksdb;
USE booksdb;
CREATE TABLE author
(
    authorid INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
	firstname VARCHAR(255),
	lastname VARCHAR(255),
	address TEXT
);

CREATE TABLE publisher
(
	pubid INT NOT NULL AUTO_INCREMENT UNIQUE PRIMARY KEY,
	pubname VARCHAR(255),
	pubcity VARCHAR(255),
	pubstate VARCHAR(255)
);

CREATE TABLE book
(
	ISBN VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
	bookname VARCHAR(255),
	price FLOAT(3),
	royalty FLOAT(3),
	pubid INT NOT NULL,
	FOREIGN KEY (pubid) REFERENCES publisher(pubid)
);

CREATE TABLE bookauthor
(
	ISBN VARCHAR(255) NOT NULL,
	authorid INT NOT NULL,
	PRIMARY KEY(ISBN, authorid),
	FOREIGN KEY (ISBN) REFERENCES book(ISBN),
	FOREIGN KEY (authorid) REFERENCES author(authorid)
);

-- QUERY SQL
INSERT INTO author(firstname, lastname, address)
VALUES ('Stuart', 'Little', 'New York, USA');

INSERT INTO author(firstname, lastname, address)
VALUES ('Mark', 'Zuckerburg', 'Silicon Valley, USA');

INSERT INTO author(firstname, lastname, address)
VALUES ('Ciaphas', 'Cain', 'Cadia, Segmentum Ultima');

INSERT INTO author(firstname, lastname, address)
VALUES ('Barbie', 'Girl', 'Barbieland');

INSERT INTO author(firstname, lastname, address)
VALUES ('Harry', 'Potter', 'Hagwarts, Scotland');

INSERT INTO publisher(pubname, pubcity, pubstate)
VALUES ('Ateneo De Manila University Press', 'Quezon City', 'Metro Manila');

INSERT INTO publisher(pubname, pubcity, pubstate)
VALUES ('Bibliotech', 'Madrid', 'Spain');

INSERT INTO publisher(pubname, pubcity, pubstate)
VALUES ('Hogwarts Publishing', 'Hogwarts', 'Scotland');

INSERT INTO publisher(pubname, pubcity, pubstate)
VALUES ('The City That We Love', 'Pompeii', 'Italy');

INSERT INTO publisher(pubname, pubcity, pubstate)
VALUES ('Librarius of Ultramar', 'Ultramar', 'Segmentum Obscurus');

INSERT INTO book(ISBN, bookname, price, royalty, pubid)
VALUES ('1234567890', 'Hero of the Imperium!', 500, 500, 5);

INSERT INTO book(ISBN, bookname, price, royalty, pubid)
VALUES ('0654321', 'Potion Making for Dummies', 21, 180, 3);

INSERT INTO book(ISBN, bookname, price, royalty, pubid)
VALUES ('10252022', 'Volcano Goes Boom', 1234, 501, 4);

INSERT INTO book(ISBN, bookname, price, royalty, pubid)
VALUES ('31123333', 'Libro de Español', 50, 50, 2);

INSERT INTO book(ISBN, bookname, price, royalty, pubid)
VALUES ('56730485', 'Why Ateneo is Superior', 100, 50, 1);

INSERT INTO bookauthor(ISBN, authorid)
VALUES ('1234567890', 3);

INSERT INTO bookauthor(ISBN, authorid)
VALUES ('0654321', 5);

INSERT INTO bookauthor(ISBN, authorid)
VALUES ('10252022', 4);

INSERT INTO bookauthor(ISBN, authorid)
VALUES ('31123333', 2);

INSERT INTO bookauthor(ISBN, authorid)
VALUES ('56730485', 1);






