public class QuickSortRecursive {
    public static int partition(int[] arr, int si, int ei) {
        int p = arr[si];
        int smallCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (arr[i] < p) {
                smallCount++;
            }
        }

        // swap pivot with count index
        int temp = arr[si + smallCount];
        arr[si + smallCount] = arr[si];
        arr[si] = temp;

        int i = si;
        int j = ei;
        while (i <= j) {
            if (arr[i] < p) {
                i++;
            } else if (arr[j] >= p) {
                j--;
            } else {
                // swap
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return si + smallCount;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int p = partition(arr, si, ei);

        quickSort(arr, si, p - 1); // Sort the left subarray
        quickSort(arr, p + 1, ei); // Sort the right subarray
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 9, 10, 1, 4, 2, 6, 7 };

        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
