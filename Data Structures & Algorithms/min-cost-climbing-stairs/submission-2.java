class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int firstSum = cost[length-1];
        int secondSum = 0;
        for (int i = length-2; i >= 0 ; i--) {
            int totalValue;
            if (firstSum > secondSum)
                totalValue = secondSum + cost[i];
            else
                totalValue = firstSum + cost[i];
            secondSum = firstSum;
            firstSum = totalValue;
        }
        return Math.min(firstSum,secondSum);
    }
}
