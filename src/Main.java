import java.util.ArrayList;
import java.util.Scanner;

import Classes.Book;
import Classes.User;

public class Main {
    // Create an array list to store the users
    private static ArrayList<User> users = new ArrayList<>();
    // Create an array list to store the books
    private static ArrayList<Book> books = new ArrayList<>();
    public static void main(String[] args) {
        // Creating a new scanner object
        Scanner scanner = new Scanner(System.in);

        // Clear the screen and print the welcome message
        System.out.print("\033[H\033[2J");
        System.out.println("Welcome to the Library Application.");

        // Initializing option variable to get user's input
        int firstMenuOption = getFirstMenuOption(scanner);

        while (firstMenuOption != 9) {
            System.out.print("\033[H\033[2J");
            switch (firstMenuOption) {
                case 1:
                    registerNewUser(scanner);
                    break;
                case 2:
                    registerNewBook(scanner);
                    break;
                case 3:
                    registerNewBookRental(scanner);
                    break;
                case 4:
                    listAllRegisteredUsers(scanner);
                    break;
                case 5:
                    listAllRegisteredBooks(scanner);
                    break;
                case 6:
                    listAllUsersHaveRented(scanner);
                    break;
                case 7:
                    listAllBooksNotRented(scanner);
                    break;
                case 8:
                    listAllBooksRented(scanner);
                    break;
                default:
                    System.out.println("\033[0;31m" + "Invalid option" + "\033[0m");
                    break;
            }

            firstMenuOption = getFirstMenuOption(scanner);
        }
        System.out.println("You have exited the application.");
        // Close the scanner
        scanner.close();
    }

    public static int getFirstMenuOption(Scanner scanner) {
        // Print the first menu
        System.out.println("-----------------------------------------------");
        System.out.println("| 1. Register new user                        |");
        System.out.println("| 2. Register new book                        |");
        System.out.println("| 3. Register new book rental                 |");
        System.out.println("| 4. List all registered users                |");
        System.out.println("| 5. List all registered books                |");
        System.out.println("| 6. List all users who have rented one book  |");
        System.out.println("| 7. List all books that have NOT been rented |");
        System.out.println("| 8. List all books that have been rented     |");
        System.out.println("| 9. Exit the application                     |");
        System.out.println("-----------------------------------------------");

        // Get the user's input
        System.out.print("Please, select an option: ");
        int menuOption = scanner.nextInt();

        scanner.nextLine();

        System.out.print("\033[H\033[2J");

        return menuOption;
    }

