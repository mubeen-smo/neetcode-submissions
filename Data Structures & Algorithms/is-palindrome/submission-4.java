class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i <= j) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if(!isAlphaNum(l)) i++;
            else if(!isAlphaNum(r)) j--;
            else {
                if(!(Character.toLowerCase(l) == Character.toLowerCase(r))) return false;
                i++; j--;
            }
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
        return false;
    }
}
