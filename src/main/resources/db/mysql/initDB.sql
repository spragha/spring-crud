CREATE DATABASE IF NOT EXISTS bank;
GRANT ALL PRIVILEGES ON bank.* TO pc@localhost IDENTIFIED BY 'pc';

USE bank;

CREATE TABLE IF NOT EXISTS customer (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20),
  INDEX(last_name)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS account (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  acc_number VARCHAR(30),
  acc_creation_date DATE,
  acc_type INT(4),  
  customer_id INT(4) UNSIGNED NOT NULL, 
  INDEX(acc_number),
  FOREIGN KEY (customer_id) REFERENCES customer(id)
  ) engine=InnoDB;
  
