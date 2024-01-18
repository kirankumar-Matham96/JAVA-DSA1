package PriorityQueues;

import java.util.ArrayList;

public class MaxPriorityQueuesClass<T> {
    private ArrayList<Element<T>> heap;

    public MaxPriorityQueuesClass() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        // Insert element at the end
        Element<T> newElement = new Element<>(value, priority);
        heap.add(newElement);

        // Move the element to the appropriate position (Max-Heap)
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex).priority > heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public T getMax() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMax() throws EmptyPriorityQueueException {
        if (heap.isEmpty()) {
            throw new EmptyPriorityQueueException();
        }

        // Remove the root element first and store it in temp
        Element<T> removed = heap.get(0);
        T max = removed.value;

        // Place the last element in the root
        heap.set(0, heap.get(heap.size() - 1));
        // Remove the element from the last
        heap.remove(heap.size() - 1);

        // Arrange the heap in Complete Binary Tree Order (Max-Heap)
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        while (leftChildIndex < heap.size()) {
            int maxIndex = parentIndex;
            if (heap.get(leftChildIndex).priority > heap.get(maxIndex).priority) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority > heap.get(maxIndex).priority) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == parentIndex) {
                break;
            }

            Element<T> temp = heap.get(maxIndex);
            heap.set(maxIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = maxIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
        return max;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
