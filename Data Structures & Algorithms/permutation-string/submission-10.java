class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int size = s2.length();
        int window = s1.length();
        if(window > size) return false;

        int[] count = new int[26];

        for(int i = 0; i < window; i++) {
            count[s1.charAt(i) - 'a']++;
        }

        int[] wCount = new int[26];

        int l = 0;

        for(int r = 0; r < size; r++) {
            wCount[s2.charAt(r) - 'a']++;

            if(r < window - 1) continue;
            if(countsMatch(count, wCount)) return true;
            wCount[s2.charAt(l) - 'a']--;
            l++;
        }

        return false;
    }

    private boolean countsMatch(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}


