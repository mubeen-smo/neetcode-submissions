class Solution {
    public int maxArea(int[] heights) {

        int size = heights.length;

        int left = 0;
        int right = size-1;
        int maxArea = 0;

        while(left < right) {

            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int currArea = Math.min(leftHeight, rightHeight)*(right - left);
            if(leftHeight < rightHeight) left++;
            else right--;
            if(currArea > maxArea) maxArea = currArea;

        }
        return maxArea;

    }
}
