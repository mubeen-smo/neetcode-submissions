class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            count[a - 'a']++;
            a = t.charAt(i);
            count[a - 'a']--;
        }
        for(int n : count) {
            if(n != 0) return false;
        }
        return true;
    }
}
