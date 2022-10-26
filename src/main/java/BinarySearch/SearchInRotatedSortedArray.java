package BinarySearch;
/*
find the pivot point?
run binary search on the left and right subarrays
[4,5,6,7,0,1,2]


[2,4,5,6,7,0,1]
         s
           m
         e
s = 4;
e = 4;
mid = 4;
-----------------------------

[4,5,6,7,0,1,2]
         s
           m
             e

s = 0;
e = 6;
mid = 3;
-------------------------------
[3,1]
 s
 m
   e

s = 0
e = 1
m = 0
*/
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums,target);
        int res = -1;
        if(pivot == -1){
            return -1;
        }
        if(pivot == 0){
            res = binSearch(nums,target,0,nums.length - 1);
        }
        else if(nums[0] <= target && target <= nums[pivot - 1]){
            res = binSearch(nums,target,0,pivot);
        }else{
            res = binSearch(nums,target,pivot,nums.length -1);
        }


        return res;
    }

    public int findPivot(int [] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return mid;
            }
            else if(nums[mid] < nums[0]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return 0;
    }

    public int binSearch(int [] nums, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
