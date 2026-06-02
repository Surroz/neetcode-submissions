class Solution {
    public int rob(int[] nums) {
        int firstSum = 0, secondSum = 0;
        for (int num : nums) {
            int temp = Math.max(firstSum + num, secondSum);
            firstSum = secondSum;
            secondSum = temp;
        }
        return secondSum;
    }
}