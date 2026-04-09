public class MyStack {

    String[] arr;
    int top;
    int capacity;

    public MyStack(int capacity) {
        this.capacity = capacity;
        arr = new String[capacity];
        top = -1;
    }

    public void push(String item) {

        if (top == capacity - 1) {
            System.out.println("Stack full");
            return;
        }

        top++;
        arr[top] = item;
    }

    public String pop() {

        if (top == -1) {
            return "Stack empty";
        }

        String item = arr[top];
        top--;

        return item;
    }

    public String peek() {

        if (top == -1) {
            return "Stack empty";
        }

        return arr[top];
    }
}