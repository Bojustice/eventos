CREATE TABLE if NOT EXISTS conference (
    id SERIAL,
    title VARCHAR (100) NOT NULL,
    speaker VARCHAR (50) NOT NULL,
    hora TIME NOT NULL,
    dia DATE NOT NULL,
    total_attendees VARCHAR (20) NOT NULL,
    event_id int
    PRIMARY KEY (id),
    FOREIGN KEY (event_id),
    REFERENCES event(id)
    );