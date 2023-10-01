public class ReplacePiInString {
    public static String replacePI(String str) {
        if(str.length() <= 1){
            return str;
        }

        if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            String small = replacePI(str.substring(2));
            return "3.14" + small;
        }else{
            String small = replacePI(str.substring(1));
            return str.charAt(0) + small;
        }
    }

    public static void main(String[] args) {
        System.out.println(replacePI("ppihapihahapiiipi"));
    }
}
