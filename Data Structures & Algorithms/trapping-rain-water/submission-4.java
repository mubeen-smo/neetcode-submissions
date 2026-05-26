class Solution {
    public int trap(int[] height) {

        int size = height.length;
        int[] leftMaxHeight = new int[size];
        int[] rightMaxHeight = new int[size];
        int maxArea = 0;
        for(int i=1; i < size; i++) {
            if(height[i-1] > leftMaxHeight[i-1]) {
                leftMaxHeight[i] = height[i-1];
            }
            else leftMaxHeight[i] = leftMaxHeight[i-1];
        }
        for(int i = size-2; i > 0; i--) {
            if(height[i+1] > rightMaxHeight[i+1]) {
                rightMaxHeight[i] = height[i+1];
            }
            else rightMaxHeight[i] = rightMaxHeight[i+1];
        }

        for(int i = 0; i < size; i++) {
            System.out.println(leftMaxHeight[i]);
            System.out.println(rightMaxHeight[i]);
            System.out.println(height[i]);
            int area = Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
            if(area < 0) area = 0;
            maxArea += area;
            System.out.println("Area:" + Math.min(leftMaxHeight[i], rightMaxHeight[i]) + height[i]);
        }      

        return maxArea;

    }
}
