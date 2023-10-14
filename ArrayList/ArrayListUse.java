package ArrayList;
import java.util.ArrayList;

public class ArrayListUse {

    public static ArrayList<Integer> removeConsecutiveDuplicates(int[] arr) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                al.add(arr[i]);
            }
        }
        return al;
    }

    /**
     * Basic ArrayList Operations
     */
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(20);
        al.add(30);
        al.add(10);
        al.add(40);
        al.add(50);

        System.out.println(al.size());
        al.add(2,60);

        System.out.println(al.size());

        System.out.println(al.get(2));

        al.set(0, 100);

        // can pass the index to remove the element
        al.remove(0);

        // can pass the object of the element to remove the element
        Integer element = 40;
        al.remove(element);

        // enhanced for loop (for each)
        // for (int i : al){
        //     System.out.println(i);
        // }

        // normal approach
        // al.forEach(i -> {
        // System.out.println(i);
        // });

        // lambda expression
        al.forEach(System.out::println);


        System.out.println("\n\n\n\n");

        int[] al2 = {10,10,10,20,10,10,10,30,30,40,40,50,60,10,20,20};

        ArrayList<Integer> alr = removeConsecutiveDuplicates(al2);

        for (int i : alr){
            System.out.println(i);
        }
    }
}
