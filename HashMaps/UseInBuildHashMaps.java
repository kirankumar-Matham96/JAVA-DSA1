package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class UseInBuildHashMaps {

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

        int[] arr3 = {-2, 2, 6, -2, 2, -6, 3};
        System.out.println(pairSum(arr3, arr3.length));
        System.out.println(427%26);
    }
}
