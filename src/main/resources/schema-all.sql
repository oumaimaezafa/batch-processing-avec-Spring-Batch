DROP TABLE IF EXISTS PRODUCTS;

CREATE TABLE PRODUCTS (
                          id BIGINT IDENTITY PRIMARY KEY,
                          NAME VARCHAR(100),
                          PRICE DOUBLE
);

DROP TABLE IF EXISTS orders;

CREATE TABLE orders (
                        orderId INT PRIMARY KEY,
                        customerName VARCHAR(100),
                        amount DOUBLE
);
