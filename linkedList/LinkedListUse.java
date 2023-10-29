package linkedList;

import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> createLinkedList() {
        Node<Integer> n1 = new Node<Integer>(10);
        Node<Integer> n2 = new Node<Integer>(30);
        Node<Integer> n3 = new Node<Integer>(50);
        Node<Integer> n4 = new Node<Integer>(70);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

//        System.out.println(n1 + " -> " + n1.getData() + " Next -> "+ n1.getNext());
//        System.out.println(n2 + " -> " + n2.getData() + " Next -> "+ n2.getNext());
//        System.out.println(n3 + " -> " + n3.getData() + " Next -> "+ n3.getNext());
//        System.out.println(n4 + " -> " + n4.getData() + " Next -> "+ n4.getNext());

        return n1;
    }

    public static Node<Integer> createLinkedList2() {
        Node<Integer> n1 = new Node<Integer>(70);
        Node<Integer> n2 = new Node<Integer>(40);
        Node<Integer> n3 = new Node<Integer>(60);
        Node<Integer> n4 = new Node<Integer>(80);
        Node<Integer> n5 = new Node<Integer>(20);
        Node<Integer> n6 = new Node<Integer>(50);
        Node<Integer> n7 = new Node<Integer>(30);
        Node<Integer> n8 = new Node<Integer>(100);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

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

    /**
     * This method is used to take input to the linked list with O(n^2) time complexity
     * @return head of the linked list
     */
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

    /**
     * This method is used to take input to the linked list with minimized time complexity to O(n)
     * @return head of the linked list
     */
    public static Node<Integer> takeOptimizedInput() {
        Scanner s = new Scanner(System.in);
        Node<Integer> head = null, tail = null;
        int data = s.nextInt();


        while(data != -1){
        Node<Integer> currentNode = new Node<Integer>(data);
            if(head == null){
                head = currentNode;
                tail = currentNode;
            }else{
                tail = tail.getNext();
            }
            data = s.nextInt();
        }
        return head;
    }

    public static Node<Integer> insertElement(Node<Integer> head, int index, int value) {

        Node<Integer> temp = head;
        Node<Integer> nextNode = null;
        int count = 0;

        // iterating through the linked list
        while(temp.getNext() != null){
            // detecting the node where we should insert the new node before
            if(count == index-1){
                // getting the next node
                nextNode = temp.getNext().getNext();
                // creating the new node to insert the value
                Node<Integer> newNode = new Node<>(value);
                // attaching the new node to the current node
                temp.setNext(newNode);
                // attaching the next node to the new node
                newNode.setNext(nextNode);
                // returning the head (no need to iterate further)
                break;
            }
            temp = temp.getNext();
            count++;
        }
        return head;
    }

    public static Node<Integer> insertElement2(Node<Integer> head, int index, int value) {
        Node<Integer> temp = head;
        Node<Integer> newNode = new Node<Integer>(value);
        int count = 0;
        if(index == 0){
            newNode.setNext(head);
            return newNode;
        }else{
            while(count < index-1 && temp != null){
                temp = temp.getNext();
                count++;
            }

            if(temp != null){
                // setting tail to the new node
                newNode.setNext(temp.getNext());
                // connecting the new node to the existing node
                temp.setNext(newNode);
            }
            return head;
        }
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int index) {
        Node<Integer> temp = head;
        int count = 0;

        if(index == 0){
            return head.getNext();
        }else{
            while(count < index-1 && temp != null){
                temp = temp.getNext();
                count++;
            }

            if(temp != null && temp.getNext() != null && temp.getNext().getNext() != null){
                temp.setNext(temp.getNext().getNext());
            }else{
                temp.setNext(null);
            }
        }
        return head;
    }

    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        Node<Integer> temp = head;
        if(head == null){
            return head;
        }

        while(temp.getNext() != null){
            if(temp.getData() == temp.getNext().getData()){
                temp.setNext(temp.getNext().getNext());
            }
            temp = temp.getNext();
        }

        return head;
    }


    public static void main(String[] args) {
//        Node<Integer> head = createLinkedList();

//        Node<Integer> head1 = takeInput();
//        System.out.println();

//        head1 = removeDuplicates(head1);
//        print(head1);

        // insert an element in the linked list
//        insertElement2(head1, 3, 100);
//        print(head1);
//        System.out.println("inserting");
//        head1 = insertElement2(head1, 5, 100);
//        print(head1);

//        System.out.println("inserting");
//        head1 = insertElement2(head1, 0, 100);
//        print(head1);

//        System.out.println();
//        deleteNode(head1, 0);
//        System.out.println("deleted");
//        head1 = deleteNode(head1, 2);
//        print(head1);

//        System.out.println("deleted first");
//        head1 = deleteNode(head1, 0);
//        print(head1);

//        System.out.println("deleted last");
//        head1 = deleteNode(head1, 5);
//        print(head1);

//        System.out.println();
//        insertElement2(head1, 5, 100);
//        print(head1);
//        System.out.println();

//        print(head);
//        System.out.println();
//        increment(head);
//        print(head);
//        System.out.println();
//        System.out.println(length(head));
//        printIthNode(head, 3);


        /**
         * recursive methods
         */
//        Node<Integer> newHead = createLinkedList();
//        RecursiveLinkedList rll = new RecursiveLinkedList();
//        rll.printLinkedListRecursively(newHead);
//        System.out.println();
//        rll.printLinkedListRecursively(rll.insertNode(newHead, 100, 3));

        // delete node recursively
//        Node<Integer> newHead = createLinkedList();
//        RecursiveLinkedList rll2 = new RecursiveLinkedList();
//        rll2.printLinkedListRecursively(newHead);
//        System.out.println();
//        rll2.printLinkedListRecursively(rll2.deleteNode(newHead, 6));

        // delete node recursively
//        Node<Integer> newHead = createLinkedList();
//        RecursiveLinkedList rll3 = new RecursiveLinkedList();
//        rll3.printLinkedListRecursively(newHead);
//        System.out.println();
//        rll3.printLinkedListRecursively(rll3.reverse(newHead));

        // merging 2 sorted linked lists
//        Node<Integer> newHead1 = createLinkedList();
//        Node<Integer> newHead2 = createLinkedList2();
//        RecursiveLinkedList rll4 = new RecursiveLinkedList();
//        rll4.printLinkedListRecursively(newHead1);
//        System.out.println();
//        rll4.printLinkedListRecursively(newHead2);
//        System.out.println();
//        rll4.printLinkedListRecursively(rll4.mergeTwoSortedLinkedLists(newHead1,newHead2));

        // merge sort
        Node<Integer> newHead = createLinkedList2();
        RecursiveLinkedList rll5 = new RecursiveLinkedList();
        rll5.printLinkedListRecursively(newHead);
        System.out.println();
        rll5.printLinkedListRecursively(rll5.mergeSortLinkedList(newHead));



    }
}
