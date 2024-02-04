package Backtrack;

import java.util.*;

public class PalindromPartition {
    public static boolean checkPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }

    // Recursive funtion which takes index ind and generates all substrings starting at ind.
    // if substring generated is palindrome it adds to current list and makes a recursive call for remaining string

    public static List<List<String>> partition(List<List<String>> result, String s, int ind, List<String> curr) {
        if (ind == s.length()) {
            result.add(new ArrayList<String>(curr));
            return result; // Fix here
        }

        String temp = "";

        for (int i = ind; i < s.length(); i++) {
            temp += s.charAt(i);

            if (checkPalindrome(temp)) {
                curr.add(temp);
                partition(result, s, i+1, curr);
                curr.remove(curr.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // creating obj of GFG class

        // Stores all partitions generated at the end
        List<List<String>> res = new ArrayList<>();

        String s = "aaC";

        int ind = 0;

        // Store the partition at current iteration
        List<String> curr = new ArrayList<>();

        // calling funtion to get partition
        List<List<String>> newRes = partition(res, s, ind, curr);

        for(List<String> iter : newRes) {
            System.out.println(iter);
        }
    }
}
