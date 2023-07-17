import java.util.*;

public class ew {

    static HashMap<Character, String> map=new HashMap<>();
    static int[][] t;
    public static void main(String[] args) {
//        int[][] time={{1,10},{4,5},{2,3}};
//        for(int[] n:overlappedInterval(time)){
//            System.out.println(Arrays.toString(n));
//        }
        int[] w = new int[]{1, 3, 4, 5};
        int[] v = new int[] {1,4,5,7};
        int W=7;
        int[][] dp=new int[w.length+1][W+1];

        for(int i=1; i<dp.length; i++){
            for(int j = 1; j< dp[0].length; j++){
                if(w[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j-w[i-1]]+v[i-1], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }


    public static int knapSack(int[] w, int[] v, int W, int n){
        if(n==0 || W==0){
            return 0;
        }
        if(t[n][W]!=-1){
            return t[n][W];
        }
        if(w[n-1]>W){
            return t[n][W]=knapSack(w,v,W,n-1);
        }
        return t[n][W]=Math.max(knapSack(w,v,W-w[n-1], n-1)+v[n-1], knapSack(w,v,W,n-1));
    }

    public static char findKthBit(int n, int k){
        k=k%n;
        if(n==1){
            return '0';
        }

        int ans=helper(n-1, k-1);
        return '0';
    }

    private static int helper(int n, int k) {
        if(n==0){
            return 0;
        }

        if(k==(int)Math.pow(2,n)-1){
            return 1;
        }

        return 0;
    }

    public static int findTargetSumWays(int[] candidates, int target){
        return helper(candidates, target, candidates.length);
    }

    private static int helper(int[] candidates, int target, int n) {
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }

        return helper(candidates, target-candidates[n-1],n-1) + helper(candidates, target+candidates[n-1], n-1);
    }

    public static boolean exist(char[][] board, String word){
        boolean[][] track=new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if(helper(board, word,i,j,track,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String word, int i, int j, boolean[][] track, int idx) {
        if(idx>=word.length()){
            return true;
        }

        if(i>= board.length ){
            return false;
        }
        if(i<0 ){
            return false;
        }
        if( j>=board[0].length ){
            return false;
        }
        if( j<0){
            return false;
        }

        if(word.isEmpty()){
            return true;
        }

        if(word.charAt(idx)!=board[i][j]){
            return false;
        }

        boolean res=false;

        if(!track[i][j]){
            track[i][j]=true;
            char c=word.charAt(idx);
            res= helper(board, word, i + 1, j, track,idx+1) || helper(board, word, i - 1, j, track,idx+1) || helper(board, word, i, j + 1, track,idx+1) || helper(board, word, i, j - 1, track,idx+1);
            track[i][j]=false;
        }

        return res;
    }

    public  static void bubbleSortRec2(int[] arr, int i, int j){
        if(i>=arr.length){
            return;
        }

        if(j>= arr.length){
            bubbleSortRec2(arr,i+1, i+2);
            return;
        }

        if(arr[i]>arr[j]){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        bubbleSortRec2(arr,i,j+1);
    }

    public static void reverseString(char[] str, int i){
        if(i>=str.length/2){
            return;
        }

        char temp=str[i];
        str[i]=str[str.length-1-i];
        str[str.length-1-i]=temp;

        reverseString(str,i+1);

    }

    public static char printFirstCaps(String s){
        if(s.isEmpty()){
            return '#';
        }

        char c=s.charAt(0);
        if(c>='A' && c<'Z'){
            return c;
        }

        return printFirstCaps(s.substring(1));
    }
    public static void printTriangleArray(int[] arr){
        if(arr.length==0){
            return;
        }

        int[] newArr=new int[arr.length-1];
        for(int i=0; i<newArr.length; i++){
            newArr[i]=arr[i]+arr[i+1];
        }
        printTriangleArray(newArr);
        System.out.println(Arrays.toString(arr));
    }

    public static ArrayList<String> printDiceWaysRet(int n, String op){
        if(n==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(op);
            return list;
        }

        if(n<0){
            return new ArrayList<>();
        }

        ArrayList<String> list=new ArrayList<>();

        for(int i=1; i<=6; i++){
            list.addAll(printDiceWaysRet(n-i, op+i));
        }

        return list;
    }

    public static void printDiceWays(int n, String op){
        if(n==0){
            System.out.println(op);
            return;
        }

        if(n<0){
            return;
        }

        for(int i=1; i<=6; i++){
            printDiceWays(n-i, op+i);
        }
    }

    public static int printNumberCombCount(String ip, String op){
        if(ip.isEmpty()){
            return 1;
        }

        int count=0;
        char c=ip.charAt(0);
        String digits=map.get(c);

        for (int i = 0; i < digits.length(); i++) {
            count+=printNumberCombCount(ip.substring(1), op+digits.charAt(i));
        }

        return count;

    }

    public static ArrayList<String> printNumberCombRet(String ip, String op){
        if(ip.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(op);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        char c=ip.charAt(0);
        String digits=map.get(c);

        for (int i = 0; i < digits.length(); i++) {
            list.addAll(printNumberCombRet(ip.substring(1), op+digits.charAt(i)));
        }

        return list;
    }

    public static void printNumberComb(String ip , String op){
        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        char c=ip.charAt(0);
        String digits=map.get(c);

        for (int i = 0; i < digits.length(); i++) {
            printNumberComb(ip.substring(1), op+digits.charAt(i));
        }
    }

    public static ArrayList<String> printAllPermsRet(String ip, String op) {
        if(ip.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(op);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        char c=ip.charAt(0);

        for(int i=0; i<=op.length(); i++){
            String f=op.substring(0,i);
            String s=op.substring(i);
            list.addAll(printAllPermsRet(ip.substring(1), f+c+s));
        }

        return list;
    }

    public static void printAllPerms(String ip, String op){
        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        char c=ip.charAt(0);

        for(int i=0; i<=op.length(); i++){
            String f=op.substring(0,i);
            String s=op.substring(i);
            printAllPerms(ip.substring(1), f+c+s);
        }
    }

    public static void printAllBinaryCase2(int o, int z, String op, int n){
        if(o+z == n){
            System.out.println(op);
            return;
        }

        printAllBinaryCase(o+1, z, op+'1', n);

        if(o>z){
            printAllBinaryCase(o, z+1, op+'0', n);
        }

    }

    public static void printAllBinaryCase(int o, int z, String op, int n){
        if(o+z == n){
            if(o<z){
                return;
            }
            System.out.println(op);
            return;
        }

        if(o==0){
            printAllBinaryCase(o+1, z, op+'1', n);
            return;
        }


        if(o>=z){
            printAllBinaryCase(o+1, z, op+'1', n);
            printAllBinaryCase(o, z+1, op+'0', n);
        }
    }

    public static void printAllParenthesis(int o, int c, String op){
        if(o==0 && c==0){
            System.out.println(op);
            return;
        }

        if(o==0){
            printAllParenthesis(o, c-1, op+')');
            return;
        }

        if(o==c){
            printAllParenthesis(o-1, c, op+'(');
            return;
        }

        printAllParenthesis(o-1, c, op+'(');
        printAllParenthesis(o, c-1, op+')');
    }

    public static void printAllCasesPerm(String ip, String op){
        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        char c=ip.charAt(0);
        if(c>='0' && c<='9'){
            printAllCasesPerm(ip.substring(1), op+c);
        }else if(c >= 'A' && c <= 'Z'){
            printAllCasesPerm(ip.substring(1), op+c);
            printAllCasesPerm(ip.substring(1), op+Character.toLowerCase(c));
        }else if (c >= 'a' && c <= 'z'){
            printAllCasesPerm(ip.substring(1), op+c);
            printAllCasesPerm(ip.substring(1), op+Character.toUpperCase(c));
        }
    }

    public static void printCasesPerm(String ip, String op){
        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        char c=ip.charAt(0);
        printCasesPerm(ip.substring(1), op+c);
        printCasesPerm(ip.substring(1), op+Character.toUpperCase(c));
    }

    public static void printPermSpaces(String ip, String op){
        if(ip.isEmpty()){
            System.out.println(op);
            return;
        }

        if(op.isEmpty()){
            op+=ip.charAt(0);
            printPermSpaces(ip.substring(1), op);
            return;
        }

        char c= ip.charAt(0);
        printPermSpaces(ip.substring(1), op+' '+c);
        printPermSpaces(ip.substring(1), op+c);

    }

    public static char kthSysmbol(int n,int k){
        StringBuilder sb=new StringBuilder("0");
        return getKth(sb, n-1,k-1,sb.length());
    }

    private static char getKth(StringBuilder sb, int n, int k, int i) {
        if(i<0){
           return getKth(sb, n-1,k, sb.length());
        }

        if(n==0){
            return sb.charAt(k);
        }

        sb.deleteCharAt(sb.length()-i);
        if(sb.charAt(i)=='0'){
            return getKth(sb.insert(sb.length()-i+1,"01"), n, k,i-1);
        }

         return getKth(sb.insert(sb.length()-i+1,"10"), n, k,i-1);
    }

    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }

        int temp=st.pop();
        reverseStack(st);
        pushRev(st,temp);
    }

    private static void pushRev(Stack<Integer> st, int temp) {
        if(st.isEmpty()){
            st.push(temp);
            return;
        }

        int head=st.pop();
        pushRev(st,temp);
        st.push(head);
    }

    @SuppressWarnings("unchecked")
    public static void deleteMidStack(Stack<Integer> st){
        Stack<?> temp=(Stack<?>) st.clone();
        int len=getStackLen((Stack<Integer>) temp);
        helper(st, 0, len);
    }

    private static void helper(Stack<Integer> st, int i, int len) {
        if(i==len/2){
            st.pop();
            return;
        }

        int temp=st.pop();
        helper(st,i+1,len);
        st.push(temp);
    }

    private static int getStackLen(Stack<Integer> st) {
        if(st.isEmpty()){
            return 0;
        }
        st.pop();
        return 1+getStackLen(st);
    }

    public static void sortStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }

        int temp=st.pop();
        sortStack(st);
        if(st.isEmpty() || st.peek()>temp){
            shuffleStack(st, temp);
            return;
        }
        st.push(temp);
    }

    private static void shuffleStack(Stack<Integer> st, int temp) {
        if(st.isEmpty()){
            st.push(temp);
            return;
        }

        if(st.peek()<temp){
            st.push(temp);
            return;
        }

        int top=st.pop();
        shuffleStack(st,temp);
        st.push(top);
    }

    public static void bubbleSortRec(int[] arr, int i, int j){
        if(i>=arr.length){
            return;
        }

        if(j>=arr.length){
            bubbleSortRec(arr, i+1, i+2);
            return;
        }

        if(arr[i]>arr[j]){
            arr[i]=arr[i]^arr[j];
            arr[j]=arr[i]^arr[j];
            arr[i]=arr[i]^arr[j];
        }

        bubbleSortRec(arr,i,j+1);
    }

    public static int maxValue(int n, int index, int maxSum) {
        int s=1;
        int e=maxSum;
        int res=0;

        while(s<=e){
            int m=s+(e-s)/2;

            if(isMaxPossible(n, index, maxSum, m)){
                res=m;
                s=m+1;
            }else{
                e=m-1;
            }
        }

        return res;
    }

    public static boolean isMaxPossible(int n, int index, int maxSum, int m){
        int ele=m;
        int sum=m;

        for(int i=0; i<index; i++){
            ele--;
            if(ele==0){
                sum=sum+i+1;
                break;
            }
            sum+=ele;
        }

        if(sum>maxSum){
            return false;
        }

        ele=m;

        for(int i=index+1; i<n; i++){
            ele--;
            if(ele==0){
                sum=sum+n-i;
                break;
            }
            sum+=ele;
        }

        if(sum>maxSum){
            return false;
        }

        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int s=0;
        int e=Integer.MAX_VALUE;
        int res=-1;

        while(s<=e){
            int m=s+(e-s)/2;

            if(isValid(piles, m, h)){
                res=m;
                e=m-1;
            }else{
                s=m+1;
            }
        }

        return res;
    }


    public static boolean isValid(int[] piles, int m, int h){
        int sum=0;

        for (int pile : piles) {
            double hrs=(double) pile / m;
            sum += Math.ceil(hrs);
            if (sum > h) {
                return false;
            }
        }

        return true;
    }

    private static int binaryNearly(int[] arr, int target) {
        int s =0;
        int e=arr.length - 1;

        while (s<=e) {
            int m=s+(e-s)/2;

            if(arr[m]==target){
                return m;
            }

            if(m>0 && arr[m-1]==target){
                return m-1;
            }

            if(m<arr.length-1 && arr[m+1] == target){
                return m+1;
            }

            if(arr[m]<target){
                s=m+2;
            }else if(arr[m]>target){
                e=m-2;
            }
        }

        return -1;
    }

    public static int binaryRBS(int[] arr, int target){
        int pivot = findPivotRBS(arr);

        if(arr[0]<=target){
            return binarySearch(arr, 0, pivot, target);
        }else{
            return binarySearch(arr, pivot+1, arr.length-1, target);
        }
    }
    public static int findPivotRBS(int[] arr){
        int s=0;
        int e=arr.length - 1;

        while(s<=e){
            int m=(e-s)/2 +s;
            if(m<arr.length-1 && arr[m]>arr[m+1]){
                return m;
            }

            if(m>0 && arr[m]<arr[m-1]){
                return m-1;
            }

            if(arr[m]==arr[s] && arr[m]==arr[e]){
                e--;
                continue;
            }

            if(arr[m]>=arr[s]){
                s=m+1;
            }else if(arr[m]<arr[s]){
                e=m-1;
            }
        }

        return e;
    }

    public static int[] findFirstAndLastPosition(int [] arr , int target){
        int first = binarySearchLeft(arr,target);
        int last= binarySearchRight(arr,target);

        if(first==-1 || last==-1){
            return new int[] {-1, -1};
        }

        return new int[] {first, last};
    }

    private static int binarySearchRight(int[] arr, int target) {
        int s=0;
        int e=arr.length - 1;

        while(s<=e){
            int m=(e-s)/2 +s;

            if(arr[m]==target){
                if(m<arr.length-1 && arr[m]==arr[m+1]){
                    s=m+1;
                }else if(m<arr.length-1 && arr[m]!=arr[m+1]){
                    return m;
                }else if(m== arr.length-1){
                    return m;
                }

            }

            if(arr[m]>target){
                e=m-1;
            }else if(arr[m]<target){
                s=m+1;
            }
        }

        return -1;
    }

    private static int binarySearchLeft(int[] arr, int target) {
        int s=0;
        int e=arr.length - 1;

        while(s<=e){
            int m=(e-s)/2 +s;

            if(arr[m]==target){
                if(m>0 && arr[m]==arr[m-1]){
                    e=m-1;
                }else if(m>0 && arr[m]!=arr[m-1]){
                    return m;
                }else if (m==0){
                    return m;
                }

            }

            if(arr[m]>target){
                e=m-1;
            }else if(arr[m]<target){
                s=m+1;
            }
        }

        return -1;
    }

    public static int[] fairCandySwap(int[] a, int[] b){
        Arrays.sort(b);
        int[] ans={-1,-1};
        int aSum=0;
        int bSum = 0;
        for(int i:a){
            aSum+=i;
        }
        for(int i:b){
            bSum+=i;
        }

        for(int i:a){
            int swap=bSum-aSum+i;
            if(swap<0){
                continue;
            }else{
                int idx=binarySearch(b,0,b.length-1,swap);
                if(idx!=-1){
                    ans[0]=i;
                    ans[1]=swap;
                }
            }
        }
        return ans;
    }

    public static int[] findIntersectiontwo(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map =new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int j:nums1){
            if(map.containsKey(j)){
                map.put(j, map.get(j)+1);
            }else{
                map.put(j,1);
            }
        }

        for(int j:nums2){
            if (map.containsKey(j) && map.get(j)>0) {
                list.add(j);
                map.put(j ,map.get(j) - 1);
            }
        }

        int[] ans=new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }

        return ans;
    }

    public static int[] findIntersection(int[] nums1, int[] nums2){
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> ans=new ArrayList<>();

        for (int j : nums1) {
            set.add(j);
        }

        for(int j: nums2){
            if(set.contains(j) && !ans.contains(j)){
                ans.add(j);
            }
        }

        int[] a= new int[ans.size()];
        int i=0;
        for(int j:ans){
            a[i]=j;
            i++;
        }

        return a;
    }

    public static int findPeak(int[] arr){
        int s =0;
        int e= arr.length-1;

        while (s<=e){
            int m=(e-s)/2 +s;

            if(m>0 && m<arr.length-1 &&arr[m]>arr[m-1] && arr[m]>arr[m+1]){
                return m;
            }

            if(m<arr.length-1 && arr[m+1]>=arr[m]){
                s=m+1;
            }else if(m<arr.length-1 && arr[m+1]<arr[m]){
                e=m-1;
            }
        }

        return -1;
    }

    public static char searchGreater(char[] letters, char target){
        int s=0;
        int e=letters.length-1;
        int m=0;

        while(s<=e){
            m =(e-s)/2 + s;

//            if(letters[m]==target){
//                if(m<letters.length-1){
//                    return letters[m+1];
//                }
//
//                return letters[0];
//            }

            if(letters[m]<=target){
                s=m+1;
            }else{
                e=m-1;
            }
        }

        if(s>=letters.length-1 && letters[m]<=target){
            return letters[0];
        }

        if(letters[m]<=target){
            return letters[m+1];
        }

        return letters[m];
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=binaryLeft(nums, target);
        if(ans[0]==-1){
            ans[1]=-1;
            return ans;
        }

        ans[1]=binaryRight(nums, target);

        return ans;
    }

    public static int binaryLeft(int[] nums, int target){
        int s=0;
        int e=nums.length-1;
        int m=(e-s)/2 +s;


        while(s<=e){
            m=(e-s)/2 +s;
            if(nums[m]==target){
                e=m-1;
            }else if(nums[m]<target){
                s=m+1;
            }else{
                e=m-1;
            }
        }

        if(nums[m]==target){
            return m;
        }

        return -1;
    }

    public  static int binaryRight(int[] nums, int target){
        int s=0;
        int e=nums.length-1;
        int m=(e-s)/2 +s;
        int ans=-1;

        while(s<=e){
            m=(e-s)/2 +s;
            if(nums[m]==target){
                ans=m;
                s=m+1;
            }else if(nums[m]<target){
                s=m+1;
            }else{
                e=m-1;
            }
        }

        return ans;
    }
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list =new ArrayList<>();

        boolean rl=false, rr=true, cd=false , cu=false;
        int ruo=0, clo=0,rdo=0,cro=0 ,count=0;
        int row=matrix.length, col=matrix[0].length;

        while(count!=row*col){
            if(rr){
                for(int i=clo; i<col-cro; i++){
                    list.add(matrix[ruo][i]);
                    count++;
                }
                rr=false;
                rl=false;
                cd=true;
                cu=false;
                ruo++;
                continue;
            }

            if(cd){
                for(int i=ruo; i<row-rdo; i++){
                    list.add(matrix[i][col-1-cro]);
                    count++;
                }
                rr=false;
                rl=true;
                cd=false;
                cu=false;
                cro++;
                continue;
            }

            if(rl){
                for(int i=col-1-cro; i>=clo; i--){
                    list.add(matrix[row-1-rdo][i]);
                    count++;
                }
                rr=false;
                rl=false;
                cd=false;
                cu=true;
                rdo++;
                continue;
            }

            if(cu){
                for(int i=row-1-rdo; i>=ruo; i--){
                    list.add(matrix[i][clo]);
                    count++;
                }
                rr=true;
                rl=false;
                cd=false;
                cu=false;
                clo++;
                continue;
            }
        }

        System.gc();
        return list;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int kDig = (int)(Math.log10(k)) + 1;
        int[] numK=new int[kDig];
        List<Integer> list=new ArrayList<>();

        if(num.length>numK.length){
            for(int i=numK.length-1; i>=0; i--){
                numK[i]=k%10;
                k/=10;
            }

            int i=num.length-1, j=numK.length-1;
            while(i>=0 && j>=0){
                num[i]=num[i]+numK[j];
                i--;
                j--;
            }
            int carry=0;
            for(int x=num.length-1; x>=0; x--){
                if(x==num.length-1){
                    list.add(0 , num[x]%10);
                    carry=num[x]/10;
                }else{
                    list.add(0, (num[x]+carry)%10);
                    carry=(num[x]+carry)/10;
                }
            }

            if(carry!=0){
                list.add(0, carry);
            }
        }else{
            for(int i=numK.length-1; i>=0; i--){
                numK[i]=k%10;
                k/=10;
            }

            int i=num.length-1, j=numK.length-1;
            while(i>=0 && j>=0){
                numK[j]=num[i]+numK[j];
                i--;
                j--;
            }
            int carry=0;
            for(int x=numK.length-1; x>=0; x--){
                if(x==numK.length-1){
                    list.add(0 , numK[x]%10);
                    carry=numK[x]/10;
                }else{
                    list.add(0, (numK[x]+carry)%10);
                    carry=(numK[x]+carry)/10;
                }
            }

            if(carry!=0){
                list.add(0, carry);
            }
        }

        return list;
    }
    public static String printLargest(String[] arr){
        StringBuilder ans=new StringBuilder();

        Arrays.sort(arr,  new Comparator<String>() {
            public int compare(String s1, String s2) {
                int i;
                for(i=0; i<s1.length() && i<s2.length(); i++){
                    if(s1.charAt(i)-'0' >s2.charAt(i)-'0'){
                        return -1;
                    }else if(s1.charAt(i)-'0' <s2.charAt(i)-'0'){
                        return 1;
                    }
                }
                if(s1.length()>s2.length()){
                    if(s1.charAt(i)-'0'==0){
                        return 1;
                    }else{
                        return -1;
                    }
                }else if(s1.length()<s2.length()){
                    if(s2.charAt(i)-'0'==0){
                        return 1;
                    }else{
                        return 1;
                    }
                }
                return 0;
            }
        });

        for(String s:arr){
            ans.append(s);
        }

        return ans.toString();
    }


