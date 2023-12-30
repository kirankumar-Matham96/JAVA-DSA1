package Trees;

import com.sun.source.tree.BinaryTree;

import javax.naming.BinaryRefAddr;

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    private static boolean isPresentHelper(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            return false;
        }

        if(root.data == x){
            return true;
        }

        if(x < root.data){
            // call on left side
            return isPresentHelper(root.left, x);
        }else{
            // call on right side
            return isPresentHelper(root.right, x);
        }
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> root) {
        if(root == null){
            return;
        }

        System.out.print(root.data + ": ");
        if(root.left != null){
            System.out.print("L "+root.left.data + ", ");
        }
        if(root.right != null){
            System.out.print("R " + root.right.data);
        }
        System.out.println();

        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }

    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x){
        if(root == null){
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }

        if(x >= root.data){
            root.right = insertHelper(root.right, x);
        }else{
            root.left = insertHelper(root.left, x);
        }

        return root;
    }

    private static int findMin(BinaryTreeNode<Integer> root){
        if (root == null){
            return Integer.MAX_VALUE;
        }

        int largestLeft = findMin(root.left);
        int largestRight = findMin(root.right);

        return Math.min(root.data, Math.min(largestLeft, largestRight));
    }

    private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
        if(root == null){
            return new BSTDeleteReturn(null, false);
        }

        if(x > root.data){
            BSTDeleteReturn outputRight = deleteDataHelper(root.right,x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }

        if(x < root.data){
            BSTDeleteReturn outputLeft = deleteDataHelper(root.left,x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }

        // 0 children
        if(root.right == null && root.left == null){
            return new BSTDeleteReturn(null, true);
        }

        // only left children
        if(root.right != null && root.left == null){
            return new BSTDeleteReturn(root.left, true);
        }

        // only right children
        if(root.right == null && root.left != null){
            return new BSTDeleteReturn(root.right, true);
        }

        // both children
        int rightMin = findMin(root.right);
        root.data = rightMin;
        BSTDeleteReturn outputRight = deleteDataHelper(root.right, rightMin);
        root.right = outputRight.root;
        return new BSTDeleteReturn(root,true);
    }



    public boolean isPresent(int x){
        return isPresentHelper(root, x);
    }

    public void insert(int x) {
        size++;
        root = insertHelper(root, x);
    }

    public boolean deleteData(int x){
        BSTDeleteReturn output = deleteDataHelper(root, x);
        root = output.root;
        if(output.deleted){
            size--;
        }
        return output.deleted;
    }

    public int size(){
        return size;
    }

    public void printTree(){
        printTreeHelper(root);
    }


}
