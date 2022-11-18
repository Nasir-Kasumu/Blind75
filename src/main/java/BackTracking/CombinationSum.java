package BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
use a loop to recursively add values to a list
updating the index value recursively is important to ensure there are no duplicates
you cannot add curr to the list of lists directly you must add like below
ArrayList<Integer> list = new ArrayList<Integer>(curr)
listoflists.add(list)
backtracking is important here after each dfs call you must
list.remove(Integer.valueOf(cand[index]))
subtracting from target is an easy way to keep track of you far you've gone
index value should be updated in the for loop and the dfs call
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        dfs(candidates,target,0,curr,res);

        return res;
    }

    public void dfs(int [] candidates, int target, int index, ArrayList<Integer> curr, List<List<Integer>> res){
        if(target < 0){
            return;
        }

        if(target == 0){
            ArrayList<Integer> temp = new ArrayList<Integer>(curr);
            res.add(temp);
        }

        for(int i = index; i < candidates.length; i++){
            if(target > 0){
                curr.add(candidates[i]);
                dfs(candidates,target - candidates[i], i, curr, res);
                curr.remove(Integer.valueOf(candidates[i]));
            }
        }
    }
}
