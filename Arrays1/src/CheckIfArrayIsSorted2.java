public class CheckIfArrayIsSorted2 {
    public static boolean checkSort(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }

        if(arr[index] > arr[index+1]){
            return false;
        }

        boolean isSmallArrSorted = checkSort(arr, index+1);
        return isSmallArrSorted;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,3,4};
        
        System.out.println(checkSort(arr, 0));
    }
}
