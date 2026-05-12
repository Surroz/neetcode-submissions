class Solution {
    public List<List<String>> groupAnagrams(String[] strs)  {
        if (strs.length == 0)
            return null;
        List<List<String>> anagrams = new ArrayList<>();
        for (String str : strs) {
            if (str == null) continue;
            Map<Character, Integer> strMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                strMap.put(str.charAt(i), strMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            boolean match = false;
            for (List<String> anagram : anagrams) {
                if (isAnagram(anagram.getFirst(), str, strMap)) {
                    anagram.add(str);
                    match = true;
                    break;
                }
            }
            if (!match) {
                List<String> newElem = new LinkedList<>();
                newElem.add(str);
                anagrams.add(newElem);
            }

        }
        return anagrams;
    }
    public static boolean isAnagram (String first, String second, Map<Character, Integer> secondMap) {
        if (first.length() != second.length()) return false;
        if (first.isEmpty()) return true;
        Map<Character, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            firstMap.put(first.charAt(i), firstMap.getOrDefault(first.charAt(i), 0) + 1);
        }
        return firstMap.equals(secondMap);
    }

}