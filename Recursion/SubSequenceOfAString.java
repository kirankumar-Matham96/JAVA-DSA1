package Recursion;

import java.util.ArrayList;

public class SubSequenceOfAString {

    public static void printSubSequenceHelper(String s, String strSoFar) {
        if(s.length() == 0){
            System.out.println(strSoFar);
            return;
        }

        printSubSequenceHelper(s.substring(1), strSoFar + s.charAt(0));
        printSubSequenceHelper(s.substring(1), strSoFar);
    }
    public static void printSubSequence(String str) {
        printSubSequenceHelper(str, "");
    }
    public static String[] subSequence(String str) {
        if(str.isEmpty()){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = subSequence(str.substring(1));
        String[] output = new String[2*smallOutput.length];

        int i = 0;
        for(String s: smallOutput){
            output[i] = s;
            i++;
            output[i] = str.charAt(0)+s;
            i++;
        }

        return output;
    }

    public static void main(String[] args) {
        String[] arr;
        System.out.println("Hi");
        arr = subSequence("abc");
        for (String i : arr){
            System.out.println(i);
        }
        System.out.println("Next");
        printSubSequence("abc");
    }
}
