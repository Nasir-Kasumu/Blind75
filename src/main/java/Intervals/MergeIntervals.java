package Intervals;

import java.util.PriorityQueue;
import java.util.Stack;

//class C implements Comparator<int[]> {
//    public int compare(int [] a, int [] b){
//        if(a[0] > b[0]){
//            return 1;
//        }if(a[0] < b[0]){
//            return -1;
//        }
//        return 0;
//    }
//}
/*
Same algorithm as insert interval
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new C());
        Stack<int[]> st = new Stack<int[]>();
        for(int i = 0; i < intervals.length; i++){
            pq.add(intervals[i]);
        }

        st.push(pq.poll());
        while(!pq.isEmpty()){
            int [] curr = st.peek();
            int [] nex = pq.poll();
            if(curr[1] >= nex[0] || curr[1] >= nex[1]){
                //System.out.println("overlap");
                int [] temp = merge(curr,nex);
                st.pop();
                st.push(temp);
            }
            else{
                st.push(nex);
            }
        }

        int [] [] res = new int [st.size()] [2];
        int count = st.size() - 1;
        while(!st.isEmpty()){
            res[count] = st.pop();
            count--;
        }
        return res;
    }

    public int [] merge(int [] a, int [] b){
        int [] temp = new int [] {Math.min(a[0],b[0]),Math.max(a[1],b[1])};
        return temp;
    }
}
