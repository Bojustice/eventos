CREATE TABLE if NOT EXISTS register (
    id SERIAL,
    member_id INT NOT NULL,
    conference_id INT NOT NULL,
    code INT NOT NULL,
    registered_at VARCHAR (40) NOT NULL,
    assisted VARCHAR (20) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (member_id),
    REFERENCES member(id),
    FOREIGN KEY (conference_id),
    REFERENCES conference(id),
    UNIQUE (code)
    );