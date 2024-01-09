CREATE TABLE book
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    isbn VARCHAR   NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (isbn)
);
