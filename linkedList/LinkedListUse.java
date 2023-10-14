package linkedList;

import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(20);
        Node<Integer> n3 = new Node<Integer>(30);
        Node<Integer> n4 = new Node<Integer>(40);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

//        System.out.println(n1 + " -> " + n1.getData() + " Next -> "+ n1.getNext());
//        System.out.println(n2 + " -> " + n2.getData() + " Next -> "+ n2.getNext());
//        System.out.println(n3 + " -> " + n3.getData() + " Next -> "+ n3.getNext());
//        System.out.println(n4 + " -> " + n4.getData() + " Next -> "+ n4.getNext());

        return n1;
    }

    public static void print(Node<Integer> head) {
        // System.out.println(head + " -> " + head.getData());
        // System.out.println(head.getNext() + " -> " + head.getNext().getData());
        // System.out.println(head.getNext().getNext() + " -> " + head.getNext().getNext().getData());
        // System.out.println(head.getNext().getNext().getNext() + " -> " + head.getNext().getNext().getNext().getData());
        // System.out.println(head.getNext().getNext().getNext().getNext() + " -> Last Node pointing to null");
        
        // dynamic way

        Node<Integer> temp = head;

        while (temp != null) {
            System.out.println("Head -> " + temp.getData() + " next -> "+ temp.getNext());
            temp = temp.getNext();
        }
    }

    public static void increment(Node<Integer> head) {
        Node<Integer> temp = head;

        while(temp != null){
            temp.setData(temp.getData()+1);
            temp = temp.getNext();
        }
    }

    public static int length(Node<Integer> head) {
        Node<Integer> temp = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public static void printIthNode(Node<Integer> head, int i){
        Node<Integer> temp = head;
        int count = 0;
        while(temp != null){
            if(count == i){
                System.out.println(temp.getData());
                return;
            }
            temp = temp.getNext();
            count++;
        }
    }

    public static Node<Integer> takeInput() {

        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        Node<Integer> head = null;

        while(data != -1){
            Node<Integer> currentNode = new Node<Integer>(data);
            if(head == null){
                head = currentNode;
            }else{
                Node<Integer> tail = head;

                // traversing to the last node
                while(tail.getNext() != null){
                    tail = tail.getNext();
                }

                // node is connecting here at the last node of the previous LL
                tail.setNext(currentNode);
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void main(String[] args) {
//        Node<Integer> head = createLinkedList();

        Node<Integer> head1 = takeInput();
        print(head1);
//        print(head);
//        System.out.println();
//        increment(head);
//        print(head);
//        System.out.println();
//        System.out.println(length(head));
//        printIthNode(head, 3);
    }
}
