class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            heap.add(stone);
        }
        while (heap.size()>1) {
            int max = heap.poll();
            int preMax = heap.poll();
            if (max > preMax) {
                heap.add(max - preMax);
            }
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}