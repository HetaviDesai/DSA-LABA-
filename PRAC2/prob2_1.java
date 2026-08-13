 import java.util.Scanner;
public class prob2_1 {


    // Iterative Linear Search
    public static int iterativeSearch(String[] plates, String target) {
        for (int i = 0; i < plates.length; i++) {
            if (plates[i].equals(target)) {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }

    // Recursive Linear Search
    public static int recursiveSearch(String[] plates, String target, int index) {
        if (index >= plates.length) {
            return -1; // Not found
        }

        if (plates[index].equals(target)) {
            return index; // Found
        }

        return recursiveSearch(plates, target, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of license plates: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        String[] plates = new String[n];

        System.out.println("Enter the license plates:");
        for (int i = 0; i < n; i++) {
            plates[i] = sc.nextLine();
        }

        System.out.print("Enter target license plate: ");
        String target = sc.nextLine();

        int iterativeResult = iterativeSearch(plates, target);
        int recursiveResult = recursiveSearch(plates, target, 0);

        if (iterativeResult != -1) {
            System.out.println("Iterative Search: Plate found at position " + (iterativeResult + 1));
        } else {
            System.out.println("Iterative Search: Plate not found.");
        }

        if (recursiveResult != -1) {
            System.out.println("Recursive Search: Plate found at position " + (recursiveResult + 1));
        } else {
            System.out.println("Recursive Search: Plate not found.");
        }

        sc.close();
    }
}

