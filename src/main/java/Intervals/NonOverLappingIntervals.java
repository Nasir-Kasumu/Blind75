package Intervals;

import java.util.PriorityQueue;
import java.util.Stack;

/*
similar algorithm to insert interval except we take a greedy approach
if two intervals overlap you remove the interval that ends later and increment count
by doing this you reduce the chance of that interval overlapping with another
i.e
[1,2][1,3][2,3][3,4]
when comparing [1,2] & [1,3]
    we remove [1,3] because the ending value is greater than [1,2]'s

 */
public class NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new C());
        Stack<int[]> st = new Stack<int[]>();

        int count = 0;

        for(int i = 0; i < intervals.length; i++){
            pq.add(intervals[i]);
        }
        st.push(pq.poll());

        while(!pq.isEmpty()){
            int [] curr = st.peek();
            int [] nex = pq.poll();
            if(curr[1] > nex[0] || curr[1] > nex[1]){// if overlap remove the one that ends later
                if(curr[1] > nex[1]){
                    st.pop();
                    st.push(nex);
                }
                count++;
            }else{
                st.push(nex);
            }
        }
        return count;
    }
}
