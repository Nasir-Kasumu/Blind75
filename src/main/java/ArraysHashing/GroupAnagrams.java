package ArraysHashing;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){
            String sorted = sortString(strs[i]);
            if(map.containsKey(sorted)){
                List<String> temp = map.get(sorted);
                temp.add(strs[i]);
                map.put(sorted,temp);
            }else{
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                map.put(sorted,temp);
            }
        }

        for(String s: map.keySet()){
            res.add(map.get(s));
        }

        return res;
    }

    public String sortString(String input){
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0; i < input.length(); i++){
            list.add(input.charAt(i));
        }
        Collections.sort(list);
        String res = "";
        for(int i = 0; i < list.size(); i++){
            res += list.get(i);
        }
        return res;
    }
}
