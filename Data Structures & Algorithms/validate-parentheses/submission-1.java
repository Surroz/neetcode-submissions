class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        List<Character> openChars = Arrays.asList('(', '{', '[');
        for (char c : s.toCharArray()) {
            if (openChars.contains(c))
                deque.add(c);
            else if (deque.isEmpty())
                return false;
            else {
                if (c == ')') {
                    if (deque.peekLast() == '(')
                        deque.removeLast();
                    else
                        return false;
                } else if (c == ']') {
                    if (deque.peekLast() == '[')
                        deque.removeLast();
                    else
                        return false;
                } else if (c == '}') {
                    if (deque.peekLast() == '{')
                        deque.removeLast();
                    else
                        return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
