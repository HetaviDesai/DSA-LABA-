
class Node {
    String page;
    Node next;

    Node(String page) {
        this.page = page;
        this.next = null;
    }
}

class BrowserHistory {
    Node top;

    // Visit a new page
    void visit(String page) {
        Node newNode = new Node(page);

        newNode.next = top;
        top = newNode;

        System.out.println("Visited: " + page);
        displayCurrentPage();
    }

    // Go back to previous page
    void back() {
        if (top == null || top.next == null) {
            System.out.println("Error: No previous page available.");
            displayCurrentPage();
            return;
        }

        System.out.println("Back from: " + top.page);

        top = top.next;

        displayCurrentPage();
    }

    // Display current page
    void displayCurrentPage() {
        if (top == null) {
            System.out.println("Current page: No page");
        } else {
            System.out.println("Current page: " + top.page);
        }
    }
}

public class prob6_2 {
    public static void main(String[] args) {

        BrowserHistory browser = new BrowserHistory();

        // Initial page
        browser.visit("Home");

        // Visit pages
        browser.visit("Google");
        browser.visit("YouTube");
        browser.visit("Wikipedia");

        // Go back
        browser.back();
        browser.back();
        browser.back();

        // Try back on the first page
        browser.back();
    }
}