class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String s : strs) {
            int size = s.length();
            encoded = encoded + Integer.toString(size) + "#" + s;
        }
        return encoded;
    } 

    public List<String> decode(String str) {

        System.out.println(str);
        
        List<String> res = new ArrayList<>();
        int size = str.length();
        String s = "";
        for(int i = 0; i < size ; i++) {
            char c = str.charAt(i);
            if(c != '#') {
                s = s + String.valueOf(c);
            } else {
                int l = Integer.parseInt(s);
                System.out.println(l);
                String each = str.substring(i+1, i+l+1);
                i = i+l;
                res.add(each);
                s = "";
            }
        }
        return res;
    }

}
