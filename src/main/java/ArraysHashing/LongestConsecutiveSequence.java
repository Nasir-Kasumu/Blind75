package ArraysHashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int i : set){
            if(!set.contains(i - 1)){
                int count = 1;
                while(set.contains(i + 1)){
                    count++;
                    i++;
                }
                if(count > max){
                    max = count;
                }
            }
        }
        return max;
    }
}
