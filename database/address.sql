CREATE DATABASE IF NOT EXISTS university_db;

USE university_db;

CREATE TABLE Address
(
    id   int NOT NULL PRIMARY KEY,
    area VARCHAR(50),
    city VARCHAR(50)
);

INSERT INTO Address VALUES (1, "Karol Bagh", "New Delhi");

SELECT * FROM Address;
