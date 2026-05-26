class Solution {
    public String minWindow(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();

        if(tSize > sSize) return "";

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c,0) + 1);
        }

        int have = 0, 
            need = tCount.size(), 
            start = 0, 
            resLen = Integer.MAX_VALUE, l = 0;

        for(int r = 0; r < sSize; r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);

            if(tCount.containsKey(c) && window.get(c).equals(tCount.get(c))) {
                have++;
            }

            while(have == need) {
                int currLen = r - l + 1;

                if(currLen < resLen) {
                    resLen = currLen;
                    start = l;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
        
        
    }
}
