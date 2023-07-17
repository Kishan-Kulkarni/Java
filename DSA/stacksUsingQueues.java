package DSA;


public class stacksUsingQueues extends CustomQueue{
    public static void main(String[] args) throws Exception {
        stacksUsingQueues q=new stacksUsingQueues();
        q.push(10);
        q.push(2);
        q.push(7);
        q.push(-10);

        System.out.println(q.top());
        q.print();

    }

    public stacksUsingQueues(){
        super();
    }

    public stacksUsingQueues(int size){
        super(size);
    }

    public void push(int n) throws Exception {
        this.reverse();
        this.insert(n);
        this.reverse();
    }

    public boolean isfull(){
        return this.isFull();
    }

    public int delete() throws Exception{
        return this.remove();
    }

    public int top() throws Exception{
        return this.front();
    }

    public void print(){
        this.display();
    }
}
