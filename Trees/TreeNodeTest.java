package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTest {

    public static void printTree(TreeNode<Integer> root) {
        if(root == null){
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode<Integer> front = queue.poll();

            if(!front.children.isEmpty()){
                System.out.print("node value: "+front.data+" => ");
                for(int i = 0; i<front.children.size(); i++ ){
                    queue.add(front.children.get(i));
                    System.out.print(front.children.get(i).data+" ");
                }
                System.out.println();
            }else{
                System.out.print("node value: "+front.data+" => ");
                for(int i = 0; i<front.children.size(); i++ ){
//                    queue.add(front.children.get(i));
                    System.out.print(front.children.get(i).data+" ");
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        printTree(root);
    }
}
