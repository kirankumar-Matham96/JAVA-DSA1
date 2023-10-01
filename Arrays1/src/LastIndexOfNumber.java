public class LastIndexOfNumber {
    public static int findLastIndex(int[] arr, int n) {
        if(arr.length == 0){
            return -1;
        }
        int[] small = new int[arr.length-1];
            for(int i = 1; i < arr.length; i++){
                small[i-1] = arr[i];
            }
            int k = findLastIndex(small, n);
            if(k != -1){
                return k+1;
            }else{
                if(arr[0] == n){
                    return 0;
                } else{
                    return -1;
                }
            }
    }
        public static void main(String[] args) {
            int[] arr = {1,2,1,2,2,3,2,5,6,6,3,2};

            System.out.println(findLastIndex(arr, 2));
            
        }
}
