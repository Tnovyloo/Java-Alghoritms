import java.util.ArrayList;

public class Stack {
    ArrayList<String> stack = new ArrayList<>();

    public void add(String value) {
        stack.add(value);
    }

    public void put() {
        stack.remove(stack.size() - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.add("hello");
        stack.add("helo");
        stack.add("konrad");

        System.out.println(stack.stack);

        stack.put();

        System.out.println(stack.stack);
    }
}
