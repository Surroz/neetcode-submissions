class Solution {
    public int trap(int[] height) {
        List<Integer> lefts = new ArrayList<>();
        List<Integer> rights = new ArrayList<>();
        int limit = 0;
        for (int i = 0; i < height.length; i++) {
            while (height[i] > limit) {
                lefts.add(i);
                limit = height[i];
            }
        }
        if (lefts.isEmpty())
            return 0;

        limit = 0;
        for (int i = height.length-1; i >= 0; i--) {
            while (height[i] > limit) {
                rights.add(i);
                limit = height[i];
            }
        }
        int water = 0;
        int lCount = 0;
        int rCount = 0;
        int minWall = 0;
        while (true) {
            if(lefts.get(lCount) == rights.get(rCount))
                return water;

            int lrComp = Integer.compare(height[lefts.get(lCount)],height[rights.get(rCount)]);
            minWall = lrComp > 0 ? height[rights.get(rCount)] : height[lefts.get(lCount)];
            for (int j = lefts.get(lCount)+1; j < rights.get(rCount); j++) {
                if (height[j] < minWall) {
                    water += minWall-height[j];
                    height[j] = minWall;
                }
            }

            if (lrComp <= 0)
                lCount++;
            if (lrComp >= 0)
                rCount++;

            if (lCount == lefts.size() || rCount == rights.size()) {
                return water;
            }

        }
    }
}