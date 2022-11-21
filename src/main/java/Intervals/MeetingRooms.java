package Intervals;

import java.util.PriorityQueue;
import java.util.Stack;
/*
sort the values using a pq
if the values overlap i.e in a sorted list
[a,b][c,d]
if b >= c || b >= d
they overlap
return false otherwise return true
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new C());
        Stack<int[]> st = new Stack<int[]>();
        for(int i = 0; i < intervals.length; i++){
            pq.add(intervals[i]);
        }
        st.push(pq.poll());
        while(!pq.isEmpty()){
            int [] curr = st.peek();
            int [] nex = pq.poll();
            if(curr[1] > nex[0] || curr[1] > nex[1]){
                return false;
            }else{
                st.push(nex);
            }
        }
        return true;
    }
}
