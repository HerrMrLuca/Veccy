package at.fhhgb.mtd.gop.veccy.data;

public class StaticStack {

    static int[] stack;
    static int size, top;

    public static void initStack() {
        size = 10;
        stack = new int[size];
        top = 0;
    }

    public static void initStack(int size) {
        StaticStack.size = size;
        stack = new int[size];
        top = 0;
    }

    public static void push (int val) {
        stack[top] = val;
        top++;
    }

    public static int pop() {
        top--;
        return stack[top];
    }

    public static int size() {
        return top;
    }

    public static void print() {
        System.out.print("StaticStack: ");
        for (int i = 0; i < top ; i++) {
            System.out.print(stack[i]);
            System.out.print(", ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        initStack(3);
        push(42);
        push(69);
        print();
        int x = pop();
        System.out.println(x);
        push(1);
        push(2);
        print();

        Stack stack = new Stack();
        Stack stack2 = new Stack();
        stack.initStack(3);
        stack2.initStack(3);
        stack.push(42);
        stack2.push(69);
        System.out.println(stack2);
        int y = stack.pop();
        System.out.println(y);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.size());
        System.out.println(stack);
    }
}
