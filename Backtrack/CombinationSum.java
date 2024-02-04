package Backtrack;


import java.util.*;

public class CombinationSum {
    public static void findNumbers(List<List<Integer>> ans, int[] arr, int sum, int index, List<Integer> temp) {
        if (sum == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if ((sum - arr[i]) >= 0) {
                temp.add(arr[i]);
                findNumbers(ans, arr, sum - arr[i], i, temp);
                temp.remove(temp.size() - 1); // Fix here
            }
        }
    }

    public static List<List<Integer>> combSum(int[] ARR, int B) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : ARR) {
            set.add(num);
        }

        int[] uniqueArr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            uniqueArr[index++] = num;
        }

        Arrays.sort(uniqueArr);

        findNumbers(ans, uniqueArr, B, 0, temp);
        return ans;
    }

    // Driver Code

    public static void main(String[] args) {

        int[] arr = {2,4,6,3};
        int sum = 8;

        List<List<Integer>> ans = combSum(arr, sum);

        // If result is empty, then
        if (ans.size() == 0) {
            System.out.println("Empty");
            return;
        }

        // print all combinations stored in ans

        for (int i = 0; i < ans.size(); i++) {

            System.out.print("(");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print(") ");
        }
    }
}
