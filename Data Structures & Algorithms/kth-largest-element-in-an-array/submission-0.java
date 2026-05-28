class Solution {
    public int findKthLargest(int[] nums, int maxK) {
        int length = nums.length;
        int minK = length - maxK;
        boolean max = maxK <= minK;
        int k = max ? maxK : minK + 1;
        PriorityQueue<Integer> heap = max ? new PriorityQueue<>() : new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (max) {
                // logic for max k elems
                if (nums[i] > heap.peek()) {
                    heap.add(nums[i]);
                    heap.poll();
                }
            } else {
                //logic for min k elems
                if (nums[i] < heap.peek()) {
                    heap.add(nums[i]);
                    heap.poll();
                }
            }

        }
        return  heap.peek();

    }
}