class Solution {
    public int characterReplacement(String s, int k) {

       int start = 0;
       int size = s.length();

       int maxFrequency = 0;
       int[] count = new int[26];
       int maxLength = 0;
       for(int end = 0; end < size; end++) {

            maxFrequency = Math.max(maxFrequency, ++count[s.charAt(end) - 'A']);

            while(end - start + 1 - maxFrequency > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
       } 
       return maxLength;
    }
}

