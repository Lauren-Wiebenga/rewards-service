DROP TABLE IF EXISTS transactions;

CREATE TABLE transactions (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    customer VARCHAR(250) NOT NULL,
    date DATE NOT NULL,
    amount DOUBLE NOT NULL
);

-- INSERT INTO transactions (customer, date, amount) VALUES ( 'fo', '2021-03-2', 12.22 );

INSERT INTO transactions (customer, date, amount) VALUES
('John Doe', '2021-05-29', 120.01),
('John Doe', '2021-05-11', 52.33),
('John Doe', '2021-05-30', 221.00),
('John Doe', '2021-06-01', 24.99),
('John Doe', '2021-06-19', 50.11),
('John Doe', '2021-07-09', 220.60),
('Smith Smithy', '2021-05-11', 34.22),
('Smith Smithy', '2021-05-20', 55.05),
('Smith Smithy', '2021-06-02', 44.23),
('Smith Smithy', '2021-07-23', 101.56),
('Smith Smithy', '2021-07-14', 78.09),
('Jane Deer', '2021-05-22', 99.12),
('Jane Deer', '2021-05-19', 100.34),
('Jane Deer', '2021-06-02', 55.99),
('Jane Deer', '2021-06-11', 29.55),
('Jane Deer', '2021-07-17', 60.12),
('Jane Deer', '2021-07-09', 44.24),
('Jane Deer', '2021-07-30', 13.33),
('Jane Deer', '2021-07-03', 50.99),
('Jane Deer', '2021-07-22', 06.10);