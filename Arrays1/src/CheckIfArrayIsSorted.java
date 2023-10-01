public class CheckIfArrayIsSorted {
    public static boolean checkSort(int[] arr){
        if(arr.length == 1){
            return true;
        }

        if(arr[0] > arr[1]){
            return false;
        }

        int[] smallArr = new int[arr.length-1];
        for(int i = 1 ; i < arr.length; i++){

            smallArr[i-1] = arr[i];
        }

        boolean isSmallArrSorted = checkSort(smallArr);
        return isSmallArrSorted;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        
        System.out.println(checkSort(arr));
    }
}
