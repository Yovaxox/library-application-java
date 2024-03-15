package Classes;

import java.util.ArrayList;

public class Library {
    private ArrayList<User> users;
    private ArrayList<Book> books;

    public Library(User[] users, Book[] books) {
        this.users = new ArrayList<User>();
        this.books = new ArrayList<Book>();
        for (User user : users) {
            this.users.add(user);
        }
        for (Book book : books) {
            this.books.add(book);
        }
    }

    // Getters
    public ArrayList<User> getUsers() {
        return this.users;
    }
    public ArrayList<Book> getBooks() {
        return this.books;
    }

    // Setters
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // Methods
    public void showUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
