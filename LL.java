public class LL{
    Node head;
    private int size;

    public LL(){this.size=0;}


    private static class Node{
        Node next;
        int val;

        public Node(){

        }

        public Node(int val){
            this.val=val;
        }

        public Node(int val, Node next){
            this.val=val;
            this.next=next;
        }

    }

    public  void addFirst(int val){
        if(head == null){
            head= new Node(val);
        }else{
            Node temp= new Node(val);
            temp.next = head;
            head=temp;
        }
        size++;
    }

    public void addLast(int val) {
        if(head==null){
            head= new Node(val);
        }else{
            Node temp= new Node();
            temp=head;

            while(temp.next!=null){
                temp=temp.next;
            }

            Node node= new Node(val);
            temp.next=node;
            node.next=null;
        }

        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }


    public int deleteFirst(){
        int deleted =head.val;
        head= head.next;
        size--;
        return deleted;
    }

    public int deleteLast(){
        if(head==null){
            return Integer.MIN_VALUE;
        }

        if(size==1){
            return deleteFirst();
        }

        Node temp=head;
        while(temp.next.next != null){
            temp=temp.next;
        }

        int deleted=temp.next.val;
        temp.next=null;
        size--;

        return deleted;
    }

    public int delete(int i){
        if(i==0){
            return deleteFirst();
        }

        if(i==size-1){
            return deleteLast();
        }

        Node temp=head;

        for (int j = 0; j < i-1; j++) {
            temp=temp.next;
        }

        int deleted = temp.next.val;
        temp.next=temp.next.next;

        size--;
        return deleted;
    }

    public int get(int i){
        if(i==0){
            if(head != null){
                return head.val;
            }else{
                return Integer.MIN_VALUE;
            }
        }

        Node temp=head;

        for(int j = 0; j < i; j++){
            temp=temp.next;
        }

        return temp.val;
    }

    public int deleteFromLast(int n){
        if(n==1){
           return deleteLast();
        }

        if(n==size){
            return deleteFirst();
        }

        return delete(size-n);
    }

    public boolean checkPalindrome(){
        int res=0;
        int powOfTen=1;

        Node temp=head;

        while(temp!=null){
            res+=temp.val*powOfTen;
            temp = temp.next;
            powOfTen = powOfTen*10;
        }

        int rev=0;
        int resTemp=res;
        int tenPower=(int)Math.pow(10, (int)(Math.log(resTemp)/Math.log(10)));

        while (resTemp>0) {
            int digit=resTemp%10;
            rev+=digit*tenPower;
            resTemp /= 10;
            tenPower/=10;
        }

        System.out.println(res + " " + rev);
        return rev==res;
    }

    public void reverse(){
        if (size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    public static void main(String[] args) {
        LL list=new LL();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        list.addLast(6);

        list.insert(7,2);

        Node head=list.head;
        for(int i=0; i<list.size; i++){
            System.out.println(head.val);
            head=head.next;
        }

        list.deleteFirst();

        head=list.head;
        for(int i=0; i<list.size; i++){
            System.out.println(head.val);
            head=head.next;
        }

        list.deleteLast();

        head=list.head;
        for(int i=0; i<list.size; i++){
            System.out.println(head.val);
            head=head.next;
        }

        list.delete(1);

        head=list.head;
        for(int i=0; i<list.size; i++){
            System.out.println(head.val);
            head=head.next;
        }

        System.out.println(list.checkPalindrome());

        list.reverse();

        head=list.head;
        for(int i=0; i<list.size; i++){
            System.out.println(head.val);
            head=head.next;
        }
    }
}