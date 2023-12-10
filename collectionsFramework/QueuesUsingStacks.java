package collectionsFramework;
import java.util.Stack;
public class QueuesUsingStacks<T> {

    Stack<T> stack1;
    Stack<T> stack2;

    private T front;
    public QueuesUsingStacks(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public int size(){
        return stack1.size();
    }

    public boolean isEmpty(){
        return stack1.isEmpty();
    }
    public void enque(T element){
        if(stack1.isEmpty()){
            front = element;
        }
        stack1.add(element);
    }
    public T deque(){
        for(T i : stack1){
            stack2.add(i);
        }
        T temp = stack2.pop();

        for(T i : stack2){
            if(stack1.isEmpty()){
                front = i;
            }
            stack1.add(i);
        }
        return temp;
    }

    public void front(){

    }


}
