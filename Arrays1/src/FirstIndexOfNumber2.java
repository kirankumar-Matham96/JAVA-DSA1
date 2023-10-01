public class FirstIndexOfNumber2 {
    public static int findIndex(int[] arr, int n, int si) {
        if(si == arr.length){
            return -1;
        }

        if(arr[si] == n){
            return si;
        }

           return findIndex(arr, n, si+1);
        // int firstIndex = findIndex(arr, n, si+1);
        // if(firstIndex == -1){
        //     return -1;
        // }else{
        //     return firstIndex+1;
        // }

    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(findIndex(arr, 5, 0));
        
    }
}
