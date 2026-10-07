import java.util.Scanner;

public class TokenQueue {

    static class CircularQueue {
        int[] queue;
        int front = 0;
        int rear = 0;
        int size = 0;
        int capacity;

        CircularQueue(int n) {
            capacity = n;
            queue = new int[n];
        }

        // Join operation
        void join(int token) {
            if (size == capacity) {
                System.out.println("Error: Queue is full");
                return;
            }

            queue[rear] = token;
            rear = (rear + 1) % capacity;
            size++;

            System.out.println("Front token: " + queue[front]);
        }

        // Serve operation
        void serve() {
            if (size == 0) {
                System.out.println("Error: Queue is empty");
                return;
            }

            front = (front + 1) % capacity;
            size--;

            if (size > 0) {
                System.out.println("Front token: " + queue[front]);
            } else {
                System.out.println("Front token: Empty");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int operations = sc.nextInt();

        CircularQueue q = new CircularQueue(n);

        for (int i = 0; i < operations; i++) {

            String operation = sc.next();

            if (operation.equalsIgnoreCase("join")) {
                int token = sc.nextInt();
                q.join(token);

            } else if (operation.equalsIgnoreCase("serve")) {
                q.serve();

            } else {
                System.out.println("Error: Invalid operation");
            }
        }

        sc.close();
    }
}
