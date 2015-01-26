# Users schema

# --- !Ups

CREATE TABLE USERS (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    username varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    firstname varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    city_id int(10) NOT NULL,
    country_id int(10) NOT NULL,
    role_id int(10) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO USERS (id, username, name, firstname, email, password, city_id, country_id, role_id) VALUES (1, 'dp', 'Pinezich', 'David', 'david.pinezich@gmail.com', 'dd', 1,1,1), (2, 'hm', 'Muster', 'Hans', 'hans.muster@gmail.com', 'hh', 1,1,2),(3, 'pl', 'Lustig', 'Peter', 'peter.lustig@gmail.com', 'pp', 1,1,2);

CREATE TABLE CITY (
    city_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
        PRIMARY KEY (city_id)
);

INSERT INTO CITY (name) VALUES ('Zurich'), ('Bern'), ('Bremen');


CREATE TABLE COUNTRY (
    country_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    PRIMARY KEY (country_id)
);

INSERT INTO COUNTRY (name) VALUES ('Schweiz'), ('Deutschland'), ('Ungarn');


CREATE TABLE ROLE (
    role_id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    access int(10) NOT NULL,
        PRIMARY KEY (role_id)
);

INSERT INTO ROLE (name, access) VALUES ('admin', 1), ('user', 2);
# --- !Downs

DROP TABLE USERS;
DROP TABLE CITY;
DROP TABLE COUNTRY;
DROP TABLE ROLE;