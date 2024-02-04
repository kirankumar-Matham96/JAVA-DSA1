package Recursion;

public class keyPadCombinations {
    public static String getKeypadString(int i) {
        String[] a = {" ", ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return a[i];
    }

    public static void printKeypadCombinationsHelper(int num, String strSoFar) {
        if(num == 0) {
            System.out.println(strSoFar);
            return;
        }

        int lastDigit = num%10;
        int remainingNum = num/10;

        String options = getKeypadString(lastDigit);

        for (int i = 0; i < options.length(); i++) {
            printKeypadCombinationsHelper(remainingNum, options.charAt(i) + strSoFar);
        }


    }
    public static void printKeypadCombinations(int n) {
        printKeypadCombinationsHelper(n, "");
    }

    public static String[] getKeypadCombinations(int n) {
        if(n == 0){
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = getKeypadCombinations(n/10);
        int lastDigit = n%10;
        String possibleChars = getKeypadString(lastDigit);

        String[] output = new String[smallOutput.length * possibleChars.length()];

        int k = 0;
        for (String s: smallOutput){
            for (int i = 0; i < possibleChars.length(); i++){
                output[k] = s + possibleChars.charAt(i);
                k++;

            }
        }
        return output;
    }

    public static void main(String[] args) {
        String[] arr = getKeypadCombinations(22);
        for (String s: arr){
            System.out.println(s);
        }
        System.out.println("\n+++++++ New +++++++\n");
        printKeypadCombinations(22);
    }
}
