
import java.util.Scanner;

class TrayStack {
    int[] stack;
    int top;
    int capacity;

    TrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Place a tray (Push)
    void push(int tray) {
        if (top == capacity - 1) {
            System.out.println("Error: Stack is full. Cannot place tray " + tray);
            return;
        }

        top++;
        stack[top] = tray;

        System.out.println("Placed tray: " + tray);
        peek();
    }

    // Take a tray (Pop)
    void pop() {
        if (top == -1) {
            System.out.println("Error: Stack is empty. Cannot take tray.");
            return;
        }

        int tray = stack[top];
        top--;

        System.out.println("Taken tray: " + tray);
        peek();
    }

    // Display top tray
    void peek() {
        if (top == -1) {
            System.out.println("Top tray: None (Stack is empty)");
        } else {
            System.out.println("Top tray: " + stack[top]);
        }
    }
}

public class prob6_1 {
    public static void main(String[] args) {

        TrayStack s = new TrayStack(3);

        // Place trays
        s.push(101);
        s.push(102);
        s.push(103);

        // Stack is full
        s.push(104);

        // Take trays
        s.pop();
        s.pop();
        s.pop();

        // Stack is empty
        s.pop();
    }
}