public class BubbleSort {
    public static void main(String[] args) throws Exception {
        int[] arr = {8,4,5,2,7,1,3,6};

        for(int i = 0; i < arr.length-1; i++){
			for(int j = i; j < arr.length; j++){
				if(arr[i] > arr[j]){
					// swap
					arr[i] = arr[i] ^ arr[j];
					arr[j] = arr[i] ^ arr[j];
					arr[i] = arr[i] ^ arr[j];
				}
			}
		}

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
