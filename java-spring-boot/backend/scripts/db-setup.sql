CREATE DATABASE ecommerce;

CREATE USER ecommerce@localhost IDENTIFIED BY 'test12345';

GRANT ALL PRIVILEGES ON ecomerce.* TO 'ecommerce'@'localhost';

--insert into ecommerce.user (login, name, password, role) values('admin', 'Administrator', '$2a$10$LttgU2TW6ebQLkEK5iYDLeW7CCCPfU1umOADN/hh5rPddds/v0oEm', 'ADMIN');
--insert into ecommerce.user (login, name, password, role) values('customer', 'Customer', '$2a$10$LttgU2TW6ebQLkEK5iYDLeW7CCCPfU1umOADN/hh5rPddds/v0oEm', 'CUSTOMER');
