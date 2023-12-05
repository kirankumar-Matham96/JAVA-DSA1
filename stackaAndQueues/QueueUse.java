package stackaAndQueues;

public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException,QueueFullException {
        QueuesUsingArrays queue= new QueuesUsingArrays(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();

        System.out.println("front: "+queue.front());
        System.out.println("rear: "+queue.rear());
        System.out.println("size: "+queue.size());
    }
}
