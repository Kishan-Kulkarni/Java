public class missingnumbers {
    public static void main(String[] args) {
        int arr[]={3,0,2,1};

        int i=0;
        while(i<arr.length){
            int correct=arr[i];
            if(arr[i]>=arr.length){
                i++;
                continue;
            }

            if(arr[i]!=arr[correct]){
                int temp= arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                i++;
            }
        }

        boolean isCont=true;
        int missing=-1;
        for(int j=0;j<arr.length;j++){
            if(arr[j]==j){
                continue;
            }else{
                isCont=false;
                missing=j;
                break;
            }
        }

        if(isCont){
            System.out.println(arr.length);
        }else{
            System.out.println(missing);
        }
    }
}
