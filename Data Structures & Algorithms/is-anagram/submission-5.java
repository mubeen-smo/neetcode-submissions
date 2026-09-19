class Solution {
    public boolean isAnagram(String s, String t) {

        int count[] = new int[26];

        int size = s.length();

        if(size != t.length()) return false;

        for(int i = 0; i < size; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                return false;
            }
        }
        
       return true;
    }
}
