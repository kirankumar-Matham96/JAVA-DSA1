package Recursion;

public class SubSetOfAnArray {

    public static int[][] subsetsSumToKHelper(int[] a, int startIndex, int sum) {
        // base case
        if (startIndex == a.length) {
            int[][] output = {{}};
            if (sum == 0) {
                return output;  // Empty subset
            }
            return new int[0][0];  // Empty array
        }

        // Exclude the current element
        int[][] smallerOutput1 = subsetsSumToKHelper(a, startIndex + 1, sum);

        // Include the current element
        int[][] smallerOutput2 = subsetsSumToKHelper(a, startIndex + 1, sum - a[startIndex]);

        // Create a new 2D array and add the current element to the included subsets
        int[][] output = new int[smallerOutput1.length + smallerOutput2.length][];

        // Copy subsets from smallerOutput1
        for (int i = 0; i < smallerOutput1.length; i++) {
            output[i] = smallerOutput1[i].clone();
        }

        // Copy subsets from smallerOutput2 and add the current element
        for (int i = 0; i < smallerOutput2.length; i++) {
            output[i + smallerOutput1.length] = new int[smallerOutput2[i].length + 1];
            output[i + smallerOutput1.length][0] = a[startIndex];

            for (int j = 0; j < smallerOutput2[i].length; j++) {
                output[i + smallerOutput1.length][j + 1] = smallerOutput2[i][j];
            }
        }

        return output;
    }
    public static int[][] subsetsSumToK(int[] a, int k) {
        return subsetsSumToKHelper(a, 0, k);
    }

    public static int[][] subsetHelper(int[] a, int startIndex) {
        // base case
        if(startIndex == a.length){
            int[][] output = new int[1][0];
            return output;
        }

        int[][] smallerOutput = subsetHelper(a, startIndex+1);
        int[][] output = new int[smallerOutput.length*2][];
        int k = 0;
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j];
            }
            k++;
        }

        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length + 1];
            output[k][0] = a[startIndex];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                output[k][j+1] = smallerOutput[i][j];
            }
            k++;
        }
        return output;
    }
    public static int[][] subSets(int[] a) {
        return subsetHelper(a,0);
    }

    public static void main(String[] args) {
//        String[] arr = {"abc", "def", "geh", "ijk", "lmn", "opq"};
//        returnSubSetOfAnArray(arr);
        int[] a = {1, 2, 3};
        int[][] ans = subSets(a);
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        int[][] newAns = subsetsSumToK(a, 3);

        for (int i = 0; i < newAns.length; i++){
            for (int j = 0; j < newAns[i].length; j++){
                System.out.print(newAns[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
