
class Node {
    int token;
    Node next;

    Node(int token) {
        this.token = token;
        this.next = null;
    }
}

class Queue {
    Node front;
    Node rear;

    // Insert at front (Critical patient)
    void insertFront(int token) {
        Node newNode = new Node(token);

        newNode.next = front;
        front = newNode;

        if (rear == null) {
            rear = newNode;
        }

        display();
    }

    // Insert at end (Routine patient)
    void insertEnd(int token) {
        Node newNode = new Node(token);

        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        display();
    }

    // Insert at specific position (Priority patient)
    void insertAtPosition(int token, int position) {
        Node newNode = new Node(token);

        // Position 1 means insert at front
        if (position <= 1) {
            insertFront(token);
            return;
        }

        if (front == null) {
            System.out.println("Queue is empty. Inserting at front.");
            insertFront(token);
            return;
        }

        Node temp = front;

        // Move to the node before the required position
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;

        // Update rear if inserted at the end
        if (newNode.next == null) {
            rear = newNode;
        }

        display();
    }

    // Display queue
    void display() {
        Node temp = front;

        System.out.print("Queue: ");

        while (temp != null) {
            System.out.print(temp.token + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}

public class prob4_1 {
    public static void main(String[] args) {

        Queue q = new Queue();

        // Routine patient added at end
        q.insertEnd(101);

        q.insertEnd(102);

        // Critical patient added at front
        q.insertFront(100);

        // Priority patient inserted at position 3
        q.insertAtPosition(105, 3);

        // Priority patient inserted at position 2
        q.insertAtPosition(110, 2);

        // Position greater than queue length
        q.insertAtPosition(120, 20);
    }
}