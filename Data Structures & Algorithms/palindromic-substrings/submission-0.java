class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += findAllPalis(s, i, i);
            count += findAllPalis(s, i, i+1);
        }
        return count;
    }

    private static int findAllPalis(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                count++;
            } else {
                break;
            }
            l--;
            r++;
        }
        return count;
    }
}
