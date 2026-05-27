class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> bucket = new HashMap<>();
        for(String s : strs) {
            String key = getKey(s);
            bucket.putIfAbsent(key, new ArrayList<String>());
            bucket.get(key).add(s);
        }
        return new ArrayList<>(bucket.values());
    }

    public String getKey(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return Arrays.toString(count);
    }
}
