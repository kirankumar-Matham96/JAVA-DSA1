package stackaAndQueues;

public class QueuesUsingArrays {
    private int[] data;
    private int frontEnd;
    private int rearEnd;
    private int size;
    public QueuesUsingArrays(){
        data = new int[10];
        frontEnd = -1;
        rearEnd = -1;
    }

    public QueuesUsingArrays(int capacity){
        data = new int[capacity];
        frontEnd = -1;
        rearEnd = -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];

        int index = 0;
        for(int i = frontEnd; i < temp.length; i++){
            data[index++] = temp[i];
        }

        for(int i = 0; i < frontEnd - 1; i++){
            data[index++] = temp[i];
        }

        frontEnd = 0;
        rearEnd = temp.length - 1;
    }

    public void enqueue(int element) {

        if(size == data.length) {
//            throw new QueueFullException();
            doubleCapacity();
        }

        if(size == 0){
            frontEnd = 0;
        }

//        rearEnd++;

        // if the array has space
//        if(rearEnd == data.length){
//            rearEnd =0;
//            // this is circular queue behavior
//        }

        // optimized way
        rearEnd = (rearEnd + 1) % data.length;

        data[rearEnd] = element;
        size++;
    }

    public int dequeue() throws QueueEmptyException{
        if(size == 0){
            // throw an exception
            throw new QueueEmptyException();
        }
        int temp = data[frontEnd];
        frontEnd++;
        // normal way
//        if(frontEnd == data.length){
//            frontEnd = 0;
//        }

        // alternate way (optimized)
        frontEnd = (frontEnd + 1) % data.length;
        size--;

        if(size == 0){
            frontEnd = -1;
            rearEnd = -1;
        }

        return temp;
    }

    public int front() throws QueueEmptyException{
        if(size == 0){
            // throw an exception
            throw new QueueEmptyException();
        }
//        if(size > 0){
//            return data[frontEnd];
//        }else{
//            return -1;
//        }

        return data[frontEnd];
    }

    public int rear() throws QueueEmptyException{
        if(size == 0){
            // throw an exception
            throw new QueueEmptyException();
        }
        return data[rearEnd];
    }

}
