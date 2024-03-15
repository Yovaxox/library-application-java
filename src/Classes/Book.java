package Classes;

import java.util.HashSet;
import java.util.Random;

public class Book {
    private static final HashSet<Integer> ids = new HashSet<>();
    private static final Random rand = new Random();
    private int id;
    private String name;
    private String author;
    private boolean isRented;

    public Book(String name, String author) {
        do {
            this.id = rand.nextInt(1000);
        } while(!ids.add(this.id)); // Ensure that the id is unique

        this.name = name;
        this.author = author;
        this.isRented = false;
    }

    // Getters
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getAuthor() {
        return this.author;
    }
    public boolean getIsRented() {
        return this.isRented;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }
}
