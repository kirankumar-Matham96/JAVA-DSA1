public class KepPadCombinations {
    static String[] keypad = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void possibilities(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        String key = keypad[str.charAt(0) - 48];

    }

    public static void main(String[] args) {
        possibilities("23", "");
    }
}
