package SlidingWindow;

import java.util.HashMap;
/*
sliding window backed with a hashmap based problem where you can have at most k differing letters
traverse through string updating hashmap frequency

if the diffcount is greater than k increment r
 s = "ABAB", k = 2
      *
         *

<A:2,B:2>


s = "AABABBA", k = 1
         *
           *
<A:1, B:2>
number of unique chars? differing
if the number of groups is less than or equal to k
 */

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0){
            return 0;
        }

        HashMap<Character,Integer> freqMap = new HashMap<Character,Integer>();
        int l = 0;
        int r = l + 1;
        int res = 1;
        freqMap.put(s.charAt(l), 1);

        while(l < s.length() && r < s.length()){
            Character curr = s.charAt(r);

            if(freqMap.containsKey(curr) && maxReplace(freqMap,k,s.substring(l,r))){
                freqMap.put(curr, freqMap.get(curr) + 1);
                r++;
            }else if(maxReplace(freqMap,k,s.substring(l,r))){
                freqMap.put(curr, 1);
                r++;
            }else if(!maxReplace(freqMap,k,s.substring(l,r))){
                System.out.println("not");
                while(!maxReplace(freqMap,k,s.substring(l,r))){
                    if(freqMap.get(s.charAt(l)) > 1){
                        freqMap.put(s.charAt(l), freqMap.get(s.charAt(l)) - 1);
                    }else{
                        freqMap.remove(s.charAt(l));
                    }
                    l++;
                }
            }

            if(maxReplace(freqMap,k,s.substring(l,r))){
                res = Math.max(res, (r - l));
            }

            //System.out.println(s.substring(l,r) + ":" + res);

        }

        return res;

    }

    public boolean maxReplace(HashMap<Character,Integer> map, int k, String sub){
        int max = 0;

        for(Character c : map.keySet()){
            if(map.get(c) > max){
                max = map.get(c);
            }
        }

        int val = sub.length() - max;
        //System.out.println(sub);
        if(val > k){
            return false;
        }
        return true;
    }
}
