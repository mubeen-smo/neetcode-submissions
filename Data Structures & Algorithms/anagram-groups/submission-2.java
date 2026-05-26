class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int l = strs.length;
        Map<String, List<String>> bucket = new HashMap<>();

        
        char[] charArray = new char[]{};

        for(String s : strs) {
            int[] count = new int[26];
            charArray = s.toCharArray();
            for(int i = 0; i < s.length() ; i++) {
                count[charArray[i] - 'a']++;
            }
            
            bucket.putIfAbsent(Arrays.toString(count), new ArrayList<>());
            bucket.get(Arrays.toString(count)).add(s);
        }

        return new ArrayList<>(bucket.values());

    }
}