    public static int getMerge(int[] nums){
        int ans=0;
        int s=0;
        int e=nums.length-1;
        ArrayList<Integer> list=new ArrayList<>();
        for(int n: nums){
            list.add(n);
        }

        while(s<e){
            if(nums[s]==nums[e]){
                s++;
                e--;
            }else{


                if(nums[s]>nums[e]){
                    int replace= list.get(e)+ list.get(e-1);
                    list.remove(e);
                    e--;
                    list.remove(e);
                    list.add(e,replace);
                }else{
                    int replace= list.get(s) + list.get(s+1);
                    list.remove(s);
                    list.remove(s);
                    list.add(s,replace);
                    e--;
                    if(Objects.equals(list.get(s), list.get(list.size() - 1 - s))){
                        s++;
                    }
                }
                ans++;
            }
        }

        return ans;
    }

    public static int[][] overlappedInterval(int[][] Intervals)
    {
        if(Intervals.length==1){
            return Intervals;
        }

        Arrays.sort(Intervals, new Comparator<int[]>() {
            public int compare(int[] frst, int[] scnd) {
                if(frst[1] > scnd[1]) {
                    return 1;
                }
                else return -1;
            }
        });



        ArrayList<int[]> list=new ArrayList<>();
        int st=Intervals[0][0];
        int et=Intervals[0][1];

        for(int i=0; i<Intervals.length; i++){
            if(Intervals[i][0]<=et || et<=Intervals[i][1]){
                st=Math.min(st,Intervals[i][0]);
                et=Math.max(et,Intervals[i][1]);
            }else{
                list.add(new int[]{st,et});
                st=Intervals[i][0];
                et=Intervals[i][1];
            }
        }

        int[] check={st,et};

        if(!list.contains(check)){
            list.add(check);
        }

        if(list.get(list.size()-1)[1]>=st){
            int s=list.get(list.size()-1)[0];
            int e=list.get(list.size()-1)[1];
            list.remove(list.size()-1);
            list.add(new int[]{Math.min(st,s), Math.max(et,e)});
        }

        int[][] ans=new int[list.size()][2];

        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }

