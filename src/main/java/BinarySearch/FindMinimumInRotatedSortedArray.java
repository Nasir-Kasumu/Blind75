package BinarySearch;
/*

[3,4,5,1,2]
       s
       m
          e

s = 3
m = 3
e = 4

test with nums[mid] < nums[start] vs nums[mid] < nums[0]
[4,5,6,7,0,1,2]
         s
           m
              e
s = 4
m = 4
e = 4
*/
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return nums[findPivot(nums)];
    }

    public int findPivot(int [] nums){
        int start = 0;
        int end = nums.length - 1;
        int mid = end / 2;

        while(start <= end){
            mid = start + (end - start) / 2;
            System.out.println(start + ":" + mid + ":" + end);
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return mid;
            }else if(nums[mid] < nums[0]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return 0;
    }
}
