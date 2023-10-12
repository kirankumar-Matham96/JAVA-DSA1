/**
 * ref: https://www.youtube.com/watch?v=1TGTBDWY1s4
 */
public class KepPadCombinations {
    static String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void possibilities(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        String key = keypad[str.charAt(0) - 48];

        for (int i = 0; i < key.length(); i++) {
            possibilities(str.substring(1), ans + key.charAt(i));
        }

    }

    public static void main(String[] args) {
        int x = 234;
        String s = x + "";
        possibilities(s, "");
    }
}
