package SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int l = 0;
        int r = l + 1;
        int maxLength = 1;
        HashSet<Character> charSeen = new HashSet<Character>();
        charSeen.add(s.charAt(l));

        while(l <= r && r < s.length() && l < s.length()){
            Character curr = s.charAt(r);
            if(charSeen.contains(curr)){
                while(charSeen.contains(curr)){
                    charSeen.remove(s.charAt(l));
                    l++;
                }
            }else{
                charSeen.add(curr);
                maxLength = Math.max(charSeen.size(), maxLength);
                r++;
            }
        }
        return maxLength;
    }
}
