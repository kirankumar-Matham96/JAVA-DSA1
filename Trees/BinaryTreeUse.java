package Trees;

import java.util.Scanner;

public class BinaryTreeUse {
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

        printTreeDetailed(takeTreeInput("Enter the root data"));

    }
}
