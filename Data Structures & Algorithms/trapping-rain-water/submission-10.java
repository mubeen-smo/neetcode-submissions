class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0; // A minimum of 3 bars are needed to trap any water

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // 1. Populate leftMax (independent loop)
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }

        // 2. Populate rightMax (independent loop)
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j+1]);
        }

        int totalWater = 0;

        // 3. Calculate water at each place
        for (int i = 1; i < n - 1; i++) {
            int waterAtOnePlace = Math.min(leftMax[i], rightMax[i]) - height[i];
            totalWater += waterAtOnePlace > 0 ? waterAtOnePlace : 0;
        }

        return totalWater;
    }
}
