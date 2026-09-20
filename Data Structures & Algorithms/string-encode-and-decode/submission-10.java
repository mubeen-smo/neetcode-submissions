class Solution { 
    public String encode(List<String> strs) { 
        StringBuilder encoded = new StringBuilder(); 
        for (String s : strs) { 
            encoded.append(s.length()).append('#').append(s); 
        } 
        return encoded.toString(); 
    } 

    public List<String> decode(String str) { 
        List<String> result = new ArrayList<>(); 
        int i = 0; 
        int n = str.length(); 
        
        while (i < n) { 
            int length = 0; 
            while (str.charAt(i) != '#') { 
                length = length * 10 + (str.charAt(i) - '0'); 
                i++; 
            } 
            i++; 
            result.add(str.substring(i, i + length)); 
            i += length; 
        } 
        
        return result; 
    } 
}
