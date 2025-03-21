CREATE DATABASE IF NOT EXISTS students;
USE students;

CREATE TABLE IF NOT EXISTS students_info (
    id INT PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    record_book_number VARCHAR(20) UNIQUE NOT NULL
    );

INSERT INTO students_info (last_name, first_name, middle_name, birth_date, record_book_number)
VALUES
    ('Петров', 'Олег', 'Іванович', '2000-05-15', 'KB12345'),
    ('Іванова', 'Марія', 'Олегівна', '2001-07-22', 'KB12346'),
    ('Сидоренко', 'Павло', 'Миколайович', '1999-12-03', 'KB12347'),
    ('Коваленко', 'Анна', 'Сергіївна', '2000-03-10', 'KB12348');