class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var res = new ArrayList<List<Integer>>();
        var cur = new ArrayList<Integer>();
        boolean[] picked = new boolean[nums.length];
        addRecursively(0, res, cur, nums, picked);
        return res;
    }

    public static void addRecursively(int idx, List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] picked) {
        if (idx == nums.length)
            res.add(List.copyOf(cur));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!picked[i]) {
                    picked[i] = true;
                    cur.add(nums[i]);
                    addRecursively(++idx, res, cur, nums, picked);
                    picked[i] = false;
                    cur.removeLast();
                    idx--;
                }
            }
        }
    }
}
