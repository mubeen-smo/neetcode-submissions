class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length()-1;

        while (l <= r) {
            char left = s.charAt(l);
            char right = s.charAt(r);
            if(!isAlphaNumeric(left)) l++;
            else if(!isAlphaNumeric(right)) r--;
            else {
                if(Character.toLowerCase(left) == Character.toLowerCase(right)) {
                    l++; r--;
                }
                else return false;
        
            }
        }
return true;

    }

    private boolean isAlphaNumeric(char c) {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            System.out.println(c);
            return true;
        }
        return false;
    }
}

