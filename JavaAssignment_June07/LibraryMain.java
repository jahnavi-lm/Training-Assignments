package JavaAssignment_June07;

import JavaAssignment_June07.LibraryManagement.exception.BookNotFoundException;
import JavaAssignment_June07.LibraryManagement.model.Book;
import JavaAssignment_June07.LibraryManagement.model.Member;
import JavaAssignment_June07.LibraryManagement.service.LibraryService;

import java.util.Scanner;
import java.util.List;

public class LibraryMain {
    private static LibraryService libraryService = new LibraryService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setData();

        System.out.println("Welcome to the Library Management System");
        while (true) {
            System.out.println("\n1. Admin Login");
            System.out.println("2. Member Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> memberMenu();
                case 3 -> {
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void setData() {
        libraryService.addBook(new Book("B1", "Java Basics", "James Gosling"));
        libraryService.addBook(new Book("B2", "Spring Boot", "Rod Johnson"));
        libraryService.addBook(new Book("B3", "The Alchemist", "Paulo Coelho"));
        libraryService.addBook(new Book("B4", "Clean Code", "Robert C. Martin"));
        libraryService.addBook(new Book("B5", "Harry Potter", "J.K. Rowling"));

        libraryService.addMember(new Member("M1", "Raju", "raju@gmail.com"));
        libraryService.addMember(new Member("M2", "Adi", "adi@gmail.com"));
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add Member");
            System.out.println("4. List All Books");
            System.out.println("5. List All Members");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> addMember();
                case 4 -> listBooks();
                case 5 -> listMembers();
                case 6 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void memberMenu() {
        System.out.print("Enter your Member ID: ");
        String memberId = scanner.nextLine();

        Member member = libraryService.getMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found. Returning to main menu.");
            return;
        }
        System.out.println("Welcome, " + member.getName());

        while (true) {
            System.out.println("\n--- Member Menu ---");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. List Available Books");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> issueBook(member);
                case 2 -> returnBook(member);
                case 3 -> listAvailableBooks();
                case 4 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Admin functions

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        Book book = new Book(bookId, title, author);
        libraryService.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        String bookId = scanner.nextLine();
        try {
            libraryService.removeBook(bookId);
            System.out.println("Book removed successfully.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addMember() {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Member Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Member Email: ");
        String email = scanner.nextLine();

        Member member = new Member(memberId, name, email);
        libraryService.addMember(member);
        System.out.println("Member added successfully.");
    }

    private static void listBooks() {
        List<Book> books = libraryService.getAllBooks();
        System.out.println("\nAll Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void listMembers() {
        List<Member> members = libraryService.getAllMembers();
        System.out.println("\nAll Members:");
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // Member functions

    private static void issueBook(Member member) {
        System.out.print("Enter Book ID to issue: ");
        String bookId = scanner.nextLine();

        try {
            libraryService.issueBook(bookId, member.getMemberId());
            System.out.println("Book issued successfully.");
        } catch (Exception e) {
            System.out.println("Error issuing book: " + e.getMessage());
        }
    }

    private static void returnBook(Member member) {
        System.out.print("Enter Book ID to return: ");
        String bookId = scanner.nextLine();

        try {
            libraryService.returnBook(bookId, member.getMemberId());
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }

    private static void listAvailableBooks() {
        List<Book> availableBooks = libraryService.getAvailableBooks();
        System.out.println("\nAvailable Books:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }
}
