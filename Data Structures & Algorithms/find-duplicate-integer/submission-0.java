class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int pos = Math.abs(num) -1;
            if (nums[pos] > 0)
                nums[pos] = -nums[pos];
            else
                return Math.abs(num);
        }
        return -1;
    }
}
