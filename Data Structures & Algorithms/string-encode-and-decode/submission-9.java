class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for(String s : strs) {
            encoded.append(s.length());
            encoded.append("#");
            encoded.append(s);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        System.out.println(str);
        StringBuilder size = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '#') {
                int l = Integer.parseInt(size.toString());
                result.add(str.substring(i+1, i+l+1));
                size.setLength(0);
                i = i+l;
            } else {
                size.append(Character.toString(c));
            }
        }
        return result;
    }
}
