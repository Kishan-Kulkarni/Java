package DSA;

public class qudraticProbing {
    Integer[] data;
    int size;
    int i;

    int repeat=0;

    public qudraticProbing(int length){
        data=new Integer[length];
        i=length;
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size==data.length;
    }

    public void insert(int val){
        if(isFull()){
            Integer[] temp=new Integer[2* data.length];
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        int hashKey=hash(val);

        while(data[hashKey] != null){
            repeat++;
            hashKey+=(repeat*repeat);

            if(hashKey>= data.length){
                while(hashKey>= data.length){
                    Integer[] temp=new Integer[2* data.length];
                    System.arraycopy(data, 0, temp, 0, data.length);
                    data = temp;
                }
            }
        }

        data[hashKey]=val;
    }

    public void remove(int val){
        if(isEmpty()){
            return;
        }

        int hashKey = hash(val);

        while(data[hashKey]!=val){
            hashKey+=1;
        }
        data[hashKey] = null;
    }

    public int search(int val){
        if(isEmpty()){
            return -1;
        }

        int hashKey = hash(val);

        while(data[hashKey]!=val){
            hashKey+=1;
        }

        return hashKey;
    }

    public void printHash(){
        for(int i=0; i<data.length; i++){
            System.out.println(i + ": " + data[i]);
        }
    }

    public int hash(int val){
        return val%i;
    }

    public static void main(String[] args) {
        int[] arr=new int[] {1,5,17,5,1,34,6,1,45,13,45,1,34};

        qudraticProbing lp=new qudraticProbing(arr.length);

        for (int j : arr) {
            lp.insert(j);
        }

        lp.printHash();
    }
}
