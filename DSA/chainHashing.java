package DSA;

public class chainHashing {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 10, 5, 2, 37, 0, 8};
       chainHashing hashtable =new chainHashing(arr.length);

       for(int i:arr){
           hashtable.insert(i);
       }

       hashtable.printTab();
    }
   public  class Node{
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
            next=null;
        }
    }

        Node[] tab;
        int size;

        public chainHashing(int tabSize) {
            tab = new Node[tabSize];
            size=0;
        }

        public boolean isEmpt(){
            return size == 0;
        }

        public int getSize(){
            return size;
        }

        public void insert(int val){
            size++;
            int position=hash(val);

            Node nextptr=new Node(val);

            if(tab[position]==null){
                tab[position]=nextptr;
            }else{
                nextptr.next=tab[position];
                tab[position]=nextptr;
            }
        }

        public void delete(int val){

            int position=hash(val);

            Node s=tab[position];
            Node e=s;

            if(s.val==val){
                size--;
                tab[position]=s.next;
                return;
            }

            while(e.next!=null && e.next.val!=val){
                e=e.next;
            }

            if(e.next==null){
                System.out.println("No such element exists");
                return;
            }
            size--;

            if(e.next.next==null){
                e.next=null;
                return;
            }

            e.next=e.next.next;
            tab[position] = s;
        }

        int hash(int val){
            return val%tab.length;
        }

        public void printTab(){
            for(int i=0; i<tab.length; i++){
                System.out.print(i + ": ");
                Node s=tab[i];

                while(s!=null){
                    System.out.print(s.val + " ");
                    s=s.next;
                }
                System.out.println();
            }

        }

}

