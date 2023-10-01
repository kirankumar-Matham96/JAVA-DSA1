public class ReplaceCharInAString {
    public static String replaceChar(String str, char a, char b) {
        if(str.length() == 0){
            return str;
        }

        String small = replaceChar(str.substring(1), a, b);

        if(str.charAt(0) == a){
            return b + small;
        }else{
            return str.charAt(0) + small;
        }
    }
    public static void main(String[] args) {
        System.out.println(replaceChar("abcdefgaaabbbserahayaraaajahagafa", 'a', 'z'));
        
    }
}
