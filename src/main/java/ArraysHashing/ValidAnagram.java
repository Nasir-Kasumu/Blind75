package ArraysHashing;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t){
        return mapify(s).equals(mapify(t));
    }

    public HashMap<Character,Integer> mapify(String in){
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < in.length(); i++){
            if(map.containsKey(in.charAt(i))){
                map.put(in.charAt(i), map.get(in.charAt(i)) + 1);
            }
            else{
                map.put(in.charAt(i), 1);
            }
        }
        return map;
    }
}
