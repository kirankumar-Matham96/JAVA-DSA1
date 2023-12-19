package Trees;

import com.sun.source.tree.BinaryTree;

import javax.naming.BinaryRefAddr;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {

    public static BalanceTreeReturn isBalancedImproved(BinaryTreeNode<Integer> root) {
        if(root == null){
            int height = 0;
            boolean isBal = true;
            BalanceTreeReturn ans = new BalanceTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalanceTreeReturn leftOutput = isBalancedImproved(root.left);
        BalanceTreeReturn rightOutput = isBalancedImproved(root.right);
        boolean isBal = true;
        int height = 1+ Math.max(leftOutput.height,rightOutput.height);
        if(Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }

        if(!leftOutput.isBalanced || !rightOutput.isBalanced){
            isBal = false;
        }

        BalanceTreeReturn ans = new BalanceTreeReturn();

        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if(root == null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();

            BinaryTreeNode<Integer> temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return null;
        }

        if(removeLeafNodes(root.left) == null){
            root.left = null;
        }
        if(removeLeafNodes(root.right) == null){
            root.right = null;
        }

        return root;
    }

    public static boolean isNumberPresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }

        if(root.data == x){
            return true;
        }

        boolean leftTree = isNumberPresent(root.left, x);
        boolean rightTree = isNumberPresent(root.right, x);
        return leftTree || rightTree;
    }
    public static BinaryTreeNode<Integer> replaceDataWithDepthValue(BinaryTreeNode<Integer> root) {
        if(root == null){
            return null;
        }

        int depthCount = 0;
        Queue<BinaryTreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);

        while(!pendingQueue.isEmpty()){
            int treeLevel = pendingQueue.size();
            for (int i = 0; i < treeLevel; i++) {
                BinaryTreeNode<Integer> front = pendingQueue.poll();
                front.data = depthCount;

                if(front.left != null){
                    pendingQueue.add(front.left);
                }
                if(front.right != null){
                    pendingQueue.add(front.right);
                }
            }
            depthCount++;
        }

        return root;
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if(root == null){
            return;
        }

        if(k == 0){
            System.out.println("Depth data: "+root.data);
            return;
        }

        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);

    }
    public static int numberOfLeaves(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }

        return numberOfLeaves(root.left)+numberOfLeaves(root.right);

    }
    public static int heightOfTheBinaryTree(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }

        int heightLeft = heightOfTheBinaryTree(root.left);
        int heightRight = heightOfTheBinaryTree(root.right);

        return Math.max(heightLeft, heightRight) + 1;
    }
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return -1;
        }
        int count = 0;
        Queue<BinaryTreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);

        while(!pendingQueue.isEmpty()){
            BinaryTreeNode<Integer> front = pendingQueue.poll();
            if(front.data > x){
                count++;
            }

            if(front.left != null){
                pendingQueue.add(front.left);
            }
            if(front.right != null){
                pendingQueue.add(front.right);
            }
        }
        return count;
    }

    public static int largestNode(BinaryTreeNode<Integer> root) {
        if(root == null){
            return -1;
        }

        int rootData = root.data;
        int leftLargest = largestNode(root.left);
        int rightLargest = largestNode(root.right);

        return Math.max(Math.max(rootData, leftLargest),rightLargest);
    }

    public static int sumOfNodes(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }

        Queue<BinaryTreeNode<Integer>> pendingQueue = new LinkedList<>();
        int sum = 0;
        pendingQueue.add(root);
        while(!pendingQueue.isEmpty()){
            BinaryTreeNode<Integer> front = pendingQueue.poll();
        sum += front.data;
            if(front.left != null){
//                sum += front.left.data;
                pendingQueue.add(front.left);
            }
            if(front.right != null){
//                sum += front.right.data;
                pendingQueue.add(front.right);
            }
        }
        return sum;
    }


    public static void printTreeLevelWise(BinaryTreeNode<Integer> root) {
        if(root == null){
            System.out.println(" ");
        }

        Queue<BinaryTreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);

        while(!pendingQueue.isEmpty()){
            BinaryTreeNode<Integer> front = pendingQueue.poll();
            int left,right;
            if(front.left != null){
                left = front.left.data;
                pendingQueue.add(front.left);
            }else{
                left = -1;
            }
            if (front.right != null) {
                right = front.right.data;
                pendingQueue.add(front.right);
            }else{
                right = -1;
            }
            System.out.println(front.data+":L:"+left+",R:"+right);
        }
    }

    public static BinaryTreeNode<Integer> takeTreeInputLevelVise(String message) {
        Queue<BinaryTreeNode<Integer>> pendingQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println(message);
        int rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        pendingQueue.add(root);


        while(!pendingQueue.isEmpty()){
            BinaryTreeNode<Integer> front = pendingQueue.poll();
            System.out.println("Enter left data for node "+ front.data);
            int left = sc.nextInt();
            if(left != -1){
                BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(left);
                front.left = rootLeft;
                pendingQueue.add(rootLeft);

            }

            System.out.println("Enter right data for node "+ front.data);
            int right = sc.nextInt();
            if(right != -1){
                BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(right);
                front.right = rootRight;
                pendingQueue.add(rootRight);

            }
        }
        return root;
    }

    public static int numberOfNodes(BinaryTreeNode<Integer> root) {
        if(root == null){
            return 0;
        }

        int leftNodesCount = numberOfNodes(root.left);
        int rightNodesCount = numberOfNodes(root.right);

        return leftNodesCount + rightNodesCount + 1;
    }
    public static BinaryTreeNode<Integer> takeTreeInput(String message) {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if(rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput("Enter the rootLeft Data "+ root.data +" => ");
        BinaryTreeNode<Integer> rightChild = takeTreeInput("Enter the rootRight Data "+ root.data +" => ");
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        System.out.println();
        System.out.print(root.data + ": ");

        if(root.left != null){
            System.out.print("L"+ root.left.data+" ");
        }
        if(root.right != null){
            System.out.print("R"+root.right.data+" ");
        }

        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }
    public static void printTree(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
//        if(root.left != null){
//            printTree(root.left);
//        }
//        if(root.right != null){
//            printTree(root.right);
//        }
    }

    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> rootsLeft = new BinaryTreeNode<>(2);
//        BinaryTreeNode<Integer> rootsRight = new BinaryTreeNode<>(3);
//        BinaryTreeNode<Integer> rootsLeftsRight = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> rootsRightsLeft = new BinaryTreeNode<>(5);
//
//        root.left = rootsLeft;
//        root.right = rootsRight;
//        rootsLeft.right = rootsLeftsRight;
//        rootsRight.left = rootsRightsLeft;
//        printTree(root);
//
//        printTreeDetailed(root);

//        BinaryTreeNode<Integer> root = takeTreeInput("Enter the root data");
        BinaryTreeNode<Integer> root = takeTreeInputLevelVise("Enter the root");
        printTreeDetailed(root);
        System.out.println("Printing level wise: ");
        printTreeLevelWise(root);
        System.out.println();
        System.out.println("nodes => "+numberOfNodes(root));
        System.out.println("sum of nodes => "+sumOfNodes(root));

        System.out.println("Largest value => "+largestNode(root));
        System.out.println(countNodesGreaterThanX(root, 2));

        System.out.println("Height of the Binary tree => "+heightOfTheBinaryTree(root));

        System.out.println("number of leaves in a tree => "+numberOfLeaves(root));

        printAtDepthK(root, 1);
        System.out.println("After replacing data with depth values ===> ");
//        BinaryTreeNode<Integer> newRoot = replaceDataWithDepthValue(root);


//        System.out.println("\n Is the number present in the tree?");
//        System.out.println("is 2 present: ===> "+isNumberPresent(root, 2));
//        System.out.println("is 0 present: ===> "+isNumberPresent(root, 0));
//        System.out.println("is 1 present: ===> "+isNumberPresent(root, 1));
//        System.out.println("is 5 present: ===> "+isNumberPresent(root, 5));
//        System.out.println("is 3 present: ===> "+isNumberPresent(root, 3));
//        System.out.println("is 4 present: ===> "+isNumberPresent(root, 4));
//
//        System.out.println("printing new root");
//        printTreeLevelWise(newRoot);


        System.out.println();

//        BinaryTreeNode<Integer> newRoot1 = removeLeafNodes(root);
//        printTreeLevelWise(newRoot1);

        System.out.println("Printing mirror tree: ===> ");
        mirrorBinaryTree(root);
        printTreeLevelWise(root);

        System.out.println("Is balanced => "+isBalanced(root));
    }
}
