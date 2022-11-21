package Intervals;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
/*
use a priority queue to sort by starting value
use a stack to hold the place of the current/most recent interval
iterate through the priority queue and if they overlap merge the values and put them in the stack
otherwise just put the value in the stack
after parsing put the values into a matrix backwards and return the matrix

merging -
in order to merge the values need to be sorted in increasing order
[a,b] <-> [c,d]
if it holds that they are sorted we merge if and only if
[b >= c or b >= d]
sorting is extremely important and simplifies the problem a lot
in order to merge we take the lowest of the two start values and the highest of the two end values and make an interval
 */
class C implements Comparator<int []> {
    public int compare(int [] a, int [] b){
        if(a[0] > b[0]){
            return 1;
        }
        if(a[0] < b[0]){
            return -1;
        }
        return 0;
    }
}

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new C());
        Stack<int[]> st = new Stack<int[]>();
        int count = 0;
        for(int i = 0; i < intervals.length; i++){
            pq.add(intervals[i]);
        }
        pq.add(newInterval);
        st.push(pq.poll());
        while(!pq.isEmpty()){
            int [] curr = st.peek();
            int [] nex = pq.poll();
            //System.out.println(Arrays.toString(curr));
            if(curr[1] >= nex[0] || curr[1] >= nex[1]){// if they overlap
                int [] temp = merge(curr,nex);
                st.pop();
                st.push(temp);
            }else{
                st.push(nex);
            }
        }
        int [] [] res = new int [st.size()][2];
        count = st.size() - 1;
        while(!st.isEmpty()){
            int [] curr = st.pop();
            //System.out.println(Arrays.toString(curr));
            res[count] = curr;
            count--;
        }

        return res;
    }

    public int [] merge(int [] a, int [] b){
        int [] temp = new int [] {Math.min(a[0],b[0]), Math.max(b[1],a[1])};
        return temp;
    }
}
