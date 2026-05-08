class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int l = 0;
        int r = length-1;
        while (l <= r) {
            int p = (l + r)/2;
            if (nums[p] == target)
                return p;
            if (nums[p] > target) {
                r = p-1;
            } else {
                l = p+1;
            }
        } ;
        return -1;
    }
}