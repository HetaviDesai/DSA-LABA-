import java.util.Scanner;

public class DoubleHashingStudentIDs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int TABLE_SIZE = 10;
        int[] table = new int[TABLE_SIZE];

        // -1 means the slot is empty
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = -1;
        }

        System.out.print("Enter number of student IDs: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();

            // First hash function: determines initial slot
            int index = id % TABLE_SIZE;

            // Second hash function: determines jump size
            int jump = 7 - (id % 7);

            int originalIndex = index;
            boolean inserted = false;

            while (table[index] != -1) {

                // Move according to the second hash function
                index = (index + jump) % TABLE_SIZE;

                // If we return to the starting position,
                // the table has no suitable slot for this ID
                if (index == originalIndex) {
                    break;
                }
            }

            if (table[index] == -1) {
                table[index] = id;
                inserted = true;
            }

            if (inserted) {
                System.out.println("Student ID " + id
                        + " stored in slot " + index);
            } else {
                System.out.println("No slot available for student ID "
                        + id);
            }
        }

        // Display final table
        System.out.println("\nFinal Hash Table:");

        for (int i = 0; i < TABLE_SIZE; i++) {

            if (table[i] == -1) {
                System.out.println("Slot " + i + ": Empty");
            } else {
                System.out.println("Slot " + i + ": " + table[i]);
            }
        }

        sc.close();
    }
}