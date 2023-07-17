package DSA;

public class CustomPQ {
    private int[] pqArr;
    private int size;
    private int n;

    public CustomPQ(int size){
        this.size = size;
        pqArr = new int[this.size];
        n = 0;
    }



    public void insert(int value) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }
        if (n == 0)
            pqArr[n++] = value;
        else {
            int i;
            for (i = n - 1; i >= 0; i--) {
                if (value > pqArr[i])
                    pqArr[i + 1] = pqArr[i];
                else
                    break;
            }
            pqArr[++i] = value;
            n++;
        }
    }



    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        return pqArr[--n];
    }


    public boolean isFull(){
        return (n == size);
    }

 
    public boolean isEmpty(){
        return (n == 0);
    }

    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(pqArr[i] + " <- ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) throws Exception{
        CustomPQ pq=new CustomPQ(5);
        pq.insert(1);
        pq.insert(16);
        pq.insert(3);
        pq.insert(-1);
        pq.insert(10);

        pq.display();

        pq.remove();

        pq.display();
    }
}
