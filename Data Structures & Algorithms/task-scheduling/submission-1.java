class Solution {
    public int leastInterval(char[] tasks, int n) {
        var map = new HashMap<Character, Integer>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) +1);
        }
        var q = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (Integer value : map.values()) {
            q.offer(value);
        }
        var cooler = new LinkedList<int[]>();
        int cyclesCount = 0;
        while (!q.isEmpty() || !cooler.isEmpty()) {
            cyclesCount++;
            if (!q.isEmpty()) {
                int task = q.poll();
                if (task != 1)
                    cooler.add(new int[]{task, cyclesCount});
            }
            if (!cooler.isEmpty()) {
                int[] oldestTask = cooler.getFirst();
                if (cyclesCount - oldestTask[1] == n) {
                    q.offer(--oldestTask[0]);
                    cooler.removeFirst();
                }
            }
        }
        return cyclesCount;
    }
}
