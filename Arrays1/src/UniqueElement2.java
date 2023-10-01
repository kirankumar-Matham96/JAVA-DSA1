public class UniqueElement2 {
    public static int findUnique(int[] arr) {
		int result = 0;
		for(int i=0;i<arr.length;i++)
		{
			result ^= arr[i];
		}
						
		return (result>0 ? result : -1);
	}
    public static void main(String[] args) {
        int[] arr = {1,7,1,3,7};
        int unique = findUnique(arr);
        System.out.println(unique);
    }
}
