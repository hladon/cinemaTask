CREATE TABLE movies (
    movie_id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    cost INT
);
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    movie INT NOT NULL,
    visitors INT,
    CONSTRAINT fk_order FOREIGN KEY(order_id) REFERENCES movies(movie_id)
);