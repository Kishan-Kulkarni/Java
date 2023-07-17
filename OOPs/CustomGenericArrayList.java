package OOPs;

import java.util.Arrays;

public class CustomGenericArrayList<T> {
    private Object[] data;
    private static int DEFAULT_SIZE=10;
    private int size=0; //Acts as an index

    public CustomGenericArrayList(){
        data =new Object[DEFAULT_SIZE];
    }

    public void add(T thing){
        if(isFull()){
            reSize();
        }
        data[size]=thing;
        size++;
    }

    public  void reSize() {
    Object[] temp=new Object[2*data.length];

    for(int i=0; i<size; i++){
        temp[i]=(data[i]);
    }

    data=temp;
    }

    public boolean isFull() {
        return size==data.length;
    }

    public int size(){
        return size;
    }

    public T removed(){
        T removed=(T)(data[--size]);
        return removed;
    }

    public T get(int index){
        return (T)(data[index]);
    }

    public void set(int index, T thing){
        data[index]=thing;
    } 

    @Override
    public String toString() {
        return "CustomGenericArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
    }

    public static void main(String[] args) {
        CustomGenericArrayList<Integer> list=new CustomGenericArrayList<>();

        for(int i=0; i<22; i++){
            list.add(2*i);
        }

        System.out.println(list);
    }
}
