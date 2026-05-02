class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> elems = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            elems.add(nums[i]);
        }
        int max =0;
        for (Integer elem : elems) {
            if (!elems.contains(elem -1)) {
                int count = 1;
                while (elems.contains(elem+count)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}