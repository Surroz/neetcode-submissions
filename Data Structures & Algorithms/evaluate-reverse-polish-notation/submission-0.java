class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            int res = switch (token) {
                case "+" -> stack.pop() + stack.pop();
                case "-" -> {
                    int prev = stack.pop();
                    int pPrev = stack.pop();
                    yield pPrev - prev;
                }
                case "*" -> stack.pop() * stack.pop();
                case "/" -> {
                    int prev = stack.pop();
                    int pPrev = stack.pop();
                    yield pPrev / prev;
                }
                default -> Integer.parseInt(token);
            };
            stack.push(res);
        }
        return stack.pop();
    }
}
