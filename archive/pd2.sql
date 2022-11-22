DROP DATABASE flightsdb;
CREATE DATABASE flightsdb;
USE flightsdb;


CREATE TABLE city (
    city_id INT NOT NULL PRIMARY KEY,
    city_name VARCHAR(15)
);

CREATE TABLE stopover (
    stopover_id INT NOT NULL PRIMARY KEY,
    stopover_date DATE,
    stopover_time TIME,
    stopover_city INT,
    FOREIGN KEY (stopover_city) REFERENCES city(city_id) ON DELETE CASCADE
);

CREATE TABLE flight (
    flight_id INT NOT NULL PRIMARY KEY,
    origin INT,
    destination INT,
    departure_date DATE,
    departure_time TIME,
    stopover_id INT,
    arrival_date DATE,
    arrival_time TIME,
    flight_cost INT,
    FOREIGN KEY (origin) REFERENCES city(city_id) ON DELETE CASCADE,
    FOREIGN KEY (destination) REFERENCES city(city_id) ON DELETE CASCADE,
    FOREIGN KEY (stopover_id) REFERENCES stopover(stopover_id) ON DELETE CASCADE
);

CREATE TABLE passenger (
    passenger_id INT NOT NULL PRIMARY KEY,
    flight_id INT,
    first_name VARCHAR(15),
    middle_initial VARCHAR(15),
    last_name VARCHAR(15),
    birthday DATE,
    gender  VARCHAR(15),
    CHECK
        ( gender IN ( 'Male', 'Female')),
    FOREIGN KEY (flight_id) REFERENCES flight(flight_id) ON DELETE CASCADE
);

CREATE TABLE luggage (
    luggage_id  INT NOT NULL PRIMARY KEY,
    passenger_id INT,
    description  VARCHAR(255),
    qty INT,
    luggage_cost INT,
    FOREIGN KEY (passenger_id) REFERENCES passenger(passenger_id) ON DELETE CASCADE
);

CREATE TABLE crew (
    crew_id  INT NOT NULL PRIMARY KEY,
    flight_id INT,
    firstName VARCHAR(15),
    lastName VARCHAR(15),
    role VARCHAR(255),
    FOREIGN KEY (flight_id) REFERENCES flight(flight_id) ON DELETE CASCADE
);

INSERT INTO city
VALUES (1111, 'Manila');

INSERT INTO city
VALUES (2222, 'Sydney');

INSERT INTO city
VALUES (3333, 'Batangas');

INSERT INTO city
VALUES (4444, 'New York');

INSERT INTO city
VALUES (5555, 'Paris');


INSERT INTO stopover
VALUES (9876, '2022-08-02', '12:13:00', 3333 );

INSERT INTO stopover
VALUES (9842, '2022-07-02', '6:12:00', 1111 );

INSERT INTO stopover
VALUES (9812, '2022-07-22', '22:00:00', 4444 );

INSERT INTO stopover
VALUES (9845, '2022-02-09', '4:13:00', 5555 );

INSERT INTO stopover
VALUES (9811, '2022-01-12', '6:22:00', 4444 );

INSERT INTO stopover
VALUES (9855, '2022-02-26', '12:45:00', 4444 );

INSERT INTO stopover
VALUES (9809, '2022-03-27', '00:01:00', 2222 );

INSERT INTO stopover
VALUES (9841, '2022-07-11', '14:13:00', 3333);

INSERT INTO stopover
VALUES (9899, '2022-05-23', '13:30:00', 4444 );

INSERT INTO stopover
VALUES (9887, '2022-04-04', '12:30:00', 1111 );


INSERT INTO flight
VALUES (2354, 1111, 2222, '2022-08-02', '11:12:00', 9876, '2022-08-02', '13:44:00', 60000);

INSERT INTO flight
VALUES (1246, 3333, 2222, '2022-07-01', '1:12:00', 9842, '2022-07-01', '12:24:00', 17759);

INSERT INTO flight
VALUES (9452, 4444, 2222, '2022-07-22', '15:12:00', 9812, '2022-07-23', '02:12:00', 21104);

INSERT INTO flight
VALUES (5647, 2222, 1111, '2022-02-09', '2:12:00', 9845, '2022-02-09', '22:53:00', 33730);

INSERT INTO flight
VALUES (1241, 5555, 2222, '2022-01-12', '4:12:00', 9811, '2022-01-12', '13:57:00', 43596);

