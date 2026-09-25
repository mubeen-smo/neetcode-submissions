class Solution {
    public int characterReplacement(String s, int k) {
        
        int longest = 0;

        int size = s.length();

        int l = 0;
        int maxFreqInWindow = 0;

        Map<Character, Integer> fMap = new HashMap<>();

        for(int r = 0; r < size; r++) {
            char c = s.charAt(r);
            fMap.put(c, fMap.getOrDefault(c, 0) + 1);

            maxFreqInWindow = Math.max(fMap.get(c), maxFreqInWindow);

            int window = r - l + 1;
            if( r - l + 1 - maxFreqInWindow > k) {
                fMap.put(s.charAt(l), fMap.getOrDefault(s.charAt(l), 0) - 1);
                l++;
                window = r - l + 1;
            }
            longest = Math.max(longest, window);
        }

        return longest;
    }
}
