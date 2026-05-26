class Solution {
    public String minWindow(String s, String t) {
        

        if(t.isEmpty()) return "";

        int sSize = s.length();
        int tSize = t.length();

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c,0) + 1);
        }

        int l = 0;
        int have = 0, need = tCount.size(), start = 0, resLen = Integer.MAX_VALUE;

        for(int r = 0; r < sSize ; r++) {
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

                //remove the current left character count in window and also the have and then increment left/remove from window
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
