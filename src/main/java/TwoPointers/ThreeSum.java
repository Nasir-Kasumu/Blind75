package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int s = i + 1;
            int e = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (s < e) {

                if (e < nums.length - 1 && nums[e] == nums[e + 1]) {
                    e--;
                    continue;
                }
                int total = nums[s] + nums[e] + nums[i];
                if (total == 0) {
                    //System.out.println("hit");
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    temp.add(nums[i]);
                    if (!res.contains(temp)) {
                        res.add(temp);
                    }
                    e--;
                    s++;
                } else if (total > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }

        return res;
    }
}

