public class MergeSortRecursive {

    public static void mergeArrs(int[] a, int[] b, int[] dest) {

        int i = 0;
        int j = 0;
        int k = 0;
        for (; i < a.length && j < b.length;) {
            if (a[i] <= b[j]) {
                dest[k] = a[i];
                i++;
                k++;
            } else {
                dest[k] = b[j];
                j++;
                k++;
            }
        }

        if (i < a.length) {
            while (i < a.length) {
                dest[k] = a[i];
                i++;
                k++;
            }
        }

        if (j < b.length) {
            while (j < b.length) {

                dest[k] = b[j];
                j++;
                k++;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // find mid: arr.lemgth/2

        int[] b = new int[arr.length / 2];
        int[] c = new int[arr.length - b.length];

        // sort s1
        for (int i = 0; i < arr.length / 2; i++) {
            b[i] = arr[i];
        }

        for (int i = arr.length / 2; i < arr.length; i++) {
            c[i - arr.length / 2] = arr[i];
        }
        mergeSort(b);
        mergeSort(c);
        mergeArrs(b, c, arr);

    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, 3, 7, 8, 4, 9, 5, 6, 1 };
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
