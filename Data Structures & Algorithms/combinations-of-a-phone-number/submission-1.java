class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        Map<Character, List<Character>> keyMap = new HashMap<>();
        keyMap.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        keyMap.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        keyMap.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        keyMap.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        keyMap.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        keyMap.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        keyMap.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        keyMap.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));  
        
        buildCombinations(digits, 0, result, keyMap, "");
        return result;
    }

    private void buildCombinations(String digits, int index, List<String> result, Map<Character, List<Character>> keyMap, String r) {
        if (index == digits.length() - 1) {
            List<Character> chars = keyMap.get(digits.charAt(index));
            for (char c : chars) {
                result.add(r + c);        
            }
            return;
        }
        List<Character> chars = keyMap.get(digits.charAt(index));
        for (char c : chars) {
            buildCombinations(digits, index + 1, result, keyMap, r + c);
        }
    } 
}
