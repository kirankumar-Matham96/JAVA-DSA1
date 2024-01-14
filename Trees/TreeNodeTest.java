package Trees;

import java.util.*;

public class TreeNodeTest {
    /**
     * replace node values with their respective depths
     */
    public static TreeNode<Integer> replaceNodeValuesWithTheirDepths(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);
        int depth = 0;

        while (!pendingQueue.isEmpty()) {
            int levelSize = pendingQueue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> front = pendingQueue.poll();
                front.data = depth; // Replace node value with its depth

                for (TreeNode<Integer> child : front.children) {
                    if (child != null) {
                        pendingQueue.add(child);
                    }
                }
            }
            depth++; // Increment depth for the next level
        }

        return root;
    }



    /**
     * count of leaf nodes
     */
    public static int countOfLeafNodes(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> pendinQueue = new LinkedList<>();
        pendinQueue.add(root);

        int leaves = 0;

        while(!pendinQueue.isEmpty()){
            TreeNode<Integer> front = pendinQueue.poll();
            if(front.children.isEmpty()){
                leaves++;
            }
            for(int i =0; i < front.children.size(); i++){
                pendinQueue.add(front.children.get(i));
            }
        }
        return leaves;
    }

    /**
     * second largest node
     */
    public static TreeNode<Integer> secondLargestOfTheNodes(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        TreeNode<Integer> maxNode = null;
        TreeNode<Integer> secondMaxNode = null;
        int maxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;

        pendingQueue.add(root);

        while (!pendingQueue.isEmpty()) {
            TreeNode<Integer> front = pendingQueue.poll();

            if (front.data > maxValue) {
                secondMaxValue = maxValue;
                maxValue = front.data;

                secondMaxNode = maxNode;
                maxNode = front;
            } else if (front.data > secondMaxValue && front.data != maxValue) {
                secondMaxValue = front.data;
                secondMaxNode = front;
            }

            for (int i = 0; i < front.children.size(); i++) {
                pendingQueue.add(front.children.get(i));
            }
        }

        return secondMaxNode;
    }


    /**
     * largest of all the nodes
     */
    public static TreeNode<Integer> largestOfTheNodes(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        TreeNode<Integer> maxNode = null;
        int maxValue = Integer.MIN_VALUE;

        pendingQueue.add(root);

        while(!pendingQueue.isEmpty()){
            TreeNode<Integer> front = pendingQueue.poll();
            if(front.data > maxValue){
                maxValue = front.data;
                maxNode = front;
            }
            for(int i = 0; i < front.children.size(); i++){
                pendingQueue.add(front.children.get(i));
            }
        }
        return maxNode;

    }

    /**
     * data just larger than a given number
     */
    public static int nextLargerData(TreeNode<Integer> root, int n) {
        if(root == null){
            return -1;
        }

        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);

        ArrayList<Integer> dataList = new ArrayList<>();

        while(!pendingQueue.isEmpty()){
            TreeNode<Integer> front = pendingQueue.poll();
            dataList.add(front.data);
//
            for(int i = 0; i < front.children.size(); i++){
                pendingQueue.add(front.children.get(i));
            }
        }

        Collections.sort(dataList);

        int nextLargerElement = 0;
        for (int i = 0; i < dataList.size(); i++) {
            if(dataList.get(i) > n){
                nextLargerElement = dataList.get(i);
                break;
            }
        }
        return nextLargerElement;
    }

    /**
     * node that contains next larger element
     */
    public static TreeNode<Integer> nextLargerNode(TreeNode<Integer> root, int n) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);

        TreeNode<Integer> nextLarger = null;

        while (!pendingQueue.isEmpty()) {
            TreeNode<Integer> front = pendingQueue.poll();

            if (front.data > n && (nextLarger == null || front.data < nextLarger.data)) {
                nextLarger = front;
            }

            for (int i = 0; i < front.children.size(); i++) {
                pendingQueue.add(front.children.get(i));
            }
        }

        return nextLarger;
    }


    /**
     * identical trees?
     */
    public static boolean areIdenticalTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<TreeNode<Integer>> queue1 = new LinkedList<>();
        Queue<TreeNode<Integer>> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode<Integer> front1 = queue1.poll();
            TreeNode<Integer> front2 = queue2.poll();

            if (!front1.data.equals(front2.data)) {
                return false;
            }

            ArrayList<TreeNode<Integer>> children1 = front1.children;
            ArrayList<TreeNode<Integer>> children2 = front2.children;

            if (children1.size() != children2.size()) {
                return false;
            }

            for (int i = 0; i < children1.size(); i++) {
                if (!children1.get(i).data.equals(children2.get(i).data)) {
                    return false;
                }
                queue1.add(children1.get(i));
                queue2.add(children2.get(i));
            }
        }

        return true;
    }

    /**
     * find maximum sum node:
     *
     * - find the sum of node value and it's immediate child node's values
     * - compare all the sums
     * - return the node which has the max sum value
     */
    public static int getMaxSumNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);

        int maxSum = Integer.MIN_VALUE;
        TreeNode<Integer> maxNode = null;

        while (!pendingQueue.isEmpty()) {
            TreeNode<Integer> front = pendingQueue.poll();
            int sum = front.data;

            for (TreeNode<Integer> child : front.children) {
                sum += child.data;
                pendingQueue.add(child);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxNode = front;
            }
        }

        if (maxNode != null) {
            return maxNode.data;
        } else {
            return 0; // Default return value if the tree is empty
        }
    }

    /**
     * is tree contains x?
     */
    public static boolean isTreeContainsX(TreeNode<Integer> root, int x) {
        if(root == null){
            return false;
        }

        if(root.data == x){
            return true;
        }

        for(TreeNode<Integer> child: root.children){
            if(isTreeContainsX(child,x)){
                return true;
            }
        }
        return false;
    }

    /**
     * Post-order traversal
     */
    public static void postOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        for (TreeNode<Integer> child : root.children) {
            postOrder(child);
        }

        System.out.print(root.data + " ");
    }

    /**
     * Height of the tree
     */
    public static int heightOfTheTree(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int height = 0; // Initialize height as 0

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Track the number of nodes at each level

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> front = queue.poll();
                for (TreeNode<Integer> child : front.children) {
                    queue.add(child);
                }
            }
            height++; // Increment height for each level
        }
        return height;
    }

    /**
     * Number of nodes greater than X
     */
    public static int numberOfNodesGreaterThanX(TreeNode<Integer> root, int x) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        int nodesCount = 0;
        while(!queue.isEmpty()){
            TreeNode<Integer> front = queue.poll();
            if(front.data > x){
                nodesCount++;
            }

            for (TreeNode<Integer> child: front.children){
                queue.add(child);
            }
        }

        return nodesCount;
    }

    /**
     * take input for the tree
     */
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner scanner = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        System.out.println("Enter the value");
        int value = scanner.nextInt();
        if(value == -1){
            return null;
        }

        TreeNode<Integer> node = new TreeNode<>(value);
        pendingNodes.add(node);

        while(!pendingNodes.isEmpty()){
            TreeNode<Integer> nodeVal = pendingNodes.poll();
            System.out.println("Enter the number of children for "+nodeVal.data);
            int numberOfChildren = scanner.nextInt();

            for (int i = 0; i < numberOfChildren; i++) {
                System.out.println("Enter the "+i+"th child of "+nodeVal.data);
                int childData = scanner.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                nodeVal.children.add(childNode);
                pendingNodes.add(childNode);
            }
        }
        return node;
    }

    /**
     * Sum of nodes
     */
    public static int sumOfNodes(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }

        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += sumOfNodes(root.children.get(i));
        }
        return sum;
    }

    /**
     * Find number of nodes
     */
    public static int getNumberOfNodes(TreeNode<Integer> root) {
        if(root == null){
            return 0;
        }

        int numberOfNodes = 1;

        for (int i = 0; i < root.children.size(); i++) {
            numberOfNodes += getNumberOfNodes(root.children.get(i));
        }
        return numberOfNodes;
    }

    /**\
     * Printing tree in pre-order with respective children
     * @param root
     */
    public static void printTree3(TreeNode<Integer> root) {
        if(root == null){
            return;
        }

        // printing the root
        System.out.print(root.data+": ");

        // printing the children of the root
        for(int i = 0; i < root.children.size(); i++){
            System.out.print((root.children.get(i)).data+" ");
        }
        System.out.println();

        // calling the print function on children
        for(int i = 0; i < root.children.size(); i++){
            printTree3(root.children.get(i));
        }
    }

    /**
     * Printing tree in pre-order
     * @param root
     */
    public static void printTree2(TreeNode<Integer> root) {

        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            printTree2(root.children.get(i));
        }
    }

    /**
     * Print tree as required level-wise
     */
    public static void printTree1New(TreeNode<Integer> root) {
        if(root == null){
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        System.out.println(root.data);

        while(!queue.isEmpty()){
            TreeNode<Integer> front = queue.poll();

            if(!front.children.isEmpty()){
//                System.out.print(front.data);
                for(int i = 0; i<front.children.size(); i++ ){
                    queue.add(front.children.get(i));
                    if(!front.children.get(i).equals(" ")){
                        System.out.print(front.children.get(i).data+" ");
                    }
                }
//                System.out.println();
            }else{
//                System.out.print("node value: "+front.data+" => ");
                for(int i = 0; i<front.children.size(); i++ ){
//                    queue.add(front.children.get(i));
                    System.out.print(front.children.get(i).data+" ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Printing the tree level-wise
     * @param root
     */
    public static void printTree1(TreeNode<Integer> root) {
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

        // tree 2
        TreeNode<Integer> root2 = new TreeNode<>(4);
        TreeNode<Integer> node1_new = new TreeNode<>(2);
        TreeNode<Integer> node2_new = new TreeNode<>(3);
        TreeNode<Integer> node3_new = new TreeNode<>(10);
        TreeNode<Integer> node4_new = new TreeNode<>(5);
        TreeNode<Integer> node5_new = new TreeNode<>(6);

        root2.children.add(node1_new);
        root2.children.add(node2_new);
        root2.children.add(node3_new);
        node2_new.children.add(node4_new);
        node2_new.children.add(node5_new);

//        TreeNode<Integer> root = takeInputLevelWise();

        printTree1(root);
//        printTree1New(root);
//        postOrder(root);
//        System.out.println("\n\nRecursive print:");
//        printTree2(root);
//        System.out.println("\n\nroot with children:");
//        printTree3(root);
//        System.out.println("\n\nPrinting number of roots in the tree");
//        System.out.println(getNumberOfNodes(root));
//        System.out.println("\n\nsum of nodes:");
//        System.out.println(sumOfNodes(root));
//        System.out.println(numberOfNodesGreaterThanX(root, 5));
        System.out.println("Height: "+heightOfTheTree(root));
        System.out.println("is element exists: "+isTreeContainsX(root,8));

        System.out.println();
        System.out.println("Maximum sum node => "+getMaxSumNode(root));
        System.out.println();
        System.out.println("are identical_1 ? "+areIdenticalTrees(root,root2));
        System.out.println();
        System.out.println("next largest element: "+nextLargerData(root, 1));
        System.out.println();
        System.out.println("next largest element node: "+nextLargerNode(root, 1).data);
        System.out.println();
        System.out.println("MaxNode: "+largestOfTheNodes(root2).data);
        System.out.println();
        System.out.println("Second largest node: "+secondLargestOfTheNodes(root2).data);
        System.out.println();
        System.out.println("Number of leaves: "+ countOfLeafNodes(root));
        System.out.println();
        printTree1(replaceNodeValuesWithTheirDepths(root));
    }
}
