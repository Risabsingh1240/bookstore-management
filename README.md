# 📚 BookStore Management System

A console-based Book Store Management application built with Java and MySQL.

## 🛠️ Tech Stack
- Java
- MySQL
- JDBC
- OOP
- Git & GitHub

## ✨ Features
- Add new books
- View all books
- Search books by title
- Update book price and quantity
- Delete books

## 🗄️ Database
- Database: MySQL
- Table: books (id, title, author, price, quantity)

## 🚀 How to Run
1. Clone the repository
2. Create database in MySQL:
```sql
CREATE DATABASE bookstore_db;
USE bookstore_db;
CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(150) NOT NULL,
  author VARCHAR(100) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  quantity INT NOT NULL DEFAULT 0
);
```
3. Update DBConnection.java with your MySQL password
4.javac -cp "lib\mysql-connector-j-9.7.0.jar" -d bin src\com\bookstore*.java. Compile:
5. Run:java -cp "bin;lib\mysql-connector-j-9.7.0.jar" com.bookstore.Main

## 👨‍💻 Author
Risab Kumar