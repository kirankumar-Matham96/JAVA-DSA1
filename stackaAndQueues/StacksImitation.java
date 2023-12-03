package stackaAndQueues;

public class StacksImitation {

    private int[] stackData;
    private int topElement;
    private int topIndex;

    public StacksImitation(){
        stackData = new int[2];
        topElement = -1;
        topIndex = 0;
    }
    public StacksImitation(int stackSize){
        stackData = new int[stackSize];
        topElement = -1;
        topIndex = 0;
    }

    public void printStack(){
        for (int i : stackData) {
            System.out.println(i);
        }
    }

    public void push(int n) throws StackFullException{
        // insert the element into the stack
        // also modify/update the topElement
        // if stack is full raise an exception

//        throw IndexOutOfBoundsException;
        if(topIndex == stackData.length - 1){
//            StackFullException e = new StackFullException();
//            throw e;
            // throw new StackFullException();

            // double the capacity
            doubleCapacity();
        }
        stackData[topIndex] = n;
        if(topElement == -1) {
            topIndex = 0;
        }else{
            topIndex++;
        }
        topElement = n;
        System.out.println("element inserted");
    }

    private void doubleCapacity() {
        int[] tempData = stackData;
        stackData = new int[2*(tempData.length)];
        for (int i = 0; i < tempData.length; i++) {
            stackData[i] = tempData[i];
        }
    }

    public int size(){
//        return stackData.length;// it will give te entire array length even if the array is empty
        // So
         return topIndex + 1;
    }

    public boolean isEmpty(){
        return topElement == -1;
    }

    public int top() throws StackEmptyException {
        if(topElement == -1){
            throw new StackEmptyException();
        }
        return stackData[topIndex]; // return the last element;
    }

    public int pop() throws StackOutOfBoundsException{
        if(topElement == -1){
            throw new StackOutOfBoundsException();
        }

        int temp = stackData[topIndex];
        topIndex--;
        return temp;
    }
}
