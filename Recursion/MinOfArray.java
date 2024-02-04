package Recursion;

public class MinOfArray {

    public static int getMinHelper(int[] a, int startIndex) {
        // base case
        if(startIndex == a.length){
            return Integer.MAX_VALUE;
        }

        int minOfSmallerArr = getMinHelper(a, startIndex+1);
        int ans = Math.min(minOfSmallerArr, a[startIndex]);
        return ans;
    }
    public static int getMin(int[] a) {
        int m = getMinHelper(a, 0);
        return m;
    }

    public static void printMinHelper(int[] a, int startIndex, int minSoFar) {
        // base case
        if (startIndex == a.length) {
            System.out.println(minSoFar);
            return;
        }

        int newMinSoFar = Math.min(a[startIndex], minSoFar);
        printMinHelper(a, startIndex+1, newMinSoFar);
    }
    public static void printMin(int[] a) {
        printMinHelper(a, 0, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,4,-1,-2,-5};
        int min = getMin(a);
        System.out.println(min);
        System.out.println("++++++");

        printMin(a);
    }
}
