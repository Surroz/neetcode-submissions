class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length-2; i++) {
            if (nums[i] + nums[i+1] + nums[i+2] > 0)
                break;
            if(!res.isEmpty() && nums[i] == nums[i - 1]) 
                continue;

            int l = i+1;
            int r = length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0)
                    r--;
                else if (sum < 0) {
                    l++;
                } else  {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                    l++;
                    while (nums[l] == nums[l-1] && l < r)
                        l++;
                }
            }

        }
        return res;
    }
}