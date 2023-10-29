package linkedList;

public class RecursiveLinkedList extends Node<Integer> {
//    Node<Integer> head;
//    public RecursiveLinkedList(Node<Integer> head){
//        this.head = head;
//    }

    public void printLinkedListRecursively(Node<Integer> head) {
        if(head == null){
            return;
        }
        System.out.print(head.getData()+" ");
        printLinkedListRecursively(head.getNext());
    }

    public Node<Integer> insertNode(Node<Integer> head, int element, int position){
        if(head == null && position > 0){
            return null;
        }

        if(position == 0){
            Node<Integer> newNode = new Node<Integer> ();
            newNode.setData(element);
            newNode.setNext(head);
            return newNode;
        }else{
            head.setNext(insertNode(head.getNext(), element, position-1));
            return head;
        }
    }

    public Node<Integer> deleteNode(Node<Integer> head, int position) {
        if(head == null && position > 0){
            return null;
        }

        if(position == 0 && head != null){
            return head.getNext();
        }else if(head != null){
            head.setNext(deleteNode(head.getNext(), position-1));
            return head;
        }
        return head;
    }

    public Node<Integer> reverse(Node<Integer> head) {
        if(head == null || head.getNext() == null){
            return head;
        }
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // 5 -> 4 -> 3 -> 2 -> 1 -> null

        Node<Integer> nextNode = head.getNext();
        head.setNext(null);

        Node<Integer> remainingNodes = reverse(nextNode);

        nextNode.setNext(head);
        return remainingNodes;
    }

    public Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        Node<Integer> t1 = head1;
        Node<Integer> t2 = head2;
        Node<Integer> finalHead, tail;

        if (t1.getData() <= t2.getData()) {
            finalHead = t1;
            tail = t1;
            t1 = t1.getNext();
        } else {
            finalHead = t2;
            tail = t2;
            t2 = t2.getNext();
        }

        while (t1 != null && t2 != null) {
            if (t1.getData() <= t2.getData()) {
                tail.setNext(t1);
                tail = t1;
                t1 = t1.getNext();
            } else {
                tail.setNext(t2);
                tail = t2;
                t2 = t2.getNext();
            }
        }

        // Link the remaining nodes
        if (t1 != null) {
            tail.setNext(t1);
        } else {
            tail.setNext(t2);
        }

        return finalHead;
    }

    public Node<Integer> mergeSortLinkedList(Node<Integer> head){
            if (head == null || head.getNext() == null) {
                return head;
            }

            // Find the middle of the linked list
            Node middle = findMiddle(head);

            // Split the linked list into two halves
            Node left = head;
            Node right = middle.getNext();
            middle.setNext(null); // Split the list

            // Recursively sort the two halves
            left = mergeSortLinkedList(left);
            right = mergeSortLinkedList(right);

            // Merge the sorted halves
            return merge(left, right);
        }

        private Node findMiddle(Node<Integer> head) {
            Node slow = head;
            Node fast = head;

            while (fast.getNext() != null && fast.getNext().getNext() != null) {
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }

            return slow;
        }

        private Node merge(Node<Integer> left, Node<Integer> right) {
            Node merged = new Node(-1); // Dummy node
            Node current = merged;

            while (left != null && right != null) {
                if (left.getData() <= right.getData()) {
                    current.setNext(left);
                    left = left.getNext();
                } else {
                    current.setNext(right);
                    right = right.getNext();
                }
                current = current.getNext();
            }

            // Attach the remaining nodes
            if (left != null) {
                current.setNext(left);
            }
            if (right != null) {
                current.setNext(right);
            }

            return merged.getNext(); // Skip the dummy node
        }

}
