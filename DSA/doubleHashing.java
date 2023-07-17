package DSA;

public class doubleHashing {
    Integer[] data;
    int l;

    int size;

    public doubleHashing(int length) {
        data=new Integer[length];
        this.l = length;
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

        int index=computeHash(val, 1);

        data[index]=val;

        size++;
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

    int hash(int val){
        return val%l;
    }
    private int hash2(int val) {
//        if(l%5==0){
//            return val%7;
//        }else{
//            return val%5;
//        }
        return val%3;
    }

    public int computeHash(int val ,int k){
        int temprepeat=0;
        int hashKey=hash(val);
        while(data[hashKey]!=null ){
            temprepeat++;
            hashKey=hash(hashKey+k*(temprepeat+hash2(val)));

            if(hashKey>= data.length){
                while(hashKey>= data.length){
                    Integer[] temp=new Integer[2* data.length];
                    System.arraycopy(data, 0, temp, 0, data.length);
                    data = temp;
                }
            }
        }



        return hashKey;
    }

    public static void main(String[] args) {
        int[] arr=new int[] {86, 55, 28, 68, 14, 2, 34, 42, 38};

        doubleHashing lp=new doubleHashing(10);

        for (int j : arr) {
            lp.insert(j);
        }

        lp.printHash();
    }
}

/*
def double_hashing(keys, hashtable_size, double_hash_value):
    hashtable_list = [None] * hashtable_size
    for i in range(len(keys)):
        hashkey = keys[i] % hashtable_size
        if hashtable_list[hashkey] is None:
            hashtable_list[hashkey] = keys[i]
        else:
            new_hashkey = hashkey
            while hashtable_list[new_hashkey] is not None:
                steps = double_hash_value - (keys[i] % double_hash_value)
                new_hashkey = (new_hashkey + steps) % hashtable_size
            hashtable_list[new_hashkey] = keys[i]
    return hashtable_list


values = [86, 55, 28, 68, 14, 2, 34, 42, 38]
print( double_hashing(values, 10, 3) )

34 48 2 38 14 55 86 n 28 68
*/