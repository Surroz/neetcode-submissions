class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (s.isEmpty())
            return true;

        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length/2; i++) {
            if (chars[i] != chars[length-1-i])
                return false;
        }
        return true;
    }
}
