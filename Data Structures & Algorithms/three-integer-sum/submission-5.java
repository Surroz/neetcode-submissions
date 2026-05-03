class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int l =0;
        for (int j = nums.length-1; j >= 2; j--) {
            addZeroSumForCurrentR(nums, l, j, res);
        }
        return res;
    }

    private void addZeroSumForCurrentR(int[] nums, int l, int r, ArrayList<List<Integer>> res) {
        while (l +1 < r) {
            int i = l +1;
            int lrSum = nums[l] + nums[r];
            int sum = -1;
            while (i < r && sum <= 0) {
                sum = lrSum + nums[i];
                if (sum == 0){
                    var list = Arrays.asList(nums[l], nums[i], nums[r]);
                    if (!res.contains(list))
                        res.add(list);
                }
                i++;
            }
            l++;
        }
    }
}