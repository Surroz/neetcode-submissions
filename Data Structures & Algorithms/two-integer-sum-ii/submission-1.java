class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int r = numbers.length-1;
        int l = 0;
        while (numbers[l] + numbers[r] != target) {
            while (numbers[l] + numbers[r] > target) {
                r--;
            }
            while (numbers[l] + numbers[r] < target) {
                l++;
            }
        }
        return new int[] {l+1, r+1};
    }
}
