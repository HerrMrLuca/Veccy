package at.fhhgb.mtd.gop.veccy.data;

public class Stack {
    int[] stack;
    int size, top;
    static int count;

    public void initStack() {
        size = 10;
        stack = new int[size];
        top = 0;
    }

    public void initStack(int size) {
        this.size = size;
        stack = new int[size];
        top = 0;
        Stack.count++;
    }

    public void push (int val) {
        stack[top] = val;
        top++;
    }

    public int pop() {
        top--;
        return stack[top];
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Stack: ");
        for (int i = 0; i < top; i++) {
            sb.append(stack[i]);
            sb.append(", ");
        }
        sb.append("count = ");
        sb.append(Stack.count);
        sb.append(".");
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
