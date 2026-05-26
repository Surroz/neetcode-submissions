class KthLargest {
    int k;
    List<Integer> topK;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k = k;
        int length = Math.min(k, nums.length);
        topK = new LinkedList<>();
        for (int i = nums.length-length; i < nums.length; i++) {
            topK.add(nums[i]);
        }
    }
    public int add(int val) {
        if(topK.isEmpty()){
            topK.add(val);
        } else if (topK.size() < k) {
            if (topK.getLast() < val)
                topK.add(val);
            else {
                for (Integer i : topK) {
                    if (val <= i) {
                        topK.add(topK.indexOf(i), val);
                        break;
                    }
                }
            }

        }
        else if (!(topK.getFirst() > val)) {

            if (topK.getLast() < val) {
                topK.add(val);
                topK.removeFirst();
            } else {
                for (Integer i : topK) {
                    if (val <= i) {
                        topK.add(topK.indexOf(i), val);
                        topK.removeFirst();
                        break;
                    }
                }

            }
        }
        return topK.getFirst();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */