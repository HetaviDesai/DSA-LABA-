
class SinglyCircular {
    class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    Node head;
    int size = 0;

    // Add student at a specific position
    void insert(String name, int position) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else if (position <= 1) {
            Node last = head;

            while (last.next != head) {
                last = last.next;
            }

            newNode.next = head;
            last.next = newNode;
            head = newNode;
        } else {
            Node temp = head;

            for (int i = 1; i < position - 1 && temp.next != head; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }

        size++;
        display();
    }

    // Remove student by value
    void remove(String name) {
        if (head == null) {
            System.out.println("Circle is empty.");
            return;
        }

        Node current = head;
        Node previous = null;

        do {
            if (current.name.equals(name)) {

                // Only one student
                if (current == head && current.next == head) {
                    head = null;
                }
                // Removing head
                else if (current == head) {
                    Node last = head;

                    while (last.next != head) {
                        last = last.next;
                    }

                    head = head.next;
                    last.next = head;
                }
                // Removing other node
                else {
                    previous.next = current.next;
                }

                size--;
                System.out.println("Removed: " + name);
                display();
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Student not found.");
    }

    // Display circle
    void display() {
        if (head == null) {
            System.out.println("Circle: Empty");
            return;
        }

        Node temp = head;

        System.out.print("Singly Circle: ");

        do {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to " + head.name + ")");
    }
}


// Doubly Circular Linked List
class DoublyCircular {
    class Node {
        String name;
        Node next;
        Node prev;

        Node(String name) {
            this.name = name;
        }
    }

    Node head;
    int size = 0;

    // Add student at a specific position
    void insert(String name, int position) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else if (position <= 1) {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;

            head = newNode;
        } else {
            Node temp = head;

            for (int i = 1; i < position - 1 && temp.next != head; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            newNode.prev = temp;

            temp.next.prev = newNode;
            temp.next = newNode;
        }

        size++;
        display();
    }

    // Remove student by value
    void remove(String name) {
        if (head == null) {
            System.out.println("Circle is empty.");
            return;
        }

        Node current = head;

        do {
            if (current.name.equals(name)) {

                // Only one student
                if (current.next == current) {
                    head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                    if (current == head) {
                        head = current.next;
                    }
                }

                size--;
                System.out.println("Removed: " + name);
                display();
                return;
            }

            current = current.next;

        } while (current != head);

        System.out.println("Student not found.");
    }

    // Display circle
    void display() {
        if (head == null) {
            System.out.println("Circle: Empty");
            return;
        }

        Node temp = head;

        System.out.print("Doubly Circle: ");

        do {
            System.out.print(temp.name + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to " + head.name + ")");
    }
}


// Main Class
public class prob5_2 {
    public static void main(String[] args) {

        System.out.println("=== SINGLY CIRCULAR LINKED LIST ===");

        SinglyCircular s = new SinglyCircular();

        s.insert("A", 1);
        s.insert("B", 2);
        s.insert("C", 3);
        s.insert("D", 2);

        s.remove("B");
        s.remove("A");

        s.display();


        System.out.println("\n=== DOUBLY CIRCULAR LINKED LIST ===");

        DoublyCircular d = new DoublyCircular();

        d.insert("A", 1);
        d.insert("B", 2);
        d.insert("C", 3);
        d.insert("D", 2);

        d.remove("B");
        d.remove("A");

        d.display();
    }
}