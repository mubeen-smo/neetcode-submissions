class Solution {

    public String encode(List<String> strs) {      
       String s = new String();
       for(String each : strs) {
            int l = each.length();
            s = s + String.valueOf(l) + "#" + each;
       }
       System.out.println("Encoded_String:" + s);
       return s;
    }

    public List<String> decode(String str) {
        List<String> ds = new ArrayList<>(); 
        String word = new String();
        String len = new String();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            ds.add(str.substring(i, j));
            i = j;

        }
        return ds;
    }
}
 