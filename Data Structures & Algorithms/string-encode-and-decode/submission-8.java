class Solution {

    public String encode(List<String> strs) {

    String encoded = "";
        for(String s : strs) {
            String l = String.valueOf(s.length());
            encoded = encoded + l + "#" + s;
        }
     return encoded;
    }

    public List<String> decode(String str) {
        System.out.println(str);
        List<String> decoded = new ArrayList<>();
        if(str.length() < 1) return decoded;
        String len = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '#') {
                len = len + String.valueOf(str.charAt(i));
            }
            else {
                int l = Integer.parseInt(len);
                decoded.add(str.substring(i+1, i+l+1));
                i = i + l;
                len = "";
            }
        }
        return decoded;
    }
}
