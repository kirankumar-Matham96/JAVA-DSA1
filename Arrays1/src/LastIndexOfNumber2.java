public class LastIndexOfNumber2 {
    /**
     * 
     * @param arr array inpput
     * @param n number to find the last index
     * @param si starting index
     * @return last index of n
     */
    public static int findLastIndex(int[] arr, int n, int si) {
        if(si == arr.length){
            return -1;
        }
        
        int k = findLastIndex(arr, n, si+1);
        if(k != -1){
            return k;
        }else{
            if(arr[si] == n){
                return si;
            } else{
                return -1;
            }
        }
    }
        public static void main(String[] args) {
            int[] arr = {1,2,1,2,2,3,2,5,6,6,3,2};
    
            System.out.println(findLastIndex(arr, 2, arr.length-1));
            
        }
}
