CREATE DATABASE IF NOT EXISTS cake_shop;
USE cake_shop;

CREATE TABLE IF NOT EXISTS orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(100),
    quantity INT,
    price DOUBLE,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    address TEXT,
    delivery_date DATE,
    cake_weight DOUBLE,
    payment_method VARCHAR(50),
    order_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
