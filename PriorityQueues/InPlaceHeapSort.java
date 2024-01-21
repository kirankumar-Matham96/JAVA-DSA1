package PriorityQueues;

public class InPlaceHeapSort {

    public static void downHeapify(int[] arr, int start, int size) {
        int parentIndex = start;
        int leftChildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;

        while(leftChildIndex < size){
            int minIndex = parentIndex;
            if(arr[leftChildIndex] < arr[minIndex]){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < size && arr[rightChildIndex] < arr[minIndex]){
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                return;
            }

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }
    }

    public static void heapSort(int[] arr) {
        // build the heap
        for(int i=(arr.length/2)-1; i >= 0; i--){
            downHeapify(arr, i, arr.length);
        }

        // remove elements from the starting one by one, pu them at respective last positions
        for (int i = arr.length-1; i >= 0 ; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = {4,7,3,2,8,9,6,1};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
