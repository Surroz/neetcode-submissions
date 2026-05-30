class Solution {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,0, new ArrayList<>(), 0, nums, target);
        return res;
    }

    private static void dfs (List<List<Integer>> res, int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            cur.add(nums[j]);
            dfs(res, j, cur, total + nums[j], nums, target);
            cur.remove(cur.size() - 1);
        }
    }
    
    
}
