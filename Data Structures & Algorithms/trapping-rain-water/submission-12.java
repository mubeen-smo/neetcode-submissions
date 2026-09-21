class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if(size < 2) return 0;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        for(int i = 1; i < size; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        for(int j = size - 2; j > 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
        }
        int totalWater = 0;
        for(int i = 1; i < size; i++) {
            int diff = Math.min(leftMax[i], rightMax[i]) - height[i];
            totalWater += diff > 0 ? diff : 0;
        }

        return totalWater;
    }
}
