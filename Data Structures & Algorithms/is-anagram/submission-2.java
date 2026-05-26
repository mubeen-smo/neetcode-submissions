class Solution {
    public boolean isAnagram(String s, String t) {
        
        int size = s.length();
        if(size != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < size ; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        int i = 0;
        while(i < 26) {
            if(count[i] != 0) return false;
            i++;
        }
        return true;
    }
}
