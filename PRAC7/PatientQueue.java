import java.util.Scanner;

public class PatientQueue {

    static class Node {
        String patient;
        Node next;

        Node(String patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    // Add a patient at the rear
    static void arrive(String patient) {
        Node newNode = new Node(patient);

        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        printFront();
    }

    // Remove a patient from the front
    static void attend() {
        if (front == null) {
            System.out.println("Error: Ward is empty");
            return;
        }

        front = front.next;

        if (front == null) {
            rear = null;
        }

        printFront();
    }

    // Print current front patient
    static void printFront() {
        if (front == null) {
            System.out.println("Front patient: Empty");
        } else {
            System.out.println("Front patient: " + front.patient);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            if (operation.equalsIgnoreCase("arrive")) {
                String patient = sc.next();
                arrive(patient);
            } 
            else if (operation.equalsIgnoreCase("attend")) {
                attend();
            } 
            else {
                System.out.println("Error: Invalid operation");
            }
        }

        sc.close();
    }
}
