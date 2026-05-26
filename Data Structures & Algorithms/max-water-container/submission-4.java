class Solution {
    public int maxArea(int[] heights) {
        
        int maxArea = 0;
        int currArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while(l < r) {
            currArea = Math.min(heights[l], heights[r])*(r-l);

            if(currArea > maxArea) maxArea = currArea;

            if(heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
