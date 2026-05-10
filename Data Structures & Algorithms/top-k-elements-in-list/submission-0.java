class Solution {
    public int[] topKFrequent(int[] nums, int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair o) -> o.repeats).reversed());
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Integer i : map.keySet()) {
           pq.offer(new Pair(map.get(i),i));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().value;
        }
        return res;
    }
    public static class Pair {
        public int repeats;
        public int value;

        public Pair(int repeats, int value) {
            this.repeats = repeats;
            this.value = value;
        }
    }
}
