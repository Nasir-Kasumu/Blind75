package Intervals;

import java.util.Arrays;
/*
split the values into two arrays one with start values and one with end values
sort the arrays
iterate through both if starts value is less than ends value increment starts pointer and count
otherwise decrement count and increment end pointer
return count at the end
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int [] startArr = new int [intervals.length];
        int [] endArr = new int [intervals.length];
        int count = 0;
        int maxCount = 0;
        int s = 0;
        int e = 0;
        for(int i = 0; i < intervals.length; i++){
            startArr[i] = intervals[i][0];
            endArr[i] = intervals[i][1];
        }

        Arrays.sort(startArr);
        Arrays.sort(endArr);

        while(s < intervals.length && e < intervals.length){
            if(startArr[s] < endArr[e]){
                count++;
                maxCount = Math.max(count,maxCount);
                s++;
            }
            else{
                if(count != 0){
                    count--;
                }
                e++;
            }
        }

        return maxCount;
    }
}
