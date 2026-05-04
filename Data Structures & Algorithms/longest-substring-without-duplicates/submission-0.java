class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Set<Character> set = new HashSet<>();
        List<Character> list1 = new ArrayList<>();
        int leftP = 0;
        int maxLength = 0;
        int currLength;
        int rightP = 0;

        while (rightP < s.length() ) {
            {
                if (set.contains(s.charAt(rightP))) {
                    currLength = rightP - leftP;
                    if (currLength > maxLength) maxLength = currLength;

                    while (set.contains(s.charAt(rightP))) {
                        set.remove(s.charAt(leftP));
                        leftP++;
                    }
                }
                set.add(s.charAt(rightP));

            }
            rightP++;
        }
        if (rightP - leftP > maxLength) maxLength = rightP - leftP ;

        return maxLength;
    }
}
