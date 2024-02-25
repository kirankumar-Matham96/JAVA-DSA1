package LeetCode;

import java.util.ArrayList;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        ArrayList<Integer> arrL = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i; j < arr.length; j++) {
                if(i != j && arr[i]+arr[j] == target){
//                    ans[i] = i;
//                    ans[j] = j;
                    arrL.add(i);
                    arrL.add(j);
                }
            }
        }

        int[] ans = new int[arrL.size()];
        for (int i = 0; i < arrL.size(); i++) {
            ans[i] = arrL.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(arr, 9);
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            if(i == ans.length-1){
                System.out.print(ans[i]);
            }else{
                System.out.print(ans[i] + ", ");
            }
        }
        System.out.print("]");
    }
}
