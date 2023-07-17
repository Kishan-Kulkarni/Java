public class binarySearchRecursion {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int target=2;
        int found=binarySearch(arr, target, 0, arr.length-1);
        System.out.println("The index of the target is: "+found);
    }

    private static int binarySearch(int[] arr, int target, int s, int e) {
        int mid=s+(e-s)/2;

        if(s>e){
            return -1;
        }

        if(arr[mid]==target){
            return mid;
        }else if(arr[mid]>target){
            return binarySearch(arr, target, s, mid-1);
        }else if(arr[mid]<target){
            return binarySearch(arr, target, mid+1, e);
        }
        return -1;
    }
}
