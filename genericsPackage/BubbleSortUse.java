package genericsPackage;

public class BubbleSortUse {

    public static <T> void sort(Integer[] arr) {
        BubbleSortClass<Integer> bs = new BubbleSortClass<Integer>(arr);
        bs.print();
    }

    public static void main(String[] args) {
        Integer[] arr = {2,5,4,1,3};

        sort(arr);
    }
}