    public static void registerNewUser(Scanner scanner) {
        try {
        System.out.println("---------------------");
        System.out.println("| Register new user |");
        System.out.println("---------------------");

        // Get the user's name
        String userName = "";
        while (true) {
            System.out.print("\nPlease, enter the user's name: ");
            userName = scanner.nextLine();
            if (userName != null && !userName.trim().isEmpty()) {
                break;
            }
            System.out.print("\033[H\033[2J");
            System.out.println("\033[0;31m" + "User's name cannot be empty. Please try again." + "\033[0m");
        }

        // Get the user's age
        int age = 0;
        while (true) {
            try {
                System.out.print("Please, enter the user's age: ");
                age = Integer.parseInt(scanner.nextLine());

                // Exit the loop if the input was valid
                if (age > 0) {
                    break;  
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.println("\033[0;31m" + "User's age cannot be negative or zero. Please try again." + "\033[0m");
                }
            } catch (NumberFormatException e) {
                System.out.print("\033[H\033[2J");
                System.out.println("\033[0;31m" + "Invalid input. Please enter a number." + "\033[0m");
            }
        }

        System.out.print("\033[H\033[2J");

        // Create a new user
        users.add(new User(userName, age));
        System.out.println("\033[0;32m" + "Employee account created successfully." + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }

    public static void registerNewBook(Scanner scanner) {
        try {
            System.out.println("---------------------");
            System.out.println("| Register new book |");
            System.out.println("---------------------");

            // Get the book's title
            String bookTitle = "";
            while (true) {
                System.out.print("Please, enter the book's title: ");
                bookTitle = scanner.nextLine();
                if (bookTitle != null && !bookTitle.trim().isEmpty()) {
                    break;
                }
                System.out.print("\033[H\033[2J");
                System.out.println("\033[0;31m" + "Book's title cannot be empty. Please try again." + "\033[0m");
            }

            // Get the book's author
            String bookAuthor = "";
            while (true) {
                System.out.print("Please, enter the book's author: ");
                bookAuthor = scanner.nextLine();
                if (bookAuthor != null && !bookAuthor.trim().isEmpty()) {
                    break;
                }
                System.out.print("\033[H\033[2J");
                System.out.println("\033[0;31m" + "Book's author cannot be empty. Please try again." + "\033[0m");
            }

            System.out.print("\033[H\033[2J");

            // Create a new book
            books.add(new Book(bookTitle, bookAuthor));
            System.out.println("\033[0;32m" + "Book registered successfully." + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }

    public static void registerNewBookRental(Scanner scanner) {
        try {
            if (users.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered users. Please, register a new user first." + "\033[0m");
                return;
            } else if (books.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered books. Please, register a new book first." + "\033[0m");
                return;
            }

            System.out.println("----------------------------");
            System.out.println("| Register new book rental |");
            System.out.println("----------------------------");

            // Get the user's ID
            int userId = 0;
            while (true) {
                try {
                    // Display all users
                    System.out.println("\nList of all registered users");
                    System.out.println("-----------------------------");
                    for (User user : users) {
                        System.out.println("ID: " + user.getId() + " | Name: " + user.getName() + " | Age: " + user.getAge());
                    }

                    System.out.print("\nPlease enter the user's ID to rent a book. Check the list above: ");
                    userId = Integer.parseInt(scanner.nextLine());

                    // Check if the user's id is valid
                    boolean userExists = false;
                    for (User user : users) {
                        if (user.getId() == userId) {
                            userExists = true;
                            break;
                        }
                    }

                    // If the user's id does not exist, display an error message
                    if (!userExists) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("\033[0;31m" + "User's id does not exist. Please try again." + "\033[0m");
                        continue; // Go back to the beginning of the loop
                    } else {
                        System.out.print("\033[H\033[2J");
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("\033[0;31m" + "Invalid input. Please enter a number." + "\033[0m");
                }
            }

            System.out.println("----------------------------");
            System.out.println("| Register new book rental |");
            System.out.println("----------------------------");

            // Get the book's ID
            int bookId = 0;
            while (true) {
                try {
                    // Display all books
                    System.out.println("\nList of all unrented books");
                    System.out.println("-----------------------------");
                    for (Book book : books) {
                        if (!book.getIsRented()) {
                            System.out.println("ID: " + book.getId() + " | Name: " + book.getName() + " | Author: " + book.getAuthor());
                        }
                    }

                    System.out.print("\nPlease enter the book's ID to be rented. Check the list above: ");
                    bookId = Integer.parseInt(scanner.nextLine());

                    // Check if the book's id is valid and not rented
                    boolean bookExists = false;
                    for (Book book : books) {
                        if (book.getId() == bookId && !book.getIsRented()) {
                            bookExists = true;
                            break;
                        }
                    }

                    // If the book's id does not exist, display an error message
                    if (!bookExists) {
                        System.out.print("\033[H\033[2J");
                        System.out.println("\033[0;31m" + "Book's id does not exist. Please try again." + "\033[0m");
                        continue; // Go back to the beginning of the loop
                    } else {
                        System.out.print("\033[H\033[2J");
                        break;
                    }

                } catch (NumberFormatException e) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("\033[0;31m" + "Invalid input. Please enter a number." + "\033[0m");
                }
            }

            // Set the book as rented
            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.setIsRented(true);
                    break;
                }
            }

            // Set the rented book to the user
            for (User user : users) {
                // if the user's id matches the input..
                if (user.getId() == userId) {
                    for (Book book : books) {
                        // if the book's id matches the input..
                        if (book.getId() == bookId) {
                            // add the book to the user's rented books
                            user.getRentedBooks().add(book);
                            break;
                        }
                    }
                    break;
                }
            }

            System.out.println("\033[0;32m" + "Book rented successfully." + "\033[0m");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }

    public static void listAllRegisteredUsers(Scanner scanner) {
        try {
            if (users.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered users." + "\033[0m");
                return;
            }

            System.out.println("------------------------");
            System.out.println("| List of all users    |");
            System.out.println("------------------------");

            for (User user : users) {
                System.out.println("ID: " + user.getId() + " | Name: " + user.getName() + " | Age: " + user.getAge());
            }

            // Press any key to continue
            System.out.print("\nPress any key to continue...");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }
    
    public static void listAllRegisteredBooks(Scanner scanner) {
        try {
            if (books.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered books." + "\033[0m");
                return;
            }

            System.out.println("------------------------");
            System.out.println("| List of all books    |");
            System.out.println("------------------------");

            for (Book book : books) {
                System.out.println("ID: " + book.getId() + " | Name: " + book.getName() + " | Author: " + book.getAuthor());
            }

            // Press any key to continue
            System.out.print("\nPress any key to continue...");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }

    public static void listAllUsersHaveRented(Scanner scanner) {
        try {
            // Check if there are no registered users
            if (users.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered users." + "\033[0m");
                return;
            }

            // Check if there are no rented books
            boolean hasRentedBooks = false;
            for (User user : users) {
                if (!user.getRentedBooks().isEmpty()) {
                    hasRentedBooks = true;
                    break;
                }
            }

            if (!hasRentedBooks) {
                System.out.println("\033[0;31m" + "There are no users who have rented a book." + "\033[0m");
                return;
            }

            System.out.println("----------------------------------------------");
            System.out.println("| List of all users who have rented one book |");
            System.out.println("----------------------------------------------\n");

            for (User user : users) {
                System.out.println("----------------------------------------------");
                if (!user.getRentedBooks().isEmpty()) {
                    System.out.println("ID: " + user.getId() + " | Name: " + user.getName() + " | Age: " + user.getAge());
                    System.out.println("\nRented books:");
                    for (Book book : user.getRentedBooks()) {
                        System.out.println("ID: " + book.getId() + " | Name: " + book.getName() + " | Author: " + book.getAuthor());
                    }
                }
                System.out.println("----------------------------------------------\n");
            }

            // Press any key to continue
            System.out.print("\nPress any key to continue...");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }

    public static void listAllBooksNotRented(Scanner scanner) {
        try {
            // Check if there are no registered books
            if (books.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered books." + "\033[0m");
                return;
            }

            // Check if there are no rented books
            boolean hasNotRentedBooks = false;
            for (Book book : books) {
                if (!book.getIsRented()) {
                    hasNotRentedBooks = true;
                    break;
                }
            }

            if (!hasNotRentedBooks) {
                System.out.println("\033[0;31m" + "There are no books that have not been rented." + "\033[0m");
                return;
            }

            System.out.println("-----------------------------------------------");
            System.out.println("| List of all books that have NOT been rented |");
            System.out.println("-----------------------------------------------\n");

            for (Book book : books) {
                if (!book.getIsRented()) {
                    System.out.println("ID: " + book.getId() + " | Name: " + book.getName() + " | Author: " + book.getAuthor());
                }
            }

            // Press any key to continue
            System.out.print("\nPress any key to continue...");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }

    public static void listAllBooksRented(Scanner scanner) {
        try {
            // Check if there are no registered books
            if (books.isEmpty()) {
                System.out.println("\033[0;31m" + "There are no registered books." + "\033[0m");
                return;
            }

            // Check if there are no rented books
            boolean hasRentedBooks = false;
            for (Book book : books) {
                if (book.getIsRented()) {
                    hasRentedBooks = true;
                    break;
                }
            }

            if (!hasRentedBooks) {
                System.out.println("\033[0;31m" + "There are no books that have been rented." + "\033[0m");
                return;
            }

            System.out.println("----------------------------------------------");
            System.out.println("| List of all books that have been rented    |");
            System.out.println("----------------------------------------------\n");

            for (Book book : books) {
                if (book.getIsRented()) {
                    System.out.println("ID: " + book.getId() + " | Name: " + book.getName() + " | Author: " + book.getAuthor());
                }
            }

            // Press any key to continue
            System.out.print("\nPress any key to continue...");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
        } catch (Exception e) {
            System.out.println("\033[0;31m" + "An error occurred: " + e.getMessage() + "\033[0m");
        }
    }
}
