class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Count character frequencies in t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // haves tracks how many unique characters have met their target frequency
        // needs tracks the total number of unique characters in t
        int l = 0;
        int haves = 0;
        int needs = tMap.size();
        
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            
            // Skip characters not needed by t to save time/space
            if (!tMap.containsKey(c)) continue;

            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            // If we have exactly the right amount of character 'c', increment haves
            if (windowMap.get(c).equals(tMap.get(c))) {
                haves++;
            }

            // Shrink the window from the left as long as all conditions are met
            while (haves == needs) {
                int currLength = r - l + 1;
                if (currLength < minLength) {
                    minLength = currLength;
                    startIndex = l;
                }

                char leftChar = s.charAt(l);
                if (tMap.containsKey(leftChar)) {
                    // Decrement character count from current window
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                    
                    // If the count falls below what t needs, we lose a valid match
                    if (windowMap.get(leftChar) < tMap.get(leftChar)) {
                        haves--;
                    }
                }
                l++; // Shrink window
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
