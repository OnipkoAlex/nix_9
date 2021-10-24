package ua.com.alevel.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryTree {

    public static class Node {
        private final int value;
        private Node left;
        private Node right;

        Node(int x) {
            this.value = x;
            left = null;
            right = null;
        }
    }

    public static int deepest(Node root) {
        if (root != null)
            return 1 + Math.max(deepest(root.left), deepest(root.right));
        else
            return 0;
    }

    public static void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu = "";
        Node rootNode;
        do {
            try {
                System.out.println("Enter root value: ");
                rootNode = new Node(Integer.parseInt(reader.readLine()));
                break;
            }catch (NumberFormatException ex) {
                System.out.println("Invalid input. Try again.");
            }
        }while(true);
        do {
            System.out.println("1. Insert new node.");
            System.out.println("2. Find max deep.");
            System.out.println("3. Exit to main menu.");
            menu = reader.readLine();
            switch (menu) {
                case "1": {
                    do {
                        try {
                            System.out.print("Enter node value: ");
                            insert(rootNode, Integer.parseInt(reader.readLine()));
                            System.out.println();
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid input. Try again.");
                        }
                    } while (true);
                    break;
                }
                case "2": {
                    System.out.println("Max deep: " + deepest(rootNode));
                    break;
                }
            }
        } while (!menu.equals("3"));
    }

    public static void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" -> Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println(" -> Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
            }
        }
    }
}
