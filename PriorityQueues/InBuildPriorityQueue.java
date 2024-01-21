package PriorityQueues;

import java.util.PriorityQueue;

public class InBuildPriorityQueue {

    public static int buyTicket(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add everuthing to priority queue
        for (int i : input) {
            pq.add(i);
        }

        int count = 0;

        // compare each element for the priority.
        while (!pq.isEmpty()) {

            // if the element is less prioritized, send it to back and increase the count
            if (pq.peek() < input[k]) {
                int element = pq.poll();
                pq.add(element);
                count++;
            }

            // if the element is the right priority, remove it and increase the count
            else if (pq.peek() > input[k]) {
                pq.poll();
                count++;
            } else {
                break;
            }
            // wait till your turn comes
        }
        // then return count.
        return count;

    }

    public static void printKSmallestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // insert into priority queue
        for (int i = 0; i < k; i++){
            pq.add(arr[i]);
        }

//        for (int i = k; i < arr.length; i++){
//            if(pq.peek() > arr[i]){
//                pq.poll();
//                pq.add(arr[i]);
//            }
//        }

//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }

        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll());
        }


    }
    public static void printKLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer> ();

        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }

        for(int i=k; i < arr.length;i++){
            if(pq.peek()<arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }


    public static void main(String[] args) {
        int[] arr = {4,3,7,6,9,10,1,2};
        int[] arr2 = {4,1,6,3,7,2,9,8};

        // by default the priorityQueue will be minPriorityQueue
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            pq.add(arr[i]);
//        }
//
//        System.out.println("top element: "+pq.peek());
//        System.out.println("is empty? "+pq.isEmpty());
//        System.out.println("poll (remove the top element) "+pq.poll());
//        System.out.println();
//        pq.element();

        System.out.println("Largest: ");
        int k = 3;
        printKLargestElements(arr2, k);
        System.out.println("smallest: ");

        printKSmallestElements(arr2, k);

    }
}
