package Classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class User {
    private static final HashSet<Integer> ids = new HashSet<>();
    private static final Random rand = new Random();
    private int id;
    private String name;
    private int age;
    private ArrayList<Book> rentedBooks;

    public User(String name, int age) {
        do {
            this.id = rand.nextInt(1000);
        } while (!ids.add(this.id)); // Ensure that the id is unique
        this.name = name;
        this.age = age;
        this.rentedBooks = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return this.id;
    }
    public int getAge() {
        return this.age;
    }
    public String getName() {
        return this.name;
    }
    public ArrayList<Book> getRentedBooks() {
        return this.rentedBooks;
    }

    // Setters
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRentedBooks(ArrayList<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    // Methods
}
