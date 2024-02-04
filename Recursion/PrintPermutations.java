package Recursion;

public class PrintPermutations {

    public static void printPermutationsHelper(String s, String strSoFar) {
        if(s.length() == 0){
            System.out.println(strSoFar);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String smallerString = s.substring(0,i) + s.substring(i+1);
            printPermutationsHelper(smallerString, strSoFar+s.charAt(i));
        }
    }

    public static void printPermutations(String s) {
        printPermutationsHelper(s, "");
    }

    public static void main(String[] args) {
        String s = "abc";
        printPermutations(s);
    }
}
