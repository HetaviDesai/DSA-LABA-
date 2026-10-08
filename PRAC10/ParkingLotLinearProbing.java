import java.util.Scanner;

public class ParkingLotLinearProbing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] slots = new String[10];

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter vehicle registration number: ");
            String registration = sc.next();

            int slot = Character.getNumericValue(
                    registration.charAt(registration.length() - 1)
            );

            int startSlot = slot;
            boolean parked = false;

            while (slots[slot] != null) {
                slot = (slot + 1) % 10;

                if (slot == startSlot) {
                    break;
                }
            }

            if (slots[slot] == null) {
                slots[slot] = registration;
                parked = true;
            }

            if (parked) {
                System.out.println("Vehicle " + registration
                        + " parked in slot " + slot);
            } else {
                System.out.println("Parking lot is full. Vehicle "
                        + registration + " cannot be parked.");
            }
        }

        System.out.println("\nFinal Parking Lot State:");

        for (int i = 0; i < 10; i++) {
            if (slots[i] == null) {
                System.out.println("Slot " + i + ": Empty");
            } else {
                System.out.println("Slot " + i + ": " + slots[i]);
            }
        }

        sc.close();
    }
}