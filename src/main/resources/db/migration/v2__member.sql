CREATE TABLE if NOT EXISTS member (
    id SERIAL,
    fullname VARCHAR (50) NOT NULL,
    email VARCHAR NOT NULL,
    age int NOT NULL,
    PRIMARY KEY (id),
    );