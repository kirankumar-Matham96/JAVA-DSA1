package collectionsFramework;
import java.util.LinkedList;
import java.util.Queue;

public class QueuesInCollections {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println("size: "+queue.size());
        System.out.println("peek: "+queue.peek());
        System.out.println("size: "+queue.size());
        System.out.println("Pole: "+queue.poll());
        System.out.println("size: "+queue.size());
    }

}
