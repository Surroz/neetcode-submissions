class Solution {
    public  int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Deque<Node> stack = new ArrayDeque<>();
        if (temps.length == 1) {
            return res;
        }

        for (int i = temps.length-1; i >=0 ; i--) {
            Node top = findWarmerDay(stack, temps[i]);
            if (top == null) {
                stack.push(new Node(i, temps[i]));
                continue;
            }
            res[i] = top.number - i;
            stack.push(top);
            stack.push(new Node(i, temps[i]));
        }
        return res;
    }

    public static class Node {
        public int number;
        public int temp;

        public Node(int number, int temp) {
            this.number = number;
            this.temp = temp;
        }

    }

    public static Node findWarmerDay(Deque<Node> stack, int curTemp) {
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            if (curTemp < top.temp) {
                return top;
            }
        }
        return null;
    }
    
}