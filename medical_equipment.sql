# Create a database
CREATE DATABASE medical_equipment;

# Make medical_equipment the active database
USE medical_equipment;

# Create repairs table
CREATE TABLE repairs(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
equipment_id INT (11) UNSIGNED NOT NULL,
failure TEXT NOT NULL,
failure_date TEXT NOT NULL,
description INT (11),
date INT (11) NOT NULL,
user_id INT (11) NOT NULL,
parts TEXT,
price FLOAT NOT NULL,
status TEXT NOT NULL,
notes TEXT
);

# Create equipment table
CREATE TABLE equipment(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (250) NOT NULL,
serial VARCHAR (250) NOT NULL,
brand VARCHAR (250) NOT NULL,
model VARCHAR (250) NOT NULL,
purchase_date DATE,
prices FLOAT NOT NULL,
warranty VARCHAR (250),
calibration_period INT (11),
department_id INT (11) UNSIGNED NULL,
vendor_id INT (11) UNSIGNED NOT NULL,
service_contract BIT (1)
);

# Create users table
CREATE TABLE users(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR (50) NOT NULL,
last_name VARCHAR (50) NOT NULL,
username VARCHAR (150) NOT NULL,
password VARCHAR (250) NOT NULL,
role INT (11) NOT NULL
);

# Create maintenance table
CREATE TABLE maintenance(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
frequency INT (11) NOT NULL,
color INT (11),
equipment_id INT (11) UNSIGNED NOT NULL
);

# Create calibration table
CREATE TABLE calibration(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
period DATE NOT NULL,
start_date DATE NOT NULL,
color INT (11),
notes TEXT,
equipment_id INT (11) UNSIGNED NOT NULL
);

# Create departments table
CREATE TABLE departments(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (250) NOT NULL,
phone VARCHAR (50) NOT NULL
);


# Create vendors table
CREATE TABLE vendors(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (500) NOT NULL,
address VARCHAR (500) NOT NULL,
phone VARCHAR (50) NOT NULL
);

# Create maintenance_schedual table
CREATE TABLE maintenance_schedual(
id INT (11) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
maintenance_id INT (11) UNSIGNED NOT NULL,
date DATE NOT NULL,
notes TEXT
);

# Insert users data
INSERT INTO users VALUES(NULL, 'Ahmad', 'Sebaq', 'asebaq', 'as7313', 1);
INSERT INTO users VALUES(NULL, 'Ahmad', 'Hussein', 'ahmd', '0100500', 2);
INSERT INTO users VALUES(NULL, 'Yousra', 'Mohammed', 'mai', 'mai22', 2);
INSERT INTO users VALUES(NULL, 'Dalia', 'Mostafa', 'dalia', 'dalia22', 3);








