class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;

        int len = s.length();
        int[] count = new int[26];
        for(int i = 0; i < len ; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        int i = 0;
        while (i < 26) {
            if(count[i]!=0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
