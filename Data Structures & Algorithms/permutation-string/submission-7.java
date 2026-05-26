class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i < 26; i++ ) {
            if(s1Count[i] == window[i]) matches++;
        }
        if(matches == 26) return true;

        for(int r = len1; r < len2; r++) {
            int add = s2.charAt(r) - 'a';
            int rem = s2.charAt(r - len1) - 'a';

            if(window[add] == s1Count[add]) matches--;
            window[add]++;
            if(window[add] == s1Count[add]) matches++;

            if(window[rem] == s1Count[rem]) matches--;
            window[rem]--;
            if(window[rem] == s1Count[rem]) matches++;
            if(matches == 26) return true;
        }
        return false;
    }
}
