public class DuplicateElement {
    public static int duplicate(int[] arr) {
        int result = 0;
		for(int i=0;i<arr.length;i++)
		{
			result ^= arr[i];
		}
						
		return (result < 0 ? -1 : result);              
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,4};
        System.out.println(duplicate(arr));
    }
}
