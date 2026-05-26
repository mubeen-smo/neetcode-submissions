class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> bucket = new HashMap<>();

        List<List<String>> res = new ArrayList<>();

        for(String s : strs) {

            String key = getKey(s);
            System.out.println(bucket);
            if(bucket.get(key) == null) {
                bucket.put(key, new ArrayList<>());
            }
            bucket.get(key).add(s);

        }
 
        return new ArrayList<>(bucket.values());
    }

    private String getKey(String s) {

        int[] count = new int[26];
        for(int i = 0; i < s.length() ; i++ ) {
            count[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(count);
    }
}
