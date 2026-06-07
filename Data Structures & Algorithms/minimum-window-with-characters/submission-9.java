class Solution {
    public String minWindow(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();

        if (tSize > sSize) return "";

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int have = 0, 
            need = tCount.size(), 
            start = 0, 
            resLen = Integer.MAX_VALUE, l = 0;

        for (int r = 0; r < sSize; r++) {
            char c = s.charAt(r);
            
            // OPTIMIZATION: Only track characters that exist in t
            if (tCount.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                
                if (window.get(c).equals(tCount.get(c))) {
                    have++;
                }
            }

            while (have == need) {
                int currLen = r - l + 1;

                if (currLen < resLen) {
                    resLen = currLen;
                    start = l;
                }

                char leftChar = s.charAt(l);
                
                // OPTIMIZATION: Only process leftChar if it is part of our target
                if (tCount.containsKey(leftChar)) {
                    // Safe integer primitive comparison to avoid wrapper bugs
                    int currentCount = window.get(leftChar);
                    int requiredCount = tCount.get(leftChar);
                    
                    if (currentCount == requiredCount) {
                        have--;
                    }
                    window.put(leftChar, currentCount - 1);
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
    }
}
