class Solution {
    public int trap(int[] height) {
        
        int l = height.length;
        int[] maxLeft = new int[l];
        int[] maxRight = new int[l];
        
        for(int i = 2, j = l-3; i < height.length; i++,j--) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
            maxRight[j] = Math.max(maxRight[j+1], height[j+1]);
        }
        for(int i = 0, j = l-1; i < l; i++, j--) {
            if(i > 0 && j < l-1) {
                maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
                maxRight[j] = Math.max(maxRight[j+1], height[j+1]);
            }
        }
        int area = 0;
        int difference = 0;
        for(int i = 0; i < l; i++) {
            difference = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(difference > 0) area += difference;
            System.out.println(area);
        }
        return area;
    }
}
