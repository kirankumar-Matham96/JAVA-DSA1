package Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import linkedList.Node;

public class BinarySearchTrees {

    public static ArrayList<Integer> nodeToRootPath(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return null;
        }

        if(root.data == x){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = nodeToRootPath(root.left, x);

        if(leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = nodeToRootPath(root.right, x);
        if(rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        return null;
    }

    public static Node<Integer> bstToLinkedList(BinaryTreeNode<Integer> root) {
        if(root == null){
            return null;
        }

        Node<Integer> leftList = bstToLinkedList(root.left);
        Node<Integer> rightList = bstToLinkedList(root.right);

        Node<Integer> head = new Node<>(root.data);

        if(leftList != null){
            Node<Integer> tail = leftList;
            while(tail.getNext() != null){
                tail = tail.getNext();
            }

            tail.setNext(head);
            head = tail;
        }

        if(rightList != null){
            head.setNext(rightList);
            rightList.setNext(head);
        }
        return leftList != null ? leftList : head;
    }

    public static boolean isBST3(BinaryTreeNode<Integer> root, int minRange, int maxRange) {
        if(root == null){
            return true;
        }
        if(root.data < minRange || root.data > maxRange){
            return false;
        }

        boolean isLeftWithInRange = isBST3(root.left, minRange, root.data-1);
        boolean isRightWithInRange = isBST3(root.right, root.data, maxRange);

        return isLeftWithInRange && isRightWithInRange;
    }
    public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root) {
        if(root == null){
            IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }

        IsBSTReturn leftAns = isBST2(root.left);
        IsBSTReturn rightAns = isBST2(root.right);

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));

        boolean isBST = true;

        if(leftAns.max >= root.data){
            isBST = false;
        }

        if(rightAns.min < root.data){
            isBST = false;
        }

        if(!leftAns.isBST){
            isBST = false;
        }

        if(!rightAns.isBST){
            isBST = false;
        }

        IsBSTReturn ans = new IsBSTReturn(min, max, isBST);
        return ans;
    }
    public static int maximum(BinaryTreeNode<Integer> root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int minimum(BinaryTreeNode<Integer> root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
    
    // not giving the correct output
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if(root == null){
            return false;
        }

        int leftMax = maximum(root.left);
        if(leftMax >= root.data){
            return false;
        }

        int rightMin = minimum(root.right);
        if(rightMin < root.data){
            return false;
        }

        boolean isLeftBST = isBST(root.left);
        boolean rightBST = isBST(root.right);

        return isLeftBST && rightBST;
    }

    // Not working as expected
    public static BinaryTreeNode<Integer> constructBSTFromASortedArray(int[] arr) {
        if(arr.length == 0){
            return null;
        }

        // find the middle element in the array
        int middleElementIndex = arr.length/2;
        System.out.println("middle index: "+middleElementIndex);

        // make it root
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[middleElementIndex]);


        // Now call the function recursively for left and right array
        int[] lefttArr = new int[middleElementIndex];

        for(int i = 0; i < middleElementIndex; i++){
            lefttArr[i] = arr[i];
        }
        BinaryTreeNode<Integer> leftNode = constructBSTFromASortedArray(lefttArr);

        int[] rightArr = new int[middleElementIndex];

        for(int i = 0; i < middleElementIndex; i++){
            rightArr[i] = arr[i];
        }
        BinaryTreeNode<Integer> rightNode = constructBSTFromASortedArray(rightArr);

        // connect the nodes with the root
        root.left = leftNode;
        root.right = rightNode;

         return root;

    }
    public static void printTheTreeNodeValuesBetweenTwoNumbers(BinaryTreeNode<Integer> root, int k1, int k2) {
        if(root == null){
            return;
        }
        if(root.data < k1){
//            System.out.println(root.data);
            printTheTreeNodeValuesBetweenTwoNumbers(root.right, k1,k2);
        }
        else if(root.data > k2){
//            System.out.println(root.data);
            printTheTreeNodeValuesBetweenTwoNumbers(root.left, k1,k2);
        }
        else{
            System.out.println(root.data);
            printTheTreeNodeValuesBetweenTwoNumbers(root.right, k1,k2);
            printTheTreeNodeValuesBetweenTwoNumbers(root.left, k1,k2);
        }


    }
    public static boolean searchNode(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return false;
        }

        if(root.data == x){
            return true;
        }

        if(x < root.data){
            return searchNode(root.left, x);
        }else{
            return searchNode(root.right, x);
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



    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputLevelVise("Enter the root");
//        int[] arr = {1,2,3,4,5,6,7,8};
//        BinaryTreeNode<Integer> root = constructBSTFromASortedArray(arr);
//        printTreeLevelWise(root);
//        System.out.println();
//        System.out.println(isBST(root));
//        System.out.println(searchNode(root, 2));
//        printTheTreeNodeValuesBetweenTwoNumbers(root, 2,5);
    }
}
