class Solution {
    public List<List<String>> partition(String s) {
        var res = new ArrayList<List<String>>();
        checkForPalindrome(s.toCharArray(), res, new ArrayList<>(),  0);
        return res;
    }

    private static void checkForPalindrome (char[] chars, List<List<String>> res, List<String> palindromes, int idx) {
        if (chars.length <= idx) {
            res.add(new ArrayList<>(palindromes));
        } else {
            for (int i = idx; i < chars.length; i++) {
                char[] cur = Arrays.copyOfRange(chars, idx, i+1);
                if (isPalindrome(cur)) {
                    palindromes.add(String.valueOf(cur));
                    checkForPalindrome(chars, res, palindromes, i+1);
                    palindromes.removeLast();
                }
            }
        }
    }

    private static boolean isPalindrome(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1])
                return false;
        }
        return true;
    }
}
