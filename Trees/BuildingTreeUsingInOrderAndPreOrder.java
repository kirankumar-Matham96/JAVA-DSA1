package Trees;

import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildingTreeUsingInOrderAndPreOrder {

    public static BinaryTreeNode<Integer> buildTreeUsingPostInOrderHelper(int[] inOrder, int[] preOrder, int startIndexPre, int endIndexPre, int startIndexIn, int endIndexIn) {
// find the steps...

        //        if(startIndexPre > endIndexPre){
//            return null;
//        }
//
//        int rootData = preOrder[startIndexPre];
//
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
//
//        int rootIndex = -1;
//
//        for (int i = startIndexIn; i <= endIndexIn; i++) {
//            if(inOrder[i] == rootData){
//                rootIndex = i;
//                break;
//            }
//        }
//
//        int leftStartIndexPre = startIndexPre + 1;
//        int leftStartIndexIn = startIndexIn;
//        int leftEndIndexIn = rootIndex - 1;
//
//        int rightStartIndexIn = rootIndex + 1;
//        int rightEndIndexPre = endIndexPre;
//        int rightEndIndexIn = endIndexIn;
//
//        int leftSubTreeLength = leftEndIndexIn - leftStartIndexIn + 1;
//
//        int leftEndIndexPre = leftStartIndexPre + leftSubTreeLength - 1;
//        int rightStartIndexPre = leftEndIndexPre + 1;
//
//        root.left = buildTreeUsingPreInOrderHelper(inOrder, preOrder, leftStartIndexPre, leftEndIndexPre, leftStartIndexIn, leftEndIndexIn);
//        root.right = buildTreeUsingPreInOrderHelper(inOrder, preOrder, rightStartIndexPre, rightEndIndexPre, rightStartIndexIn, rightEndIndexIn);
//
//        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeUsingPreInOrderHelper(int[] inOrder, int[] preOrder, int startIndexPre, int endIndexPre, int startIndexIn, int endIndexIn) {
        if(startIndexPre > endIndexPre){
            return null;
        }

        int rootData = preOrder[startIndexPre];

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;

        for (int i = startIndexIn; i <= endIndexIn; i++) {
            if(inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        int leftStartIndexPre = startIndexPre + 1;
        int leftStartIndexIn = startIndexIn;
        int leftEndIndexIn = rootIndex - 1;

        int rightStartIndexIn = rootIndex + 1;
        int rightEndIndexPre = endIndexPre;
        int rightEndIndexIn = endIndexIn;

        int leftSubTreeLength = leftEndIndexIn - leftStartIndexIn + 1;

        int leftEndIndexPre = leftStartIndexPre + leftSubTreeLength - 1;
        int rightStartIndexPre = leftEndIndexPre + 1;

        root.left = buildTreeUsingPreInOrderHelper(inOrder, preOrder, leftStartIndexPre, leftEndIndexPre, leftStartIndexIn, leftEndIndexIn);
        root.right = buildTreeUsingPreInOrderHelper(inOrder, preOrder, rightStartIndexPre, rightEndIndexPre, rightStartIndexIn, rightEndIndexIn);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeUsingPreInOrder(int[] inOrder, int[] preOrder) {
        BinaryTreeNode<Integer> root = buildTreeUsingPreInOrderHelper(inOrder, preOrder, 0, preOrder.length-1, 0, inOrder.length-1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeUsingPostInOrder(int[] inOrder, int[] postOrder) {
        BinaryTreeNode<Integer> root = buildTreeUsingPostInOrderHelper(inOrder, postOrder, 0, postOrder.length-1, 0, inOrder.length-1);
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
        int[] inOrder = {4,2,5,1,3};
        int[] preOrder = {1,2,4,5,3};

        BinaryTreeNode<Integer> root = buildTreeUsingPreInOrder(inOrder, preOrder);

        printTreeLevelWise(root);
    }
}
