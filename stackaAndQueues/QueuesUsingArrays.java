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

    public void enqueue(int element) throws QueueFullException {
//        if(size == 0){
//            frontEnd = element;
//            rearEnd = element;
//        }else{
//            rearEnd = element;
//        }
//
//        data[size] = element;
//        size++;

        if(size == data.length) {
            throw new QueueFullException();
        }

        if(size == 0){
            frontEnd++;
        }
        rearEnd++;
        data[rearEnd] = element;
        size++;
    }

    public int dequeue() throws QueueEmptyException{
//        int[] newData = new int[data.length];
//
//        for(int i = 0; i < data.length-1; i++){
//            newData[i] = data[i+1];
//        }
//        data = newData;
//        frontEnd = data[0];
//        if(size > 0){
//            size--;
//        }
//        if(size == 0){
//            rearEnd = -1;
//        }

        if(size == 0){
            // throw an exception
            throw new QueueEmptyException();
        }
        int temp = data[frontEnd];
        frontEnd++;
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