        return ans;
    }
    public static int partition(int[] arr,int low, int high) {
        int temp;
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return (i + 1);
    }

    public static int kthSmallest(int[] a, int left, int right, int k) {
        while (left <= right)
        {
            int pivotIndex = partition(a, left, right);
            if (pivotIndex == k - 1)
                return a[pivotIndex];
            else if (pivotIndex > k - 1)
                right = pivotIndex - 1;
            else
                left = pivotIndex + 1;
        }
        return -1;
    }

    public static int maxArea(int[] height) {
        int s=0;
        int e=height.length-1;
        int max=0;
        while(s<e){
            int curr=Math.min(height[s],height[e])*(e-s);
            if(curr>max){
                max=curr;
            }

            if(Math.min(height[s+1],height[e])*(e-s-1)>Math.min(height[s],height[e-1])*(e-1-s)){
                s++;
            }else if(Math.min(height[s+1],height[e])*(e-s-1)<Math.min(height[s],height[e-1])*(e-1-s)){
                e--;
            }else{
                s++;
                e--;
            }
        }

        return max;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        int s=0;
        int e=nums.length-1;
        HashMap<Integer, Integer> map=new HashMap<>();
        Arrays.sort(nums);

        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else{
                map.put(n,1);
            }
        }

        while(s<e){
            ArrayList<Integer> temp=new ArrayList<>();
            if(map.containsKey(-(nums[s]+nums[e]))){
                if(-(nums[s]+nums[e])==nums[e]){
                    if(map.get(nums[e])>1){
                        temp.add(nums[s]);
                        temp.add(nums[e]);
                        temp.add(nums[e]);
                        if(!contains(list, temp)){
                            list.add(temp);
                        }
                    }
                }else if(-(nums[s]+nums[e])==nums[s]){
                    if(map.get(nums[s])>1){
                        temp.add(nums[s]);
                        temp.add(nums[s]);
                        temp.add(nums[e]);
                        if(!contains(list, temp)){
                            list.add(temp);
                        }
                    }
                }else{
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    temp.add(-(nums[s]+nums[e]));
                    if(!contains(list, temp)){
                        list.add(temp);
                    }
                }

                if(nums[s]+nums[e]>0){
                    e--;
                }else if(nums[s]+nums[e]<0){
                    s++;
                }else{
                    if(nums[s+1]+nums[e]>nums[s]+nums[e-1]){
                        e--;
                    }else{
                        s++;
                    }
                }
            }else{
                if(nums[s]+nums[e]>0){
                    e--;
                }else if(nums[s]+nums[e]<0){
                    s++;
                }else{
                    if(nums[s+1]+nums[e]>nums[s]+nums[e-1]){
                        e--;
                    }else{
                        s++;
                    }
                }
            }
        }

        return list;
    }

    private static boolean contains(List<List<Integer>> list, ArrayList<Integer> temp) {

        for (List<Integer> integers : list) {
            boolean contains = true;
            for (Integer integer : temp) {
                if (!integers.contains(integer)) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                return true;
            }
        }

        return false;
    }

    public static boolean twoSumRotated(int[] arr, int sum){
        int s=rbsPivot(arr);
        int e=s-1;
        if(s==0){
            e=arr.length-1;
        }

        while (e != s) {
            if (e < 0) {
                e = arr.length - 1;
            }
            if (s > arr.length - 1) {
                s = 0;
            }

            if (arr[e] + arr[s] > sum) {
                e--;
            } else if (arr[e] + arr[s] < sum) {
                s++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static int rbsPivot(int[] arr){
        if(arr[0]<=arr[arr.length-1]){
            return 0;
        }

        if(arr.length==2){
            if(arr[0]<arr[1]){
                return 0;
            }else{
                return 1;
            }
        }

        int s=0;
        int e=arr.length-1;
        int m=0;

        while(s<e){
            m=(e-s)/2 +s;

            if(m<arr.length-1 && arr[m]>arr[m+1]){
                return m+1;
            }

            if(m>0 && m<arr.length-1 && arr[m-1]>arr[m] && arr[m+1]>arr[m]){
                return m;
            }

            if(m>0 && m<arr.length-1 && arr[m-1]<arr[m] && arr[m+1]<arr[m]){
                return m+1;
            }


            if(m>0 && m<arr.length-1 && arr[m-1]<arr[m] && arr[m+1]>arr[m]){
                if(arr[m]>arr[arr.length-1]){
                    s=m+1;
                }else{
                    e=m-1;
                }
            }
        }

        return m;
    }
    public static void prefixSum(int[] arr){
        int sumSoFar=0;

        for(int i=0; i<arr.length; i++){
            arr[i]+=sumSoFar;
            sumSoFar=arr[i];
        }

        System.out.println(Arrays.toString(arr));

    }

    public static int findKthLargest(int[] nums, int k) {
        int ans=Integer.MIN_VALUE;

        while(k>1){
            int maxIdx=0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]>nums[maxIdx]){
                    maxIdx=i;
                }
            }
            nums[maxIdx]=Integer.MIN_VALUE;
            k--;
        }

        for(int n:nums){
            if(n>ans){
                ans=n;
            }
        }

        return ans;
    }

    public static int maxProfit(int[] nums) {
        int max=0;
        int s=0;
        int e= nums.length-1;

        while(s<e){
            if(nums[e]-nums[s]>max){
                max=nums[e]-nums[s];
            }

            if(nums[e-1]-nums[s]>=nums[e]-nums[s+1]){
                e--;
                continue;
            }

            if(nums[e-1]-nums[s]<nums[e]-nums[s+1]){
                s++;
                continue;
            }

            s++;
            e--;
        }

        return max;
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        if(pivot>=0 && pivot<nums.length){
            if(nums[pivot]==target){
                return pivot;
            }else if(nums[pivot]<target && nums[nums.length-1]>=target){
                return binarySearch(nums, pivot, nums.length-1, target);
            }else{
                return binarySearch(nums, 0, pivot-1 , target);
            }
        }

        return -1;
    }

    public static int findPivot(int[] nums){
        int s=0;
        int e=nums.length-1;
        int m=0;

        while(s<e){
            m=(e-s)/2 + s;

            if((m>0 && m<nums.length-1)&& (nums[m]<nums[m-1] && nums[m]<nums[m+1])){
                return m;
            }
            if((m>0 && m<nums.length-1)&& (nums[m]>nums[m-1] && nums[m]>nums[m+1])){
                return m+1;
            }
            if((m>0 && m<nums.length-1)&& (nums[m-1]<nums[m-2] && nums[m-1]<nums[m])){
                return m+1;
            }

            if((m>0 && m<nums.length-1)&& (nums[m]>nums[m-1] && nums[m]<nums[m+1])){
                s=m+1;
            }else if((m>0 && m<nums.length-1)&& (nums[m]<nums[m-1] && nums[m]>nums[m+1])){
                e=m;
            }

            if(m==0 || m==nums.length - 1){
                return m;
            }
        }

        return m;
    }

    public static int binarySearch(int[] nums, int start, int end, int target){
        int s=start;
        int e=end;

        while(s<=e){
            int m=(e-s)/2 +s;

            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                e=m-1;
            }else{
                s=m+1;
            }
        }

        return -1;
    }
    public static String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();

        while(n>0){
            int incr=((n-1)%26);
            char a= (char) ('A'+incr);
            sb.append(a);
            n/=26;
        }

        return sb.reverse().toString();
    }

    public static boolean happy(int n){
        int curr=n;
        int prev =0;
        boolean res=false;

        if(curr==1){
            return true;
        }

        while(curr!=1){
            prev=curr;
            curr=findSumSq(curr);


            if(curr==1){
                res=true;
            }

            if(prev==curr){
                break;
            }
        }

        return res;
    }

    public static int findSumSq(int n){
        int ans=0;

        while(n>0){
            ans+=(n%10)*(n%10);
            n=n/10;
        }

        return ans;
    }

    public static int[] findErrorNums(int[] nums) {
        int[] ans=new int[2];
        int exp=0;
        int acc=0;

        for(int n:nums){
            acc^=n;
        }

        for(int i=1; i<=nums.length; i++){
            exp^=i;
        }

        System.out.println(acc ^ exp);

        return ans;
    }
    public static int findComplement(int num) {
        int ans=0;
        int base =1;
        StringBuilder n=new StringBuilder(Integer.toBinaryString(num));
        n.reverse();
        for(int i=0; i<n.length(); i++){
            if(n.charAt(i)=='0'){
                ans+=base;
            }
            base*=2;
        }

        return ans;
    }

    public static double func(int n, double ans){
        return ans*ans -n;
    }

    public static String customMethod(String a, String b){
        StringBuilder ans=new StringBuilder();
        StringBuilder num1=new StringBuilder(a);
        StringBuilder num2=new StringBuilder(b);
        num1.reverse();
        num2.reverse();

        if(num1.length()>num2.length()){
            while(num1.length()>num2.length()){
                num2.append('0');
            }
        }

        if(num2.length()>num1.length()){
            while(num2.length()>num1.length()){
                num1.append('0');
            }
        }

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num1.length()==num2.length());

        int carry=0;

        for(int i=0; i<num1.length(); i++){
            if(num1.charAt(i)=='0' && num2.charAt(i)=='0' && carry==0){
                ans.append('0');
                continue;
            }
            if(num1.charAt(i)=='0' && num2.charAt(i)=='0' && carry==1){
                ans.append('1');
                carry=0;
                continue;
            }
            if((num1.charAt(i)=='1' && num2.charAt(i)=='0' && carry==0 ) || (num1.charAt(i)=='0' && num2.charAt(i)=='1' && carry==0)){
                ans.append('1');
                continue;
            }

            if((num1.charAt(i)=='1' && num2.charAt(i)=='0' && carry==1 ) || (num1.charAt(i)=='0' && num2.charAt(i)=='1' && carry==1)){
                ans.append('0');
                continue;
            }

            if((num1.charAt(i)=='1' && num2.charAt(i)=='1' && carry==0 ) ){
                ans.append('0');
                carry=1;
                continue;
            }
            if((num1.charAt(i)=='1' && num2.charAt(i)=='1' && carry==1 ) ){
                ans.append('1');
            }
        }

        if(carry==1){
            ans.append('1');
        }

        return ans.reverse().toString();
    }

    public static int hammingWeight(int n) {
        int ans=0;

        if(n<0){
            n=~n+1;

            int exp=oneBits(n);
            if(exp==0){
                return 1;
            }
            return 32-exp+1;
        }

        ans=oneBits(n);

        return ans;
    }

    public static int oneBits(int n){
        int ans=0;
        while(n>=1){
            if((n&1)==1){
                ans++;
            }
            n=n>>1;
        }

        return ans;
    }
}
