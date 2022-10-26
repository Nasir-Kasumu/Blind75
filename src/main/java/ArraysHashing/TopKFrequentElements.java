package ArraysHashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class C implements Comparator<int []> {
        public int compare(int [] a, int [] b){
            if(a[1] > b[1]){
                return -1;
            }
            if(a[1] < b[1]){
                return 1;
            }
            return 0;
        }
    }


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = mapify(nums);
        PriorityQueue<int []> pq = new PriorityQueue<int []>(new C());
        int [] res = new int [k];
        int count = 0;
        for(int i : map.keySet()){
            int [] temp = new int [] {i,map.get(i)};
            pq.add(temp);
        }

        while(k > 0){
            k--;
            res[count] = pq.poll()[0];
            count++;
        }
        return res;
    }

    public HashMap<Integer,Integer> mapify(int [] nums){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) + 1);
            }else{
                map.put(curr,1);
            }
        }
        return map;
    }
}

