class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int l = strs.length;
        Map<String, List<String>> bucket = new HashMap<>();

        String key = new String();

        for(String s : strs) {
            key = getKey(s);
            if(!bucket.containsKey(key)) {
                bucket.put(key, new ArrayList<>());
            }
            bucket.get(key).add(s);
        }

        return new ArrayList<>(bucket.values());

    }

    public String getKey(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
