package stackaAndQueues;

public class QueueUse {
    public static void main(String[] args) {
        QueuesUsingArrays queue = new QueuesUsingArrays(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);

//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();

        try {
            System.out.println("front: " + queue.front());
            System.out.println("rear: " + queue.rear());
            System.out.println("size: " + queue.size());
        } catch (QueueEmptyException e) {
            throw new RuntimeException(e);
        }
    }
}
