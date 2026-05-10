class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int l = 0;
        int r = height -1;
        while (target >= matrix[l][0] && target <= matrix[r][width-1]) {
            int mid = (r+1 - l)/2 + l;
            if (target >= matrix[mid][0] && target <= matrix[mid][width-1]) {
                // found raw
                int[] raw = matrix[mid];
                l = 0;
                r = width-1;
                while (target >= raw[l] && target <= raw[r]) {
                    mid = (r+1 - l)/2 + l;
                    if (target == raw[mid]) {
                        return true;
                    } else if (target > raw[mid]) {
                        l = ++mid;
                    } else {
                        r = --mid;
                    }
                }
                return false;
                //
            } else if (target < matrix[mid][0]) {
                r = --mid;
            } else {
                l = ++mid;
            }
        }
        return false;
    }
}
