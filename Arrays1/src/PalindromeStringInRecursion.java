public class PalindromeStringInRecursion {
    public static boolean isPalindrome(String str) {
        if(str.length() == 0 || str.length() == 1){
            return true;
        }
        if(str.charAt(0) != str.charAt(str.length()-1)){
            return false;
        }

        String smallStr = "";
        for(int i = 1; i < str.length()-2; i++){
            smallStr += str.charAt(i);
        }

        return isPalindrome(smallStr);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("abbcbba"));
        System.out.println(isPalindrome("abbabababababaaaa"));
    }
}
