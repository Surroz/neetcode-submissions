class Solution {
    public int findDuplicate(int[] nums) {
        for (int num : nums) {
            int pNum= Math.abs(num);
            int pos = pNum -1;
            if (nums[pos] > 0)
                nums[pos] = -nums[pos];
            else
                return pNum;
        }
        return -1;
    }
}
