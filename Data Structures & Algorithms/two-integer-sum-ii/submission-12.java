class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int l = 0, r = size-1;

        while (l < r) {
            int currentSum = numbers[l] + numbers[r];

            if(currentSum == target) {
                return new int[]{l+1, r+1};
            }
            else if(currentSum < target) {
                l++;
            } else {
                r--;
            }
        }
        
       
        return new int[]{};
    }
}
