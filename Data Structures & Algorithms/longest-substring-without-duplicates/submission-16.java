class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Set<Character> charSet = new HashSet<>();
        int longest = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while(charSet.contains(c)) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(c);
                            longest = Math.max(longest, r - l +1);

        }
        return longest;
    }
}
