class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Sorting is extremely cache-friendly and uses primitive types
        Arrays.sort(nums);

        int longest = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Skip duplicates naturally
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longest = Math.max(longest, currentStreak);
                    currentStreak = 1; // Reset streak
                }
            }
        }

        return Math.max(longest, currentStreak);
    }
}
