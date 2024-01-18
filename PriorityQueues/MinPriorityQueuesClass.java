package PriorityQueues;

import java.util.ArrayList;

/**
 * Priority queues can be implemented using:
 *  -> Arrays
 *  -> ArrayList
 *  -> LinkedLists
 *  -> HashMaps
 *  -> Binary Search Trees
 *  -> Heap
 *
 *  In this class we are implementing PriorityQueues using Heaps.
 */
public class MinPriorityQueuesClass<T> {
    private ArrayList<Element<T>> heap;
    public MinPriorityQueuesClass(){
        heap = new ArrayList<>();
    }

    /**
     * Inserting in min-Heap
     * @param value
     * @param priority
     */
    public void insert(T value, int priority) {
        // insert element at the end
        Element<T> newElement = new Element<>(value, priority);
        heap.add(newElement);

        // now move the element to the appropriate position
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(heap.get(childIndex).priority < heap.get(parentIndex).priority){
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else{
                return;
            }
        }
    }

    public T getMin() throws EmptyPriorityQueueException {
        if(isEmpty()){
            throw new EmptyPriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMin() throws EmptyPriorityQueueException {
        if (heap.isEmpty()) {
            throw new EmptyPriorityQueueException();
        }

        // remove the root element first and store it in temp
        Element<T> removed = heap.get(0);
        T min = removed.value;

        // place the last element in the root
        heap.set(0, heap.get(heap.size() - 1));
        // remove the element from the last
        heap.remove(heap.size() - 1);

        // then arrange the heap in Complete Binary Tree Order
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        while(leftChildIndex < heap.size()){
            int minIndex = parentIndex;
            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && (heap.get(rightChildIndex).priority < heap.get(minIndex).priority)) {
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                break;
            }

            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }
        return min;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

}
