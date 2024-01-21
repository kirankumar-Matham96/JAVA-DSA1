package PriorityQueues;

import java.util.ArrayList;

public class LongestPathLeafToRoot {
    static int longestPath = 0;
    static ArrayList<Integer> longestPathNodes = new ArrayList<>();

    static void longestPathUtil(Node root, ArrayList<Integer> currentPath) {
        if (root == null) {
            return;
        }

        currentPath.add(root.data);

        // If leaf node, update longest path and nodes if necessary
        if (root.left == null && root.right == null) {
            if (currentPath.size() > longestPath) {
                longestPath = currentPath.size();
                longestPathNodes = new ArrayList<>(currentPath);
            }
        }

        // Recursively explore left and right subtrees
//        longestPathUtil(root.left, currentPath);
//        longestPathUtil(root.right, currentPath);
        if (root.left == null && root.right == null) {
            longestPathNodes.add(root.data); // Add to longest path before backtracking
        }
        // Backtrack: Remove the current node from the path
        currentPath.remove(currentPath.size() - 1);
    }

    static ArrayList<Integer> longestPathLeafToRoot(Node root) {
        longestPathUtil(root, new ArrayList<>());
        return longestPathNodes;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        Node root = new Node(1);
        // ... (add more nodes)

        ArrayList<Integer> longestPath = longestPathLeafToRoot(root);
        System.out.println("Longest path from leaf to root: " + longestPath);
    }
}
