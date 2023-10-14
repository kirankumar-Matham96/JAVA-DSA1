package genericsPackage;

public class PrintArrayGenericMethod {

    // generic method
    public static<T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * Generic methods are not bound to any generic type.
     * Hence, if we want to bound the generic methods with any class,
     * we can extend the generic type with class name.
     * But this method will be bound to the Vehicle class only.
     * To make it generic we can use interface.
     * @param arr
     * @param <T>
     */
    public static<T extends Vehicle> void printArrayValues(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
    }

    /**
     * This is the generic method which will extend the interface.
     * All the classes which are implementing this interface will be bound to this method,
     * which will make this method more generic.
     * @param arr
     * @param <T>
     */
    public static<T extends PrintInterface> void printArrayValuesByClass(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        printArray(arr);

        String[] arr2 = new String[5];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i+"1";
        }

        printArray(arr2);

        Double[] arr3 = new Double[5];

        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = i+1.25;
        }

        printArray(arr3);

        Pair[] p = new Pair[5];

        printArray(p);

        Vehicle[] v = new Vehicle[5];

        for (int i = 0; i < v.length; i++) {
            v[i] = new Vehicle(10*(i+1), 4);
        }

        printArrayValues(v);


    }
}
