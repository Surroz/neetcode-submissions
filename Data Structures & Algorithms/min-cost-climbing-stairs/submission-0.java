class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int firstSum = cost[length-1];
        int secondSum = 0;
        for (int i = length-2; i >= 0 ; i--) {
            int totalValue = Math.min(firstSum + cost[i], secondSum + cost[i]);
            secondSum = firstSum;
            firstSum = totalValue;
        }
        return Math.min(firstSum,secondSum);
    }
}
