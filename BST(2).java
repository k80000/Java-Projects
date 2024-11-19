//Name: Katie Decker
//Class: CS 5040 Section 01
//Term: Fall 2024
//Instructor: Umama Tasnim
//Assignment: 6

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class BST {
//represents each node in the bst
    private class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root; //root of the bst

    public void insert(int value) {
        root = insertFunction(root, value);
    } //inserts a node into the bst

    private Node insertFunction(Node root, int value) { //recursive function to insert a node into the bst
        if (root == null) { //base case
            root = new Node(value);
            return root;
        }
        if (value < root.value) { //recurs down left or right subtree
            root.left = insertFunction(root.left, value);
        } else if (value > root.value) {
            root.right = insertFunction(root.right, value);
        }
        return root; //returns root node
    }

    public void printTree() {
        printTreeFunction(root, "", true);
    } //prints structure of bst

    private void printTreeFunction(Node node, String indent, boolean isRight) { //recursive function to print bst
        if (node != null) { //base case
            printTreeFunction(node.right, indent + (isRight ? "        " : " |      "), false);
            System.out.print(indent);
            if (isRight) {
                System.out.print(" /-- ");
            } else {
            System.out.print(" \\-- ");
        }
        System.out.println(node.value);

        printTreeFunction(node.left, indent + (isRight ? "        " : " |      "), true);
    }
}

public boolean search(int value) {
    return searchFunction(root, value);
} //searches for a node in the bst

private boolean searchFunction(Node node, int value) { //recursive function to search for a node in the bst
    if (node == null) {
        return false; //base case: value not found
    }
    if (node.value == value) {
        return true; //base case: value found
    }
    return value < node.value ? searchFunction(node.left, value) : searchFunction(node.right, value); //recurs down left or right subtree
}

public void delete(int value) {
        root = deleteFunction(root, value);
} //deletes a node from the bst

private Node deleteFunction(Node root, int value) { //recursive function to delete a node from the bst
        if (root == null) return root;

        if (value < root.value) { //finds node to delete by moving down the left or right subtree
            root.left = deleteFunction(root.left, value);
        } else if (value > root.value) {
            root.right = deleteFunction(root.right, value);
        } else {
            //node is found: handle cases with 0, 1, or 2 children nodes
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            //replace node
            root.value = root.right.value;
            root.right = deleteFunction(root.right, root.value);
        }
        return root;
}


public void inorderTraversal() { //inorder traversal of the bst
        inorderFunction(root);
        System.out.println();
}

private void inorderFunction(Node root) { //recursive function to find inorder traversal of bst
        if (root != null) {
            inorderFunction(root.left);
            System.out.print(root.value + " ");
            inorderFunction(root.right);
        }
}

public void preorderTraversal() { //preorder traversal of the bst
        preorderFunction(root);
        System.out.println();
}

private void preorderFunction(Node root) { //recursive function to find preorder traversal of bst
        if (root != null) {
            System.out.print(root.value + " ");
            preorderFunction(root.left);
            preorderFunction(root.right);
        }
}

public void postorderTraversal() { //postorder traversal of the bst
        postorderFunction(root);
        System.out.println();
}

private void postorderFunction(Node root) { //recursive function to find the postorder traversal of bst
        if (root != null) {
            postorderFunction(root.left);
            postorderFunction(root.right);
            System.out.print(root.value + " ");
        }
}

public List<Integer> levelOrderTraversal() { //level order traversal of the bst
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value);

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
}

public int height() {
        return heightFunction(root);
} //height of the bst

private int heightFunction(Node root) { //recursive function to find height of bst
        if (root == null) return 0;
        return 1 + Math.max(heightFunction(root.left), heightFunction(root.right));
}

public int minValue() { //min value of the bst
        return minValue(root);
}

private int minValue(Node root) { //recursive function to find min value
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
}

public int maxValue() { //max value of the bst
        return maxValue(root);
}

private int maxValue(Node root) { //recursive function to find max value
        int maxValue = root.value;
        while (root.right != null) {
            maxValue = root.right.value;
            root = root.right;
        }
        return maxValue;
}

public boolean isBalanced() { //checks if bst is balanced
        return isBalancedFunction(root);
}

private boolean isBalancedFunction(Node root) { //recursive function to check if bst is balanced
        if (root == null) return true;

        int leftHeight = heightFunction(root.left);
        int rightHeight = heightFunction(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalancedFunction(root.left) && isBalancedFunction(root.right);
}

public void printPaths() { //prints all root-to-leaf paths in bst
        List<Integer> path = new ArrayList<>();
        printPathsFunction(root, path);
}

private void printPathsFunction(Node root, List<Integer> path) { //recursive function to print all root-to-leaf paths in bst
        if (root == null) return;

        path.add(root.value);

        if (root.left == null && root.right == null) {
            System.out.println(path);
        } else {
            printPathsFunction(root.left, new ArrayList<>(path));
            printPathsFunction(root.right, new ArrayList<>(path));
        }
}


public static void main(String[] args) { //main function to print information out to user
        BST bst = new BST();


        int[] values = {15, 10, 20, 8, 12, 17, 25};
        for (int value : values) {
            bst.insert(value);
        }



        System.out.println("BST Structure: ");
        bst.printTree();

        System.out.println("Inorder Traversal: ");
        bst.inorderTraversal();

        System.out.println("Preorder Traversal: ");
        bst.preorderTraversal();

        System.out.println("Postorder Traversal: ");
        bst.postorderTraversal();

        System.out.println("Level Order Traversal: " + bst.levelOrderTraversal());


        System.out.println("Searching for 10: " + bst.search(10));
        System.out.println("Searching for 99: " + bst.search(99));


        bst.delete(8);
        bst.delete(10);
        bst.delete(15);
        System.out.println("Inorder Traversal after deletions: ");
        bst.inorderTraversal();


        System.out.println("Tree Height: " + bst.height());
        System.out.println("Min Value: " + bst.minValue());
        System.out.println("Max Value: " + bst.maxValue());
        System.out.println("Is tree balanced?: " + bst.isBalanced());


        System.out.println("Root-to-leaf paths: ");
        bst.printPaths();
    }
}


//Sources:
//https://stackoverflow.com/questions/13424656/preorder-printing-binary-tree-with-indentations
//I used this site for guidance on how to visualize the BST in the program.