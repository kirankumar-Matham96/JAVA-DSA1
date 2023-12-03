package stackaAndQueues;

public class StackUse {
    public static void main(String[] args) throws StackEmptyException, StackFullException, StackOutOfBoundsException {
        StacksImitation stack = new StacksImitation(2);

        stack.push(2);
//        System.out.println("stack is empty? : "+stack.isEmpty());
//        System.out.println("stack top: "+stack.top());
        System.out.println("stack size: "+stack.size());
//        System.out.println("stack top element removed: "+stack.pop());
//        System.out.println("stack size: "+stack.size());
        stack.push(4);
        System.out.println("stack size: "+stack.size());
        stack.push(5);
        System.out.println("stack size: "+stack.size());
        stack.push(7);
        System.out.println("stack size: "+stack.size());
        stack.push(9);
        System.out.println("stack size: "+stack.size());
    }
}
