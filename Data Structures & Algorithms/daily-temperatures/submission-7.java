class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            int t = temperatures[i];
            for(int j = i+1; j < n; j++) {
                if(temperatures[j] > t) {
                    result[i] = j - i;
                    break;
                }
            } 
        }
        return result;
    }
}
