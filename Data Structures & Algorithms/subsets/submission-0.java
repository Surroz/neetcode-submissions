class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        var subset = new ArrayList<Integer>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i+1, subset, res);
        subset.remove(subset.size() - 1);
        dfs(nums, i+1, subset, res);
    }
}
