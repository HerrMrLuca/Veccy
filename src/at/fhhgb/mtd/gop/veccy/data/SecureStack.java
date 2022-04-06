package at.fhhgb.mtd.gop.veccy.data;

public class SecureStack extends Stack{

    boolean check;

    public SecureStack(boolean check) {
        this.check = check;
    }

    @Override
    public void push(int val) {
        if (check && super.top >= size) {
            System.out.println("overflow");
        } else {
            super.push(val);
        }

    }

    @Override
    public int pop() {
        if (check && super.top <= 0) {
            System.out.println("underflow");
            return 0;
        } else {
            return super.pop();
        }

    }
}
