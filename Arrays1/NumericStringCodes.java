package Arrays1;

import java.util.ArrayList;
import java.util.List;

public class NumericStringCodes {
    public static List<String> getAllCodes(String s) {
        List<String> result = new ArrayList<>();
        generateCodes(s, "", result);
        return result;
    }

    private static void generateCodes(String input, String output, List<String> result) {
        if (input.isEmpty()) {
            result.add(output);
            return;
        }

        // Take one digit as a character (a - i)
        int singleDigit = Integer.parseInt(input.substring(0, 1));
        if (singleDigit >= 1 && singleDigit <= 9) {
            char code = (char) ('a' + singleDigit - 1);
            generateCodes(input.substring(1), output + code, result);
        }

        // Take two digits as a character (j - z)
        if (input.length() >= 2) {
            int twoDigits = Integer.parseInt(input.substring(0, 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                char code = (char) ('a' + twoDigits - 1);
                generateCodes(input.substring(2), output + code, result);
            }
        }
    }

    public static void main(String[] args) {
        String input = "1123";
        List<String> codes = getAllCodes(input);

        System.out.println("Generated codes:");
        for (String code : codes) {
            System.out.println(code);
        }
    }
}
