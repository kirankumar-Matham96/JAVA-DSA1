package linkedList;

public class Test {
    public static void main(String[] args) {
        Node1<Integer> n1 = new Node1<>(10);
        Node1<Integer> n2 = new Node1<>(20);
        Node1<Integer> n3 = new Node1<>(30);
        Node1<Integer> n4 = new Node1<>(40);
        Node1<Integer> n5 = new Node1<>(50);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node1<Integer> temp = Solution.appendLastNToFirst(n1, 3);

        while (temp != null) {
            System.out.println("Head -> " + temp.data + " next -> "+ temp.next);
            temp = temp.next;
        }


    }
}

class Node1<T> {
    T data;
    Node1<T> next;

    public Node1(T data) {
        this.data = data;
    }
}


class Solution {

    public static Node1<Integer> appendLastNToFirst(Node1<Integer> head, int n) {

        Node1<Integer> temp = head;
        Node1<Integer> tail = head;

        if(temp == null || n == 0){
            return head;
        }

        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }

        if(n > length){
            return head;
        }

        int count = 1;
        while(count < length - n){
            temp = temp.next;
            count++;
        }

        Node1<Integer> newHead = temp.next;
        tail.next = head;
        temp.next = null;
        return newHead;
    }


}
