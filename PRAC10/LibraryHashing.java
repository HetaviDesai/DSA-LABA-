import java.util.Scanner;
import java.util.Stack;

public class LibraryHashing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create 10 shelves
        Stack<Integer>[] shelves = new Stack[10];

        for (int i = 0; i < 10; i++) {
            shelves[i] = new Stack<>();
        }

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        // Place each book on its shelf
        for (int i = 0; i < n; i++) {

            System.out.print("Enter book code: ");
            int code = sc.nextInt();

            // Hash function
            int shelf = code % 10;

            // Add book to the shelf
            shelves[shelf].push(code);

            System.out.println("Book " + code +
                    " added to shelf " + shelf);
        }

        // Display final contents of all shelves
        System.out.println("\nFinal Shelf Contents:");

        for (int i = 0; i < 10; i++) {

            System.out.print("Shelf " + i + ": ");

            if (shelves[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                System.out.println(shelves[i]);
            }
        }

        sc.close();
    }
}