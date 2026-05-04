class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length-1;
        int maxH = 0;
        while (height[l] == 0)
            l++;

        while (height[r] == 0)
            r--;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            if (h > maxH) {
                max = Math.max(max, h * (r - l));
                maxH = h;
            }
            if (height[l] > height[r]) {
                    r--;
            } else if (height[l] < height[r]) {
                    l++;
            } else {
                l++;
                r--;
            }
        }

        return max;
    }
}
