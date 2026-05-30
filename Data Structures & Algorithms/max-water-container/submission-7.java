class Solution {
    public int maxArea(int[] heights) {
        

        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while(l < r) {
            int currArea = (r-l) * Math.min(heights[r],heights[l]);
            if(heights[l] < heights[r]) l++;
            else r--;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}
