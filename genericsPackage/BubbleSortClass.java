package genericsPackage;
import java.util.Arrays;

public class BubbleSortClass<T> {

    private T[] arr;

    public BubbleSortClass(T[] arr){
        this.arr = arr;
        sortArr();
    }

    public T[] getArr() {
        return arr;
    }

    public void sortArr(){
        Arrays.sort(this.arr);
    }

    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
