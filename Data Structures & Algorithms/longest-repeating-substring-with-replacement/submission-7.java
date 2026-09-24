class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int size = s.length();
        if (size < 1) return 0;
        int l = 0;

        int mostFreqInWindow = 0;
        Map<Character, Integer> fMap = new HashMap<>();

        for (int r = 0; r < size; r++) {
            char c = s.charAt(r);
            int f = fMap.getOrDefault(c, 0) + 1;
            fMap.put(c, f);
            mostFreqInWindow = Math.max(mostFreqInWindow, f);

            // 1. If the window becomes invalid, shrink it from the left
            while ((r - l + 1) - mostFreqInWindow > k) {
                char leftChar = s.charAt(l);
                fMap.put(leftChar, fMap.get(leftChar) - 1);
                l++;
            }

            // 2. The window is guaranteed to be valid here. Update longest.
            longest = Math.max(longest, r - l + 1);
        }  

        return longest;  
    }
}
