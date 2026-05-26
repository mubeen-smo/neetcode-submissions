class Solution {
    public int maxArea(int[] heights) {
        int maxAmount = 0, l = 0, r = heights.length - 1;

        while( l < r) {
            int currAmount = Math.min(heights[l], heights[r])*(r-l);
            System.out.println(currAmount);
            if(maxAmount < currAmount ) maxAmount = currAmount;
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxAmount;
    }
}
