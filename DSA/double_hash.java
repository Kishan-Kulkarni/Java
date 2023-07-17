package DSA;

import java.util.Arrays;

public class double_hash {

    public static Integer[] doubleHash(int[] arr,int table_size, int double_hash_value){
        Integer[] hashTable=new Integer[table_size];

        for (int j : arr) {
            int hashKey = hash1(j, table_size);

            if (hashTable[hashKey] == null) {
                hashTable[hashKey] = j;
            } else {
                int newHashKey = hashKey;
                while (hashTable[newHashKey] != null) {
                    int step = double_hash_value - hash2(j, double_hash_value);
                    newHashKey = (newHashKey + step) % table_size;
                }
                hashTable[newHashKey] = j;
            }
        }

        return hashTable;
    }

    private static int hash2(int j, int double_hash_value) {
        return j%double_hash_value;
    }

    private static int hash1(int j, int table_size) {
        return j%table_size;
    }

    public static void main(String[] args) {
        int[] arr={86, 55, 28, 68, 14, 2, 34, 42, 38};
        System.out.println(Arrays.toString(doubleHash(arr,10,3)));
    }
}