INSERT INTO flight
VALUES (5923, 3333, 5555, '2022-02-25', '0:00:00', 9855, '2022-02-25', '16:29:00', 34289);

INSERT INTO flight
VALUES (7829, 4444, 1111, '2022-03-26', '22:12:00', 9809, '2022-03-27', '21:07:00', 38098);

INSERT INTO flight
VALUES (4283, 1111, 4444, '2022-07-11', '10:05:00', 9841, '2022-07-11', '21:16:00', 7450);

INSERT INTO flight
VALUES (1921, 1111, 5555, '2022-05-22', '11:59:00', 9899, '2022-05-23', '09:01:00', 42436);

INSERT INTO flight
VALUES (2312, 4444, 3333, '2022-04-04', '9:10:00', 9887, '2022-04-05', '15:20:00', 22415);


INSERT INTO passenger
VALUES (01, 2354, 'Rick', 'Paul','Astley', '1966-2-6', 'Male');

INSERT INTO passenger
VALUES (02, 1246, 'Quandale', 'Lingle','Dinglelingle', '2001-9-11', 'Male');

INSERT INTO passenger
VALUES (03, 9452, 'Sleve', 'Sheesh','Mcdichael', '1980-1-2', 'Female');

INSERT INTO passenger
VALUES (04, 5647, 'Onson', 'Deez','Sheemey', '1932-5-20', 'Female');

INSERT INTO passenger
VALUES (05, 1241, 'Darryl', 'Rac','Archideld', '2001-12-24', 'Male');

INSERT INTO passenger
VALUES (06, 1241, 'Anatoli', 'Ray','Smorin', '2000-9-16', 'Female');

INSERT INTO passenger
VALUES (07, 5923, 'Rey', 'Marc','Mcsriff', '2002-7-2', 'Male');

INSERT INTO passenger
VALUES (08, 7829, 'Glenallen', 'Alissandra','Mixon', '1999-1-9', 'Female');

INSERT INTO passenger
VALUES (09, 4283, 'Mario', 'Super','Lugio', '1986-12-1', 'Male');

INSERT INTO passenger
VALUES (10, 1921, 'Amogus', 'Anthony','Imposter', '2019-8-21', 'Male');


INSERT INTO luggage
VALUES (81, 01, 'Extra Baggage', 21,2000);

INSERT INTO luggage
VALUES (82, 02, 'No Baggage', 0,0);

INSERT INTO luggage
VALUES (83, 01, 'Lots of Rocks', 16,5000);

INSERT INTO luggage
VALUES (84, 03, 'Has Water', 31,22000);

INSERT INTO luggage
VALUES (85, 04, 'Has a Thing', 62,4120);

INSERT INTO luggage
VALUES (86, 05, 'Kinda Heavy', 89,43000);

INSERT INTO luggage
VALUES (87, 06, 'Pretty Sus', 90,90000);

INSERT INTO luggage
VALUES (88, 07, 'Very Heavy', 60,6100);

INSERT INTO luggage
VALUES (89, 08, 'A lot of Extra Baggage', 62,1000);

INSERT INTO luggage
VALUES (90, 09, 'Lots of Stuff in it', 42,200);


INSERT INTO crew
VALUES (11, 2354, 'Raul', 'Chamgerlain', 'Pilot');

INSERT INTO crew
VALUES (22, 2354, 'Kevin', 'Nogilny', 'Copilot');

INSERT INTO crew
VALUES (33, 1246, 'Willie', 'Dustice', 'Flight Attendant');

INSERT INTO crew
VALUES (44, 9452, 'Jeromy', 'Gride', 'Federal Air Marshal');

INSERT INTO crew
VALUES (55, 5647, 'Scott', 'Dourque', 'Cabin Service Agent');

INSERT INTO crew
VALUES (66, 1241, 'Shown', 'Furcotte', 'Emergency Doctor');

INSERT INTO crew
VALUES (77, 5923, 'Dean', 'Wesrey', 'Flight Engineer');

INSERT INTO crew
VALUES (88, 5923, 'Mincraf', 'Steve', 'Navigator');

INSERT INTO crew
VALUES (99, 7829, 'Mike', 'Truk', 'Radio Operator');

INSERT INTO crew
VALUES (111, 4283, 'Dwigt', 'Rortugal', 'Loadmaster');