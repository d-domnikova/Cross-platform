CREATE TABLE tt_books (
    id UUID NOT NULL,
    version BIGINT NOT NULL,
    title varchar NOT NULL,
    author varchar NOT NULL,
    language varchar NOT NULL,
    age_rating varchar NOT NULL,
    PRIMARY KEY (id)
);