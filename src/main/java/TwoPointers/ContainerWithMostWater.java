package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
}
