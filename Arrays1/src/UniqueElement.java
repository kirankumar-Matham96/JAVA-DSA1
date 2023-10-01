public class UniqueElement {
    public static int findUnique(int[] arr) {
		for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 1){
                return arr[i];
            }
        }
        return -1;
	}
    public static void main(String[] args) {
        int[] arr = {1,7,1,3,7};
        int unique = findUnique(arr);
        System.out.println(unique);
    }    
}
