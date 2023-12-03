package stacksAndQueuesUsingLL;

import stackaAndQueues.StackEmptyException;

public class UsingLLStack {

    public static void main(String[] args) throws StackEmptyException {

        StacksUsingLL<Integer> stack = new StacksUsingLL<>();
        int[] arr = {1,2,3,4,5};

        for(int i = 0; i < arr.length; i++){
            stack.push(arr[i]);
        }

        System.out.println("Is Stack Empty? "+stack.isEmpty());

        System.out.println("Top element "+stack.top());

        System.out.println("popped: "+stack.pop());

        System.out.println("Top element "+stack.top());

        System.out.println("Size: "+stack.size());

    }
}
