class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    private static void dfs (List<List<Integer>> res, int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (j>i && nums[j] == nums[j-1])
                continue;
            if (total + nums[j] > target) {
                return;
            }

            cur.add(nums[j]);
            dfs(res, j+1, cur, total + nums[j], nums, target);
            cur.removeLast();
        }
    }
}
