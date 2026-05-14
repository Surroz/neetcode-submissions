class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.get(nums[i]).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                var posList = map.get(x);
                if (x != nums[i]) {
                    res[1] = posList.getFirst();
                } else if (posList.size() > 1) {
                    res[1] = posList.get(1);
                }
                if (res[1] != 0) {
                    res[0] = i;
                    return res;
                }
                
            }
        }
        return null;
    }
}