import java.util.*;

public class Stacks_Queues {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(34);
        stack.push(2);
        stack.push(9);
        stack.push(17);
        stack.push(25);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println();

        Queue<Integer> queue=new LinkedList<>();
        queue.add(3);
        queue.add(29);
        queue.add(12);
        queue.add(76);
        queue.add(19);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println();

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(12);
        deque.addLast(76);
        deque.add(15);
        deque.addLast(50);

        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
    }
}
