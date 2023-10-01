public class RemoveCharFromString {
    public static String removeX(String input) {
        if(input.length() == 0){
			return input;
		}

		String small = "";

		if(input.charAt(0) == 'x'){
			small += removeX(input.substring(1));
		}else{
			small += input.charAt(0) + removeX(input.substring(1));
		}

		return small;
    }
    public static void main(String[] args) {
        System.out.println(removeX("papax"));        
    }
}
