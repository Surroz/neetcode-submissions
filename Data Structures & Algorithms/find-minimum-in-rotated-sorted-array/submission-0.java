class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 1 || nums[0] < nums[length-1])
            return nums[0];
        else if (nums[length-1] < nums[0] && nums[length-1] < nums[length-2])
            return nums[length-1];
        int r = length -1;
        int l = 0;
        int mid = 0;
        while (l < r) {
            mid = (l + r)/2;
            if (nums[mid] > nums[r]) {
                if (nums[mid] < nums[mid-1]) {
                    break;
                }
                l = mid;
            }
            else if (nums[mid] < nums[l]) {
                if (nums[mid] < nums[mid-1]) {
                    break;
                }
                r = mid;
            }
        }
        return nums[mid];

    }
}
