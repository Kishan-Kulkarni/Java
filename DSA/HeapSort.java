package DSA;



public class HeapSort {
    public void sort(int[] arr)
    {

        for (int i = arr.length / 2 - 1; i >= 0; i--)
            heapify(arr, arr.length, i);


        for (int i = arr.length - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
    }


    void heapify(int[] arr, int length, int i)
    {
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;


        if (l < length && arr[l] > arr[max])
            max = l;


        if (r < length && arr[r] > arr[max])
            max = r;


        if (max != i) {
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;


            heapify(arr, length, max);
        }
    }


    static void printArray(int[] arr)
    {

        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }


    public static void main(String[] args)
    {
        int[] arr = { 5,13,1,7,9,10};

        HeapSort bhs = new HeapSort();
        bhs.sort(arr);

        printArray(arr);
    }
}

