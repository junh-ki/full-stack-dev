CREATE DATABASE reservation;

USE reservation;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  email VARCHAR(20),
  password VARCHAR(256), 
  PRIMARY KEY (id),
  UNIQUE KEY (email)
);

CREATE TABLE flight (
  id INT  NOT NULL AUTO_INCREMENT,
  flight_number VARCHAR(20)  NOT NULL, 
  operating_airlines VARCHAR(20)  NOT NULL,
  departure_city VARCHAR(20)  NOT NULL,
  arrival_city VARCHAR(20)  NOT NULL,
  date_of_departure DATE  NOT NULL,
  estimated_departure_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (id)
);

CREATE TABLE passenger
(
  id         INT NOT NULL AUTO_INCREMENT,
  first_name       VARCHAR(256),
  last_name    VARCHAR(256),
  middle_name   VARCHAR(256),
  email VARCHAR(50),
  phone VARCHAR(10),
  PRIMARY KEY (id)
);

CREATE TABLE reservation
(
  id INT NOT NULL AUTO_INCREMENT,
  checked_in TINYINT(1),
  number_of_bags INT,
  passenger_id INT,
  flight_id INT,
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (passenger_id) REFERENCES passenger(id) ON DELETE CASCADE,
  FOREIGN KEY (flight_id) REFERENCES flight(id)
);

CREATE TABLE role (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE user_role(
  user_id int,
  role_id int,
  FOREIGN KEY (user_id)
  REFERENCES user(id),
  FOREIGN KEY (role_id)
  REFERENCES role(id)
);

INSERT INTO role VALUES(1, 'ADMIN');
INSERT INTO user_role VALUES(1, 1);

SELECT * FROM user;
SELECT * FROM passenger;
SELECT * FROM flight;
SELECT * FROM reservation;
SELECT * FROM role;
SELECT * FROM user_role;

DROP TABLE user;
DROP TABLE reservation;
DROP TABLE passenger;
DROP TABLE flight;
DROP TABLE role;
DROP TABLE user_role;

DROP DATABASE reservation;
