class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if (nums[left] == target)
            return left;
        if (nums[right] == target)
            return right;
        while (left <= right) {
            int cur = (left + right) / 2;
            if (nums[cur] == target)
                return cur;
            if (nums[left] < nums[cur]) {
                //left part sorted
                if (target == nums[left])
                    return left;
                if (target < nums[cur] && target > nums[left]) {
                    //left - cur searched diapason
                    right = cur-1;
                } else {
                    left = cur+1;
                }
            } else {
                //right part sorted
                if (target == nums[right])
                    return right;
                if (target > nums[cur] && target < nums[right]) {
                    //cur - right searched diapason
                    left = cur+1;
                } else {
                   right = cur-1;
                }
            }
        }
        return -1;
    }
}