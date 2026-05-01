class Solution {
    char seprtor = '†';
    char endSeprtor = '‡';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(seprtor).append(str.length()).append(endSeprtor).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int start = -1;
        int end = -1;
        for (int i = 0; i < str.length(); i++) {
            if (start == -1 && str.charAt(i) == seprtor) {
                start = i;
            }
            if (end == -1 && str.charAt(i) == endSeprtor) {
                end = i;
            }

            if (start != -1 && end != -1) {
                int length = Integer.parseInt(str.substring(start+1,end));
                int j = end+length;
                res.add(str.substring(end+1, j+1));
                start = -1;
                end = -1;
                i = j;
            }
        }
        return res;
    }
}
