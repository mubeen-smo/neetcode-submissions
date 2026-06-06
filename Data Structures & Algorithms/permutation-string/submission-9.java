class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2 ) return false;
        int matches = 0;
        int[] count = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i] == window[i]) matches++;
        }
        if(matches == 26) return true;
        for(int l = 0, r = len1; r < len2; r++, l++) {
            int add = s2.charAt(r) - 'a';
            int rem = s2.charAt(l) - 'a';
            if(add == rem) continue;
            if(count[add] == window[add]) matches--;
            window[add]++;
            if(count[add] == window[add]) matches++;

            if(count[rem] == window[rem]) matches--;
            window[rem]--;
            if(count[rem] == window[rem]) matches++;
            if(matches == 26) return true;
        }
        return false;
    }
}
