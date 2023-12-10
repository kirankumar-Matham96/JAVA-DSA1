package stacksAndQueuesUsingLL;
import stacksAndQueuesUsingLL.Node;
public class QueuesUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;

    int size;

    public QueuesUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(T element){
        Node<T> newNode = new Node<T>(element);
        size++;
        if(front == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
    }
    public T dequeue(T element){
        if(front == null){
            System.out.println("There is no data to remove in the queue!");
            return null;
        }
        T temp = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        size--;
        return temp;
    }

    public T front(){
        if(front == null){
            System.out.println("There is no data in the queue!");
        }
        return front.data;
    }
    public T rear(){
        return rear.data;
    }
}
