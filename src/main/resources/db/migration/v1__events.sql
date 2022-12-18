CREATE TABLE if NOT EXISTS event (
    id SERIAL,
    description VARCHAR (100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_attendees INT NOT NULL,
    city VARCHAR (20) NOT NULL,
    PRIMARY KEY (id)
    );