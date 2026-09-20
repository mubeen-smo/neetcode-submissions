class Solution {
    public boolean isPalindrome(String s) {  
        int i = 0;
        int j = s.length() - 1; 
        while(i <= j) {
            char l = Character.toLowerCase(s.charAt(i));
            char r = Character.toLowerCase(s.charAt(j));
            if(!isAlphaNum(l)) {
                i++; continue;
            }
            if(!isAlphaNum(r)) {
                j--; continue;
            }
            if(l != r) return false;
            i++; j--;
        }
        return true; 
        
    }

    private boolean isAlphaNum(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
