public class MinStack {
    Stack<Integer> elems = new Stack<>();
    Stack<Integer> minVals = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if (minVals.isEmpty() || minVals.peek() >= val)
            minVals.add(val);
        elems.add(val);
    }

    public void pop() {
        if (minVals.peek().equals(elems.pop()))
            minVals.pop();
    }

    public int top() {
        return elems.peek();
    }

    public int getMin() {
        return minVals.peek();
    }
}