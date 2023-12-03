package collectionsFramework;

import java.util.Stack;

public class StacksInCollections {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);

        System.out.println("isEmpty? "+stack.isEmpty());
        System.out.println("empty: "+stack.empty());
        stack.pop();
//        System.out.println("isEmpty? "+stack.isEmpty());

//        System.out.println("Peek the top element: "+stack.peek());
//        stack.search();
//        stack.add();
//        stack.add();
//        stack.capacity();
//        stack.clear();
//        stack.firstElement();
        System.out.println("Size: "+stack.size());
    }
}
