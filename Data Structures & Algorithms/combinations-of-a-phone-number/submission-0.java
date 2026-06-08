class Solution {
    private static final String[] dict = {"abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        var res = new ArrayList<String>();
        if (!digits.isEmpty())
            buildCombination(res, digits, 0, new char[digits.length()]);
        return res;
    }

    private static void buildCombination(List<String> res, String digits, int idx, char[] cur) {
        if (idx == digits.length())
            res.add(String.valueOf(cur));
        else {
            int number = Character.getNumericValue(digits.charAt(idx)) - 2;
            for (int i = 0; i < dict[number].length(); i++) {
                cur[idx] = dict[number].charAt(i);
                buildCombination(res, digits, idx+1, cur);
            }
        }
    }
}
