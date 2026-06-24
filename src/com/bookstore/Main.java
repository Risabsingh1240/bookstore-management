package com.bookstore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BookDAO dao = new BookDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== BOOK STORE MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    dao.addBook(new Book(0, title, author, price, qty));
                    break;
                case 2:
                    dao.viewAllBooks();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter book name to search: ");
                    String keyword = sc.nextLine();
                    dao.searchBook(keyword);
                    break;
                case 4:
                    System.out.print("Enter Book ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new Price: ");
                    double newPrice = sc.nextDouble();
                    System.out.print("Enter new Quantity: ");
                    int newQty = sc.nextInt();
                    dao.updateBook(uid, newPrice, newQty);
                    break;
                case 5:
                    System.out.print("Enter Book ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteBook(did);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}