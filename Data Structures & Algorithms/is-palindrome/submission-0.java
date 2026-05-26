class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        char[] charArray = s.toCharArray();

        for(int i = 0, j = s.length()-1;  i <=j ; i++, j--) {
            System.out.println(charArray[i] + "!=" + charArray[j]);
            if(Character.toLowerCase(charArray[i]) != Character.toLowerCase(charArray[j])) return false;
        }
        return true;
    }
}
