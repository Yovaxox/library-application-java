import java.util.ArrayList;
import java.util.Scanner;

import Classes.User;

public class Main {
    // Create an array list to store the users
    private static ArrayList<User> users = new ArrayList<>();
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
                    //registerNewBook(scanner);
                    break;
                case 3:
                    System.out.println("Register new book rental");
                    break;
                case 4:
                    System.out.println("List all registered users");
                    break;
                case 5:
                    System.out.println("List all registered books");
                    break;
                case 6:
                    System.out.println("List all users who have rented one book");
                    break;
                case 7:
                    System.out.println("List all books that have NOT been rented");
                    break;
                case 8:
                    System.out.println("List all books that have been rented");
                    break;
                default:
                    System.out.println("Invalid option");
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
        System.out.println("Please, select an option: ");
        int menuOption = scanner.nextInt();

        scanner.nextLine();

        System.out.print("\033[H\033[2J");

        return menuOption;
    }

    public static void registerNewUser(Scanner scanner) {
        try {
            System.out.println("Register new user");
        System.out.println("-----------------------------");

        // Get the user's name
        String userName = "";
        while (true) {
            System.out.println("Please, enter the user's name: ");
            userName = scanner.nextLine();
            if (userName != null && !userName.trim().isEmpty()) {
                break;
            }
            System.out.print("\033[H\033[2J");
            System.out.println("User's name cannot be empty. Please try again.");
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
                    System.out.println("User's age cannot be negative or zero. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.print("\033[H\033[2J");
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Create a new user
        users.add(new User(userName, age));
        System.out.println("Employee account created successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
