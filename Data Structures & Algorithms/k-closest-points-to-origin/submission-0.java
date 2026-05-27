class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Double.compare(Math.sqrt(b[0] * b[0] + b[1] * b[1]),
                        Math.sqrt(a[0] * a[0] + a[1] * a[1])));
        for (int[] point : points) {
            queue.offer(point);
            if (queue.size() > k)
                queue.poll();
        }
        int[][] res = new int[k][2];
        int count = 0;
        for (int[] ints : queue) {
            res[count] = ints;
            count++;
        }
        return res;

    }
}
