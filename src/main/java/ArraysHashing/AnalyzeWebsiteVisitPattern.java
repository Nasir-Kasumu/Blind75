package ArraysHashing;
// AMZ questions to ask
// are the timestamps sorted?
// what format will the timestamps be in?
// do the user visit patterns need to be one after another
// will the case matter for usernames
/*
pattern list of 3 websites
score of pattern number of users that duplicated that pattern in the same order

store all patterns?

return lexographically smallest pattern if there is a tie

["joe","joe","joe","james","james","james","james","mary","mary","mary"]
[1,2,3,4,5,6,7,8,9,10]
["home","about","career","home","cart","maps","home","home","about","career"]
                                                      *
joe[home,about,career]

james[home,cart,maps,home]

mary[home,about,career]

Output: ["home","about","career"]

joe & mary: (home about career)

james: (home,cart,maps)
james: (home, maps, home)
james: (home, cart, home)
james: (cart,maps,home)

split each user/website into  different arrays
return a list of all patterns from that user?
increment number of matching patterns in a hash
return the most matching patterns and sort the lex one

hashmap key: username, value: list<String [patterns]>
create a set of users
use that set to create distinct arrays of user activity
store those arrays into a hashmap
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AnalyzeWebsiteVisitPattern {

    HashMap<String, List<ArrayList<String>>> patternMap = new HashMap<String,List<ArrayList<String>>>();

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        sortTimeStamps(username,timestamp,website);
        HashSet<String> userSet = new HashSet<String>();
        HashMap<String,ArrayList<String>> activityMap = new HashMap<String,ArrayList<String>>();
        HashMap<ArrayList<String>,Integer> countMap = new HashMap<ArrayList<String>,Integer>();
        List<List<String>> maxList = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < username.length; i++){
            userSet.add(username[i]);
        }
        for(String s : userSet){
            List<ArrayList<String>> l = new ArrayList<>();
            ArrayList<String> temp = new ArrayList<String>();
            ArrayList<String> activity = buildActivity(s,website,username);
            activityMap.put(s,activity);
            patternMap.put(s,l);
        }

        for(String s : activityMap.keySet()){
            //System.out.println(s + ":" + activityMap.get(s).toString());
            dfs(activityMap.get(s),s);
        }
        for(String s : patternMap.keySet()){
            List<ArrayList<String>> temp = patternMap.get(s);
            for(int i = 0; i < temp.size(); i++){
                ArrayList<String> curr = temp.get(i);
                if(countMap.containsKey(curr)){
                    countMap.put(curr, countMap.get(curr) + 1);
                }else{
                    countMap.put(curr,1);
                }
            }
            //System.out.println(s + ":" + patternMap.get(s).toString());
        }

        int max = 0;
        for(ArrayList<String> list : countMap.keySet()){
            if(countMap.get(list) > max){
                max = countMap.get(list);
                res = list;
            }
        }

        for(ArrayList<String> list : countMap.keySet()){
            if(countMap.get(list) == max){
                maxList.add(list);
            }
        }

        //Collections.sort(maxList);
        //System.out.println(maxList.get(0));
        String [] words = lexSort(maxList);
        //System.out.println(Arrays.toString(words));
        for(int i = 0; i < maxList.size(); i++){
            List<String> tempList = maxList.get(i);
            String curr = "";
            for(int j = 0; j < tempList.size(); j++){
                curr += tempList.get(j);
            }
            if(curr.equals(words[0])){
                return tempList;
            }
        }
        return res;
    }

    public String [] lexSort(List<List<String>> maxList){
        String[] words = new String [maxList.size()];
        int count = 0;
        for(int i = 0; i < maxList.size(); i++){
            String curr = "";
            List<String> tempList = maxList.get(i);
            for(int j = 0; j < tempList.size(); j++){
                curr += tempList.get(j);
            }
            //System.out.println(curr);
            words[count] = curr;
            count++;
        }
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[i].compareTo(words[j]) > 0){
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        return words;
    }

    public void sortTimeStamps(String [] username, int [] timestamp, String [] website){
        for(int i = 0; i < timestamp.length; i++){
            for(int j = i + 1; j < timestamp.length; j++){
                if(timestamp[i] > timestamp[j]){
                    swap(username,i,j);
                    swapInt(timestamp,i,j);
                    swap(website,i,j);
                }
            }
        }
    }

    public void swapInt(int [] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public void swap(String [] input, int a, int b){
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public void dfs(ArrayList<String> activity, String user){
        for(int i = 0; i < activity.size(); i++){
            for(int j = i + 1; j < activity.size(); j++){
                for(int x = j + 1; x < activity.size(); x++){
                    if(x > j && j > i){
                        ArrayList<String> temp = new ArrayList<String>();
                        List<ArrayList<String>> curr = patternMap.get(user);
                        temp.add(activity.get(i));
                        temp.add(activity.get(j));
                        temp.add(activity.get(x));
                        if(!curr.contains(temp)){
                            curr.add(temp);
                            patternMap.put(user,curr);
                        }
                    }
                }
            }
        }
    }

    public ArrayList<String> buildActivity(String userName, String [] website, String [] users){
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i < website.length; i++){
            if(userName.equals(users[i])){
                res.add(website[i]);
            }
        }
        return res;
    }
}
