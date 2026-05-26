class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;

        int[] need = new int[26];
        int[] win  = new int[26];

        for (int i = 0; i < m; i++) {
            need[s1.charAt(i) - 'a']++;
            win[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] == win[i]) matches++;
        }

        if (matches == 26) return true;

        for (int r = m; r < n; r++) {
            int add = s2.charAt(r) - 'a';
            int rem = s2.charAt(r - m) - 'a';

            // add char
            if (win[add] == need[add]) matches--; // will break equality
            win[add]++;
            if (win[add] == need[add]) matches++; // restored equality

            // remove char
            if (win[rem] == need[rem]) matches--;
            win[rem]--;
            if (win[rem] == need[rem]) matches++;

            if (matches == 26) return true;
        }
        return false;
    }
}