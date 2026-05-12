class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int max = Integer.MIN_VALUE;
        int min = 1;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        int res = max;
        long hours = 0;
        while (max >= min) {
            int mid = (max + min)/2;
            hours = 0;
            for (int pile : piles) {
                hours += Math.ceil((double) pile / mid);
                if (hours > h)
                    break;
            }
            if (hours == h) {
                res = mid;
                break;
            }
            else if (hours > h) {
                min = ++mid;
            } else {
                res = mid;
                max = --mid;
            }

        }
        if (hours == h) {
            while (hours == h) {
                hours = 0;
                res--;
                for (int pile : piles) {
                    hours += Math.ceil((double) pile / res);
                }
            }
            res++;
        }
        return res;

    }
}
