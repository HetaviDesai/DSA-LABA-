import java.util.Scanner;

public class BookBST {

    static class Node {
        int code;
        Node left, right;

        Node(int code) {
            this.code = code;
        }
    }

    // Insert a book code into the Binary Search Tree
    static Node insert(Node root, int code) {
        if (root == null) {
            return new Node(code);
        }

        if (code < root.code) {
            root.left = insert(root.left, code);
        } else if (code > root.code) {
            root.right = insert(root.right, code);
        }

        return root;
    }

    // Inorder traversal: Left -> Root -> Right
    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.code + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            int code = sc.nextInt();
            root = insert(root, code);
        }

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        sc.close();
    }
}
