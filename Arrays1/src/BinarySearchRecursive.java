public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int si, int ei, int x) {
        if(si > ei){
            return -1;
        }

        int middleIndex = (si+ei)/2;

        if(arr[middleIndex] == x){
            return middleIndex;
        }else if(arr[middleIndex] < x){
            return binarySearch(arr, middleIndex + 1, ei, x);
        }else if(arr[middleIndex] > x){
            return binarySearch(arr, si, middleIndex - 1, x);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr, 0, arr.length-1, 5));
    }
}
