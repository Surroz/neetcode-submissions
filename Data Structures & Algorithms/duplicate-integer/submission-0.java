class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> checked = new HashSet<>();
        for (int num : nums) {
            if (checked.contains(num))
                return true;
            
            checked.add(num);
        }
        return false;
    }
}