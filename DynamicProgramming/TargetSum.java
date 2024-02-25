package DynamicProgramming;

import java.util.*;

public class TargetSum {
    static int findTotalWays(List<Integer> arr, int i, int s, int target) {
        // If target is reached, return 1
        if (s == target && i == arr.size()) {
            return 1;
        }

        // If all elements are processed and
        // target is not reached, return 0
        if (i >= arr.size()) {
            return 0;
        }

        // Return total count of two cases:
        // 1. Consider the current element and add it to the current sum target
        // 2. Consider the current element and subtract it from the current sum.
        return findTotalWays(arr, i + 1, s + arr.get(i), target)
                + findTotalWays(arr, i + 1, s - arr.get(i), target);
    }

    // Driver Program
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);

        // target number
        int target = 3;

        System.out.println(findTotalWays(arr, 0, 0, target));
    }
}
