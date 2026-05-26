class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int size = s.length();

        int l = 0;
        int longest = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int r = 0; r < size; r++) {
            char c = s.charAt(r);
            if(mp.containsKey(c)) {
                l = Math.max(mp.get(c) + 1, l);
            }
            int currLength = r - l + 1;
            longest = Math.max(currLength, longest);
            mp.put(s.charAt(r),r);
        }

        return longest;
    }
}
