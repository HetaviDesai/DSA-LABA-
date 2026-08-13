 import java.util.Scanner;
public class prob2_2 {
    // Iterative Binary Search
    public static int iterativeBinarySearch(int[] books, int target) {
        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (books[mid] == target) {
                return mid; // Found
            } else if (books[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Not found
    }

    // Recursive Binary Search
    public static int recursiveBinarySearch(int[] books, int left, int right, int target) {
        if (left > right) {
            return -1; // Not found
        }

        int mid = left + (right - left) / 2;

        if (books[mid] == target) {
            return mid;
        } else if (books[mid] < target) {
            return recursiveBinarySearch(books, mid + 1, right, target);
        } else {
            return recursiveBinarySearch(books, left, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of book codes: ");
        int n = sc.nextInt();

        int[] books = new int[n];

        System.out.println("Enter the sorted book codes:");
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
        }

        System.out.print("Enter target book code: ");
        int target = sc.nextInt();

        int iterativeResult = iterativeBinarySearch(books, target);
        int recursiveResult = recursiveBinarySearch(books, 0, n - 1, target);

        if (iterativeResult != -1) {
            System.out.println("Iterative Binary Search: Book code found at position " + (iterativeResult + 1));
        } else {
            System.out.println("Iterative Binary Search: Book code not found.");
        }

        if (recursiveResult != -1) {
            System.out.println("Recursive Binary Search: Book code found at position " + (recursiveResult + 1));
        } else {
            System.out.println("Recursive Binary Search: Book code not found.");
        }

        sc.close();
    }
}

