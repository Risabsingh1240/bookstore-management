package com.bookstore;

public class Book {
    
    // Properties
    private int id;
    private String title;
    private String author;
    private double price;
    private int quantity;

    // Constructor
    public Book(int id, String title, String author, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Setters
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Display
    public String toString() {
        return id + " | " + title + " | " + author + " | Rs." + price + " | Qty: " + quantity;
    }
}
