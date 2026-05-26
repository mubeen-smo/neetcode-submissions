class Solution {
    public int trap(int[] height) {
        
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        int maxArea = 0;
        for(int i = 1; i < size; i++) {
            if(height[i-1] > leftMax[i-1]) {
                leftMax[i] = height[i-1];
            }
            else leftMax[i] = leftMax[i-1];
        }

        for(int i = size-2; i >= 0; i--) {
            if(height[i+1] > rightMax[i+1]) {
                rightMax[i] = height[i+1];
            }
            else {
                rightMax[i] = rightMax[i+1];
            }
           System.out.println(rightMax[i]);

        }

        for(int i = 0; i < size; i++) {
            int area = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(area > 0) maxArea += area;
        }

        return maxArea;

    }
}
