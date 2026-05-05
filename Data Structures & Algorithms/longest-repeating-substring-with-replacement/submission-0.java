class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int length = s.length();
        if (length == 1)
            return length;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int result = 0;
        for (int r = 0; r < length; r++) {
            char rChar = s.charAt(r);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            result = Math.max(result, map.get(rChar));
            while ((r - l + 1) - result > k) {
                char lChar = s.charAt(l);
                map.put(lChar, map.get(lChar) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
