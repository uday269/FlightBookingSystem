import java.util.Scanner;

public class FlightBookingSystem {
    private static final int MAX_USERS = 100;
    private static final int MAX_FLIGHTS = 10;
    private static final int MAX_BOOKINGS = 100;

    private static String[] usernames = new String[MAX_USERS];
    private static String[] passwords = new String[MAX_USERS];
    private static int userCount = 0;

    private static String[] flightNames = new String[MAX_FLIGHTS];
    private static String[] flightNumbers = new String[MAX_FLIGHTS];
    private static String[] flightDates = new String[MAX_FLIGHTS];
    private static int[] seatsAvailable = new int[MAX_FLIGHTS];
    private static int flightCount = 0;

    private static int[][] bookings = new int[MAX_BOOKINGS][2];
    private static int bookingCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. User Login");
            System.out.println("2. User Signup");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    userSignup();
                    break;
                case 3:
                    adminLogin();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void userLogin() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int userId = authenticateUser(username, password);

        if (userId != -1) {
            userMenu(userId);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void userSignup() {
        System.out.print("Enter a new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter a password: ");
        String newPassword = scanner.nextLine();

        usernames[userCount] = newUsername;
        passwords[userCount] = newPassword;
        userCount++;

        System.out.println("User registration successful. You can now log in.");
    }

    private static int authenticateUser(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                return i + 1; // Return user ID (1-based index)
            }
        }
        return -1; // User not found
    }

    private static void userMenu(int userId) {
        while (true) {
            System.out.println("1. Search Flights");
            System.out.println("2. Book Ticket");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    searchFlights();
                    break;
                case 2:
                    bookTicket(userId);
                    System.out.println("Booking conformed");
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void searchFlights() {
        System.out.print("Enter search term (Flight name/Date/Flight Number): ");
        String searchTerm = scanner.nextLine();

        // Implement flight search logic here
        // Display the list of available flights
    }

    private static void bookTicket(int userId) {
        // Implement ticket booking logic here
        // Update the bookings array and decrement seatsAvailable for the selected flight
    }

    private static void adminLogin() {
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        // Implement admin authentication logic here

        if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials. Please try again.");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("1. Add Flight");
            System.out.println("2. View Bookings");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addFlight();
                    break;
                case 2:
                    viewBookings();
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addFlight() {
        // Implement logic to add a new flight to the system
    }

    private static void viewBookings() {
        // Implement logic to view bookings with filtering options
    }
}
