class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int i = 0, j = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<>();

        while (j < size) {
            Character c = s.charAt(j);
            
            // If duplicate found, shrink the window from the left (i)
            // until the first occurrence of 'c' is removed from the set
            while (charSet.contains(c)) {
                charSet.remove(s.charAt(i));
                i++;
            }
            
            // Add the current character and expand the window to the right
            charSet.add(c);
            
            // Update max length at every step to catch the true longest streak
            int currStreak = j - i + 1;
            max = Math.max(currStreak, max); 
            
            j++;
        }
        return max;
    }
}
