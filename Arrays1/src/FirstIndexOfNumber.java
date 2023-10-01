public class FirstIndexOfNumber {
    public static int findIndex(int[] arr, int n) {
        if(arr.length == 0){
            return -1;
        }

        if(arr[0] == n){
            return 0;
        }

        int[] small = new int[arr.length-1];
        for(int i = 1; i < arr.length; i++){
            small[i-1] = arr[i];
        }

        int firstIndex = findIndex(small, n);
        if(firstIndex == -1){
            return -1;
        }else{
            return firstIndex+1;
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findIndex(arr, 10));
        
    }
}
