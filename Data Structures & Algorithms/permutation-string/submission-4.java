class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        
        int fullLength = s2.length();
        int checkLength = s1.length();

        for(int i = 0; i < fullLength; i++) {
           int j = i + checkLength;
           
           if(j <= fullLength) {
            String checkString = s2.substring(i, j);
            String s = s1;
            
            System.out.println(checkString);
            int k = 0;
            if(isAnagram(s1,checkString)) return true;
           }
        }
        return false;
    }

    private boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        int l = s.length();
        if(l != t.length()) {
            return false;
        }
        for(int i = 0; i < l; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int n: count) {
            if(n != 0) return false;
        }
        return true;
    }
}
