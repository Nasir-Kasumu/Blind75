package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String cleaned = clean(s);
        String reversed = rev(cleaned);
        System.out.println(cleaned + ":" + reversed);
        return reversed.equals(cleaned);
    }

    public String clean(String s){
        String out = "";
        for(int i = 0; i < s.length(); i++){
            Character curr = s.charAt(i);
            if(Character.isLetterOrDigit(curr)){
                out += Character.toLowerCase(curr);
            }
        }
        return out;
    }

    public String rev(String s){
        String res = "";
        for(int i = s.length() - 1; i >=0; i--){
            res += s.charAt(i);
        }
        return res;
    }
}
