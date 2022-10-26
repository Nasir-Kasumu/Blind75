package ArraysHashing;

import java.util.Arrays;

/*
[1,2,3,4]
pre - (1) [1,2,6,24]

reverse postfix array
post - [24,24,12,4] (1)
        *
res -  [(1*24),(1*12),(2*4),(6*1)]
res -  [24,12,8,6]
take value right before and multiple by value right after to get value at index
if we are at i
val = pre[i - 1] * post[i + 1]
 */
public class ProductOfArrayExceptItself {
    public static int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        int [] res = new int [nums.length];
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            curr = curr * nums[i];
            pre[i] = curr;
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            curr = curr * nums[i];
            post[i] = curr;
        }

        for(int i = 0; i < nums.length; i++){
            int currVal = 1;
            if(i == 0){
                currVal = currVal * post[i + 1];
            }else if(i == nums.length - 1){
                currVal = currVal * pre[i - 1];
            }else{
                currVal = pre[i - 1] * post[i + 1];
            }
            res[i] = currVal;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 3, 4};
        productExceptSelf(temp);
    }
}


