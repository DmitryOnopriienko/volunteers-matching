DROP DATABASE IF EXISTS volunteer_matching;

CREATE DATABASE IF NOT EXISTS volunteer_matching;

USE volunteer_matching;

DROP TABLE IF EXISTS initiative_has_skill;
DROP TABLE IF EXISTS volunteer_has_skill;
DROP TABLE IF EXISTS initiative_proposal;

DROP TABLE IF EXISTS skill;
DROP TABLE IF EXISTS initiative;
DROP TABLE IF EXISTS volunteer;

DROP TABLE IF EXISTS organization;
DROP TABLE IF EXISTS city;

CREATE TABLE IF NOT EXISTS city (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

INSERT INTO city (name)
VALUES ('Kyiv'),
       ('Lviv'),
       ('Zaporizhya');

CREATE TABLE IF NOT EXISTS organization (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(4096) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS skill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

INSERT INTO skill (name)
VALUES ('surgery'),
       ('management'),
       ('programming'),
       ('design'),
       ('marketing'),
       ('cooking'),
       ('driving');

CREATE TABLE IF NOT EXISTS initiative (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(4096) NOT NULL,
    is_active BOOLEAN NOT NULL,
    organization_id INT NOT NULL,
    city_id INT NOT NULL,
    FOREIGN KEY (organization_id) REFERENCES organization(id),
    FOREIGN KEY (city_id) REFERENCES city(id)
);

CREATE TABLE IF NOT EXISTS volunteer (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    city_id INT NOT NULL,
    FOREIGN KEY (city_id) REFERENCES city(id)
);

INSERT INTO volunteer (name, surname, email, phone, city_id)
VALUES ('Ivan', 'Ivanov', 'ii@gmail.com', '050 918 27 36', 1),
       ('Dmitry', 'Dmitriev', 'dd@gmail.com', '050 918 27 36', 2),
       ('Alex', 'Alexov', 'aa@gmail.com', '050 918 27 36', 3);

CREATE TABLE IF NOT EXISTS initiative_has_skill (
    initiative_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (initiative_id, skill_id),
    FOREIGN KEY (initiative_id) REFERENCES initiative(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);

CREATE TABLE IF NOT EXISTS volunteer_has_skill (
    volunteer_id INT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (volunteer_id, skill_id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);

INSERT INTO volunteer_has_skill (volunteer_id, skill_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 6),
       (3, 7);

CREATE TABLE IF NOT EXISTS initiative_proposal (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(4096) NOT NULL,
    city VARCHAR(255) NOT NULL,
    organization_id INT NOT NULL,
    FOREIGN KEY (organization_id) REFERENCES organization(id)
);