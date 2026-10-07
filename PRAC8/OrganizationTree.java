import java.util.*;

public class OrganizationTree {

    // Node of the binary tree
    static class Node {
        String name;
        Node left;
        Node right;

        Node(String name) {
            this.name = name;
        }
    }

    // Inorder: Left -> Root -> Right
    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.name + " ");
        inorder(root.right);
    }

    // Preorder: Root -> Left -> Right
    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.name + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left -> Right -> Root
    static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.name + " ");
    }

    // Level order: Level by level
    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print(current.name + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {

        /*
                 CEO
                /   \
             HR     IT
            /  \    / \
          A1   A2  B1  B2
        */

        Node root = new Node("CEO");

        root.left = new Node("HR");
        root.right = new Node("IT");

        root.left.left = new Node("A1");
        root.left.right = new Node("A2");

        root.right.left = new Node("B1");
        root.right.right = new Node("B2");

        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
        System.out.println();

        System.out.print("Level Order: ");
        levelOrder(root);
        System.out.println();
    }
}
