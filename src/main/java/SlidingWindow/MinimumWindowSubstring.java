package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> sMap = new HashMap<Character,Integer>();
        int l = 0;
        int r = l + 1;
        int minVal = Integer.MAX_VALUE;
        sMap.put(s.charAt(l), 1);
        String minString = "";
        for(int i = 0; i < t.length(); i++){
            Character curr = t.charAt(i);
            if(tMap.containsKey(curr)){
                tMap.put(curr, tMap.get(curr) + 1);
            }else{
                tMap.put(curr,1);
            }
        }

        while(r < s.length()){
            Character curr = s.charAt(r);

            if(minVal > (r - l) && containsSub(sMap,tMap)){
                minVal = r - l;
                minString = s.substring(l,r);
                //System.out.println(minString + ":" + minVal);
            }


            if(containsSub(sMap,tMap)){
                while(containsSub(sMap,tMap)){
                    if(sMap.get(s.charAt(l)) > 1){
                        sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                    }else{
                        sMap.remove(s.charAt(l));
                    }
                    l++;
                    if(minVal > (r - l) && containsSub(sMap,tMap)){
                        minVal = r - l;
                        minString = s.substring(l,r);
                        //System.out.println(minString + ":" + minVal);
                    }
                }
            }else{
                if(sMap.containsKey(curr)){
                    sMap.put(curr, sMap.get(curr) + 1);
                }else{
                    sMap.put(curr, 1);
                }
                r++;
            }

            if(minVal > (r - l) && containsSub(sMap,tMap)){
                minVal = r - l;
                minString = s.substring(l,r);
            }
        }

        if(containsSub(sMap,tMap)){
            while(containsSub(sMap,tMap)){
                if((minVal > (r - l)) && containsSub(sMap,tMap)){
                    minVal = r - l;
                    minString = s.substring(l,r);

                }
                if(sMap.get(s.charAt(l)) > 1){
                    sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                }else{
                    sMap.remove(s.charAt(l));
                }

                l++;
            }
        }


        return minString;
    }

    public boolean containsSub(HashMap<Character,Integer> bigMap, HashMap<Character,Integer> subMap){
        for(Character c : subMap.keySet()){
            if(bigMap.get(c) == null){
                return false;
            }
            if(bigMap.get(c) < subMap.get(c)){
                return false;
            }

        }
        return true;
    }
}
