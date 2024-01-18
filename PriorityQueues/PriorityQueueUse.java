package PriorityQueues;

public class PriorityQueueUse {
    public static void main(String[] args) {
        System.out.println("For min Priority");
        MinPriorityQueuesClass<String> pq = new MinPriorityQueuesClass<>();
        pq.insert("a", 15);
        pq.insert("b", 10);
        pq.insert("c", 90);
        pq.insert("d", 150);
        pq.insert("e", 120);

        while(!pq.isEmpty()){
            try {
                System.out.println(pq.getMin());
                pq.removeMin();
            } catch (EmptyPriorityQueueException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("For min Priority");
        // max priorityQueue
        MaxPriorityQueuesClass<String> pqMax = new MaxPriorityQueuesClass<>();
        pqMax.insert("a", 15);
        pqMax.insert("b", 10);
        pqMax.insert("c", 90);
        pqMax.insert("d", 150);
        pqMax.insert("e", 120);

        while(!pqMax.isEmpty()){
            try {
                System.out.println(pqMax.getMax());
                pqMax.removeMax();
            } catch (EmptyPriorityQueueException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
