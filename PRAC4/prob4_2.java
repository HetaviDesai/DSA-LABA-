
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

    // Insert a patient token
    void enqueue(int token) {
        Node newNode = new Node(token);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Display queue from front to back
    void forwardTraversal() {
        Node temp = front;

        System.out.print("Queue (Front to Back): ");

        while (temp != null) {
            System.out.print(temp.token + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Delete a patient token by value
    void deleteByValue(int token) {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        // If the front node contains the token
        if (front.token == token) {
            front = front.next;

            if (front == null) {
                rear = null;
            }

            System.out.println("Token " + token + " deleted.");
            return;
        }

        Node temp = front;

        // Find the node before the node to delete
        while (temp.next != null && temp.next.token != token) {
            temp = temp.next;
        }

        // Token not found
        if (temp.next == null) {
            System.out.println("Token " + token + " not found.");
            return;
        }

        // Delete the node
        if (temp.next == rear) {
            rear = temp;
        }

        temp.next = temp.next.next;

        System.out.println("Token " + token + " deleted.");
    }

    // Reverse printing using recursion
    void reversePrint(Node node) {
        if (node == null) {
            return;
        }

        reversePrint(node.next);

        System.out.print(node.token + " ");
    }

    void displayReverse() {
        System.out.print("Queue (Last to First): ");
        reversePrint(front);
        System.out.println();
    }
}

public class prob4_2 {
    public static void main(String[] args) {

        Queue q = new Queue();

        // Tokens from Problem 4.1a
        q.enqueue(101);
        q.enqueue(102);
        q.enqueue(103);
        q.enqueue(104);
        q.enqueue(105);

        // Display original queue
        q.forwardTraversal();

        // Delete a token
        q.deleteByValue(103);

        // Display queue after deletion
        q.forwardTraversal();

        // Reverse printing
        q.displayReverse();

        // Forward traversal again
        q.forwardTraversal();
    }
}