class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int size = s1.length();
        if(s2.length() < s1.length()) return false;

        for(int i = 0; i < s2.length(); i++) {
            int j = i + size;
            if(j <= s2.length()) {

            String checkString = s2.substring(i,j);
            if(isAnagram(checkString, s1)) return true;
            }
        }
        return false;
    }

    public boolean isAnagram(String checkString, String s1 ) {
        
        int[] charArray = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            charArray[checkString.charAt(i)- 'a']++;
            charArray[s1.charAt(i)- 'a']--;
        }

        for(int i=0; i < 26; i++) {
            if(charArray[i] != 0) return false;
        }
        return true;
    }
}
