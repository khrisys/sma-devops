# -- MariaDB script
REVOKE ALL PRIVILEGES ON *.* FROM 'khris'@'%'; GRANT RELOAD, SHUTDOWN, PROCESS, REFERENCES, SHOW DATABASES, SUPER, LOCK TABLES, REPLICATION SLAVE, REPLICATION CLIENT, CREATE USER ON *.* TO 'khris'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
# GRANT ALL PRIVILEGES ON *.* TO 'khris'@'%' IDENTIFIED BY '123456' WITH GRANT OPTION;
# -- CREATE ROLE khris WITH
# -- LOGIN SUPERUSER CREATEDB NOCREATEROLE INHERIT NOREPLICATION PASSWORD '1234';
# --
# -- GRANT postgres TO khris;
# -- GRANT khris TO pg_read_all_data;
# --
# --
# -- -- CREATE USER docker;
# -- CREATE DATABASE test;
# -- -- GRANT ALL PRIVILEGES ON DATABASE postgres TO docker;
# -- CREATE USER postgres SUPERUSER;
# -- CREATE DATABASE postgres WITH OWNER postgres;
# --
# CREATE USER khris WITH PASSWORD '1234';
# CREATE ROLE khris SUPERUSER LOGIN PASSWORD '1234';
# GRANT ALL PRIVILEGES ON DATABASE 'garage-db' TO khris;
# CREATE ROLE admin WITH CREATEDB CREATEROLE;
# GRANT ALL PRIVILEGES ON *.* TO 'khris'@'%' WITH GRANT OPTION;

# CREATE USER 'khris'@'%' IDENTIFIED BY '1234';
# GRANT ALL PRIVILEGES ON *.* TO 'khris'@'%' WITH GRANT OPTION;
# CREATE ROLE khris WITH ADMIN 'khris'@'%';

# CREATE USER 'root'@'%' IDENTIFIED BY 'root';
# GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
# GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root';

-- create a table
# CREATE TABLE test(
#                      id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
#                      name TEXT NOT NULL,
#                      archived BOOLEAN NOT NULL DEFAULT FALSE
# );

-- add test data
# INSERT INTO test (name, archived)
# VALUES ('test row 1', true),
#        ('test row 2', false);

-- CREATE USER 'khris'@'%' IDENTIFIED BY '1234';
-- GRANT ALL PRIVILEGES ON *.* TO 'khris'@'%' WITH GRANT OPTION;
--
-- CREATE USER 'toto'@'%' IDENTIFIED BY '1234';
-- GRANT ALL PRIVILEGES ON *.* TO 'toto'@'%' WITH GRANT OPTION;
--
-- CREATE USER 'root'@'%' IDENTIFIED BY 'root';
-- GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
-- GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root';

-- Enable client program to communicate with the server using utf8 character set
SET NAMES 'utf8';

DROP DATABASE IF EXISTS `sakila`;
-- Set the default charset to utf8 for internationalization, use case-insensitive (ci) collation
CREATE DATABASE IF NOT EXISTS `sakila` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `sakila`;
CREATE TABLE employees (
                           emp_no      INT             NOT NULL,  -- UNSIGNED AUTO_INCREMENT??
                           birth_date  DATE            NOT NULL,
                           first_name  VARCHAR(14)     NOT NULL,
                           last_name   VARCHAR(16)     NOT NULL,
                           gender      ENUM ('M','F')  NOT NULL,  -- Enumeration of either 'M' or 'F'
                           hire_date   DATE            NOT NULL
);



