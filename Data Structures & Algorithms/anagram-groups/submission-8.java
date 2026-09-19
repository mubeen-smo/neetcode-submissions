class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String key = getKey(s);
            if(!map.containsKey(key)) {
                
            map.put(key, new ArrayList<>());
            }
                            map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        int count[] = new int[26];

        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        return Arrays.toString(count);
    }
}
