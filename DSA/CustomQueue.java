package DSA;

public class CustomQueue {
    private int[] data;

    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }

        int removed = data[0];

        // shift the elements to left
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public void reverse() throws Exception {
        if (this.isEmpty())
            return ;

        // Dequeue current item (from front)
        int data = this.front();
        this.remove();

        // Reverse remaining queue

        this.reverse();
        // Enqueue current item (to rear)
        this.insert(data);


    }

    public int front() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);

        queue.insert(10);
        queue.insert(1);
        queue.insert(6);
        queue.insert(17);
        queue.insert(-1);

        queue.display();

        queue.remove();

        System.out.println(queue.front());
    }
}
