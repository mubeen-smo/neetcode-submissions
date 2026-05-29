class Solution {
    public boolean isPalindrome(String s) {
        
        int l = 0, r = s.length()-1; 

        while(l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if(isAlphaNum(left) && isAlphaNum(right)) {
                if(Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }
                l++; r--;
            }
            if(!isAlphaNum(left)) l++;
            if(!isAlphaNum(right)) r--;
        }

        return true;

    }
    public boolean isAlphaNum(char c) {
        if( (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || ( c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
