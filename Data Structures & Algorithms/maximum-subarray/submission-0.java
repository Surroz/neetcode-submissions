class Solution {
    public int maxSubArray(int[] nums) {
//                  *    * _
        // [-2,1,-3,4,-1,2,1,-5,4]
        // [0,-2,-1,-4,0,-1,1,2,-3| total 1]
        //          4,-1,2,1
        //
        int length = nums.length;
        if (length == 1)
            return nums[0];

        int[] prefs = new int[length];
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            prefs[i] = totalSum;
            totalSum += nums[i];
            maxSum = Math.max(maxSum, nums[i]);
        }
        int left = 0;
        for (int right = 1; right < length; right++) {
//            int rSuf = totalSum - prefs[right] - nums[right];
//            int curSum = totalSum - prefs[left] - rSuf;
            int curSum = prefs[right] - prefs[left] + nums[right];
            maxSum = Math.max(maxSum, curSum);
//            if prefR < 0 -> left = right
//            prefR = pref[right] - pref[left]
            if (prefs[right] - prefs[left] < 0) {
                left = right;
            }
        }
        return maxSum;
    }
}