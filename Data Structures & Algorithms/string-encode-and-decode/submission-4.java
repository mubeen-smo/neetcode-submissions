class Solution {

    public String encode(List<String> strs) {
        
        String encodedString = "";
        int len = 0;
        for(String s: strs) {
            len = s.length();
            encodedString = encodedString + String.valueOf(len) + "#" + s;
        }

        System.out.println(encodedString);
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        
        int i = 0;

        while( i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            decodedString.add(str.substring(i, j));
            i = j;
        }

        System.out.println(decodedString);
        return decodedString;
    }
}
