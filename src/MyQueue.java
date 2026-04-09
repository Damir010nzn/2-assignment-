public class MyQueue {

    String[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(String item) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }

        rear++;
        arr[rear] = item;
        size++;
    }

    public String dequeue() {
        if (size == 0) {
            return "Queue is empty";
        }

        String item = arr[front];

        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        rear--;
        size--;

        return item;
    }

    public String peek() {
        if (size == 0) {
            return "Queue is empty";
        }

        return arr[front];
    }

    public void show() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + arr[i]);
        }
    }
}