class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Node> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            //pop all elems bigger heights[i]
            Node node = null;
            Node lastEvictNode = null;
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node.height > heights[i]) {
                    lastEvictNode = node;

                    maxArea = Math.max(maxArea,
                            node.height * (i - node.start));
                } else {
                    stack.push(node);
                    break;
                }
            }
            if (stack.isEmpty()) {
                int start = node == null ? i : node.start;
                if (heights[i] != 0) {
                    stack.push(new Node(heights[i], start));
                }
                continue;
            }
            if (node.height < heights[i]) {
                /////
                int start = lastEvictNode == null
                        || heights[i] > lastEvictNode.height
                        ? i : lastEvictNode.start;
                stack.push(new Node(heights[i], start));
            }
        }
        for (Node node : stack) {
            maxArea = Math.max(maxArea,
                    node.height * (heights.length - node.start));
        }

        return maxArea;
    }

     public static class Node {
        public int height;
        public int start;

        public Node(int height, int start) {
            this.height = height;
            this.start = start;
        }
    }
}