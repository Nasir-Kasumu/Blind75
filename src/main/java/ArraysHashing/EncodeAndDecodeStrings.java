package ArraysHashing;

import java.util.ArrayList;

public class EncodeAndDecodeStrings {
    public String encode(ArrayList<String> in){
        String res = "";
        for(int i = 0; i < in.size(); i++) {
            res += in.get(i).length() + "*" + in.get(i);
        }
        return res;
    }

    public ArrayList<String> decode(String in){
        ArrayList<String> r = new ArrayList<String>();
        int i = 0;
        while(i < in.length()){
            String curr = "";
            int s = i;
            while(in.charAt(i) != '*'){
                i++;
            }
            int len = Integer.parseInt(in.substring(s,i));
            int end = i + len;
            i++;
            while(i <= end){
                curr += in.charAt(i);
                i++;
            }
            r.add(curr);
        }
        return r;
    }
}
