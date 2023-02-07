CREATE DATABASE IF NOT EXISTS university_db;

USE university_db;

CREATE TABLE Student
(
    id         INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(50),
    address_id INT,
    FOREIGN KEY (address_id) REFERENCES
        Address (id)
);

INSERT INTO Student VALUES (1, "Oswald", "Octopus", "oswaldtheoctopus@bigcity.com", 1);

SELECT * FROM Student;

