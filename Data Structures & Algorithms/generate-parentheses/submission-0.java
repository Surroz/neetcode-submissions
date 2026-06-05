class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        addRecursively(n, res, new StringBuilder(), 0, 0);
        return res;
    }

    public static void addRecursively(int n, List<String> res, StringBuilder sb, int opened, int closed) {
        if (sb.length() == n*2)
            res.add(sb.toString());
        if (opened < n) {
            sb.append('(');
            opened++;
            addRecursively(n, res, sb, opened, closed);
            sb.deleteCharAt(sb.length()-1);
            opened--;
        }
        if (opened > closed) {
            sb.append(')');
            closed++;
            addRecursively(n, res, sb, opened, closed);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
