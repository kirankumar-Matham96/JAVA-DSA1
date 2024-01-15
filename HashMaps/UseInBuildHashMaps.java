package HashMaps;

import java.util.*;
//import java.util.HashMap;

public class UseInBuildHashMaps {

    static int longestSubArraySumsZero(int arr[], int N)
    {
        int max_len = 0;

        // Pick a starting point
        for (int i = 0; i < N; i++) {

            // Initialize curr_sum for every
            // starting point
            int curr_sum = 0;

            // try all subarrays starting with 'i'
            for (int j = i; j < N; j++) {
                curr_sum += arr[j];

                // If curr_sum becomes 0, then update
                // max_len
                if (curr_sum == 0)
                    max_len = Math.max(max_len, j - i + 1);
            }
        }
        return max_len;
    }

    static ArrayList<Integer> printLongestConseqSubseq(int arr[], int n) {
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;
        int start = -1; // starting element of the longest consecutive sequence

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1)) {
                int j = arr[i];
                while (S.contains(j)) {
                    S.remove(j);
                    j++;
                }

                // update optimal length if this
                // length is more
                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                    start = arr[i];
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Print the sorted consecutive sequence
        if (start != -1) {
            List<Integer> sequence = new ArrayList<>();
            for (int i = 0; i < ans; i++) {
                sequence.add(start + i);
            }

            Collections.sort(sequence);

            System.out.print("Longest consecutive sequence: ");
            for (int i = 0; i < sequence.size(); i++ ) {
                if(i == 0 || i == sequence.size()-1){
                    result.add(sequence.get(i));
                }
                System.out.print(sequence.get(i) + " ");
            }
            System.out.println();
        }
        return result;
    }

    static int findLongestConseqSubseqCount(int arr[], int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1)) {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (S.contains(j)){
                    S.remove(Integer.valueOf(j));//this will improve runtime by avoiding the repetitive counts of elements
                    j++;
                }

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    public static void printDiffPairs(int arr[], int n, int dif)
    {

        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        // Traverse through all elements
        for (int i = 0; i < n; i++) {

            // Search if a pair can be formed with
            // arr[i].
            int rem = dif + arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);

                for (int j = 0; j < count; j++)
                    System.out.print("(" + rem + ", "
                            + arr[i] + ")"
                            + "\n");
            }
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else {
                mp.put(arr[i], 1);
            }
        }
    }

    public static void printPairs(int arr[], int n, int sum)
    {

        // Store counts of all elements in map m
        HashMap<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        // Traverse through all elements
        for (int i = 0; i < n; i++) {

            // Search if a pair can be formed with
            // arr[i].
            int rem = sum - arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);

                for (int j = 0; j < count; j++)
                    System.out.print("(" + rem + ", "
                            + arr[i] + ")"
                            + "\n");
            }
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else {
                mp.put(arr[i], 1);
            }
        }
    }

    public static int pairSum(int[] input, int size) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < size; i++) {
            // k = input[i] for sum up to k
            if (m.containsKey(-input[i])) {
                count += m.get(-input[i]);
            }
            if (m.containsKey(input[i])) {
                m.put(input[i], m.get(input[i]) + 1);
            }
            else {
                m.put(input[i], 1);
            }
        }
        return count;
    }

    public static void intersectionOfYwoArrays(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: arr1){
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }

        for (int i: arr2){
            if(map.containsKey(i) && map.get(i) > 0){
                System.out.print(i+" ");
                map.put(i, map.get(i)-1);
            }
        }

//        for (int key: map.keySet()){
//            System.out.println(key+" = "+map.get(key));
//        }
    }

    public static void maxFrequencyNumber(int[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (!map.containsKey(String.valueOf(i))) {
                map.put(String.valueOf(i), 1);
            } else {
                map.put(String.valueOf(i), map.get(String.valueOf(i)) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        String maxKey = "";

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
            if(max < map.get(key)){
                max = map.get(key);
                maxKey = key;
            }
        }

        System.out.println("maximum frequency number is: "+maxKey);
    }

    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        // remove duplicates
        HashMap<String, Integer> map = new HashMap<>();

        for (int i: arr){
            if(!map.containsKey(i+"")){
                map.put(i+"", i);
            }
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        for(String i: map.keySet()){
            resultList.add(map.get(i));
        }

        return resultList;
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,2,3,4,5,5,6,6,6,6,7,7,7,7,2,3,1,4};
//
//        ArrayList<Integer> aList = removeDuplicates(arr);
//
//        for (int i: aList){
//            System.out.println(i);
//        }
//
//        // highest frequency number
//        System.out.println(" ============ ");
//        int[] arr2 = {1,2,3,4,1,2,3,4,5,6,7,8,9,6,7,3,4,1,1,9,9,9,9,9,9,9,8,8,8,8,8,8,8};
//        maxFrequencyNumber(arr2);

//        int[] arr1 = {1,3,2,2,3,6,2,5};
//        int[] arr2 = {2,4,2,3,5,6,6};
//        intersectionOfYwoArrays(arr1,arr2);

//        int[] arr3 = {-2, 2, 6, -2, 2, -6, 3};
//        System.out.println(pairSum(arr3, arr3.length));
//        System.out.println(427%26);
        int[] arr = {5, 1, 2, 4};
        System.out.println("sum: ");
        printPairs(arr, arr.length, 3);
        System.out.println("Diff: ");
        printDiffPairs(arr, arr.length, 3);
        int[] arr4 = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};
        System.out.println("\ncount: "+findLongestConseqSubseqCount(arr4,arr4.length));

        System.out.println("start and end: "+printLongestConseqSubseq(arr4, arr4.length));

        int[] arr5 = {95,-97,-387,-435,-5,-70,897,127,23,284};
        System.out.println("\nlongest sub array length: "+longestSubArraySumsZero(arr5, arr5.length));
    }
}
