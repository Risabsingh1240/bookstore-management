package com.bookstore;

import java.sql.*;
import java.util.*;

public class BookDAO {

    // 1. ADD BOOK
    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, price, quantity) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getQuantity());
            ps.executeUpdate();
            System.out.println("Book added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 2. VIEW ALL BOOKS
    public void viewAllBooks() {
        String sql = "SELECT * FROM books";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- All Books ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    "Rs." + rs.getDouble("price") + " | " +
                    "Qty: " + rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 3. SEARCH BOOK BY TITLE
    public void searchBook(String keyword) {
        String sql = "SELECT * FROM books WHERE title LIKE ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- Search Results ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    "Rs." + rs.getDouble("price") + " | " +
                    "Qty: " + rs.getInt("quantity")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 4. UPDATE BOOK
    public void updateBook(int id, double price, int quantity) {
        String sql = "UPDATE books SET price=?, quantity=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, quantity);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Book updated successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 5. DELETE BOOK
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Book deleted successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}