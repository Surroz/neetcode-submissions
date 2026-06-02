class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length-1; i >=0 ; i--) {
            if (digits[i] == 9){
                digits[i] = 0;
                if (i == 0) {
                    int[] res = new int[length+1];
                    res[0] = 1;
                    System.arraycopy(digits, 0, res, 1, length);
                    return res;
                }

            } else {
                digits[i]++;
                break;
            }
        }
        return digits;
    }
}
