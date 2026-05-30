class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int[] pMax = new int[size];
        int[] sMax = new int[size];

        pMax[0] = 0;
        for(int i = 1; i < size; i++) {
            pMax[i] = Math.max(pMax[i-1], height[i-1]);
        }

        sMax[size-1] = 0;
        System.out.println(size);
        for(int i = size-2; i >= 0; i--) {
            sMax[i] = Math.max(sMax[i+1], height[i+1]);
        }
        
        int resQ = 0;
        for(int i = 0; i < size; i++) {
            int currQ = Math.min(pMax[i], sMax[i]) - height[i];
            currQ = currQ < 0 ? 0 : currQ;
            resQ += currQ;
        }
        return resQ;
    }
}
