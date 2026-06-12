class Solution {
    public int characterReplacement(String s, int k) {
        
        int size = s.length();
        Map<Character,Integer> fMap = new HashMap<>();
        int maxf = 0, res = 0;
    
        for(int l = 0, r = 0; r < size ; r++) {

            Character c = s.charAt(r);
            fMap.put(c, fMap.getOrDefault(c,0)+1);

            maxf = Math.max(maxf, fMap.get(c));

            while((r - l + 1) - maxf > k) {
                Character left = s.charAt(l);
                fMap.put(left, fMap.getOrDefault(left,0) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
