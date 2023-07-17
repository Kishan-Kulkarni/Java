package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class slidingWindow {
    public static int maxSubArraySum(int[] arr, int k){
        int sum=0;
        int max=Integer.MIN_VALUE;
        int i=0,j=0;
        while(j<arr.length){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){
                max=Math.max(max,sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return max;
    }

    public static void printFirstNeg(int[] arr, int k){
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(j<arr.length){
            if(arr[j]<0){
                list.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1 == k){
                if(list.size() == 0){
                    System.out.println(0);
                }else{
                    System.out.println(list.get(0));
                }
                if(list.size()!=0 && list.get(0)==arr[i]){
                    list.remove(0);
                }
                i++;
                j++;
            }
        }
    }

    public static int countAnagram(String s, String p){
        List<Character> curr=new ArrayList<>();
        int i=0, j=0;
        int count=0;
        while(j<s.length()){
            curr.add(s.charAt(j));
            if(j-i+1<p.length()){
                j++;
            } else if (j-i+1 == p.length()) {
                if(compare(p,curr)){
                    count++;
                }
                curr.remove(0);
                i++;
                j++;
            }
        }
        return count;
    }

    private static boolean compare(String p, List<Character> curr) {
        char[] ch=new char[curr.size()];
        for(int i=0; i < ch.length; i++){
            ch[i]= curr.get(i);
        }
        char[] ph=p.toCharArray();
        Arrays.sort(ph);
        Arrays.sort(ch);
        String pN=new String(ph);
        String cN=new String(ch);
        return pN.equals(cN);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int i=0, j=0;
        HashMap<Character, Integer> map=new HashMap<>();
        for(char c:p.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int count =map.size();
        HashMap<Character, Integer> temp= new HashMap<>(map);
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                if(temp.get(s.charAt(j))>0){
                    temp.put(s.charAt(j), temp.get(s.charAt(j))-1);
                    if(temp.get(s.charAt(j))==0){
                        count--;
                    }
                }
            }
            if(j-i+1<p.length()){
                j++;
            } else if (j-i+1 == p.length()) {
                if(count==0){
                    list.add(i);
                }
                if(map.containsKey(s.charAt(i))){
                    temp.put(s.charAt(i), temp.get(s.charAt(i))+1);
                    if(temp.get(s.charAt(i))!=0){
                        count=Math.min(count+1, map.size());
                    }
                }
                i++;
                j++;
            }
        }
        return list;
    }

    public static List<Integer> findMax(int[] arr, int k){
        int i=0, j=0;
        int max=Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        while (j<arr.length){
            max=Math.max(arr[j], max);
            if(max!=arr[j]){
                if(list.isEmpty() || list.get(0)<arr[j]){
                    list.add(0,arr[j]);
                }
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                ans.add(max);
                if(arr[i]==max){
                   max= list.get(0);
                }
                if(list.get(0)==arr[i]){
                    list.remove(0);
                }
                i++;
            }
        }

        return ans;
    }

    // **************************************************************** Variable length sliding window *********************************************************************

    public static int findLength(int[] arr, int k){
        int i=0, j=0;
        int sum=0;
        int max = 0;
        while(j<arr.length && i<=j){
            sum+=arr[j];
            if(sum==k){
                max=Math.max(max,j-i+1);
            }else if(sum>k){
                sum-=arr[i++];
            }
            j++;
        }

        return max;
    }

    public static int findSubString(String s, int k){
        int  i=0, j=0;
        int max=0;
        int curr=0;
        int[] chars=new int[26];
        while(j<s.length() && i<=j){
            char c=s.charAt(j);
            if (chars[c - 'a'] == 0) {
                curr++;
            }
            chars[c-'a']++;
            if(curr==k){
                max=Math.max(max, j-i+1);
            }else if(curr>k){
                char left=s.charAt(i);
                if(chars[left-'a']==1){
                    curr--;
                }
                chars[left-'a']--;
                i++;
            }
            j++;
        }
        return max;
    }

    public static String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        if(s.length()==t.length()){
            char[] sarr=s.toCharArray();
            char[] tarr=t.toCharArray();
            Arrays.sort(sarr);
            Arrays.sort(tarr);
            for(int i=0; i<sarr.length; i++){
                if(sarr[i]!=tarr[i]){
                    return "";
                }
            }
            return s;
        }

        HashMap<Character, Integer> tmap=new HashMap<>();
        for(int i=0; i<t.length(); i++){
            if(tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i), tmap.get(t.charAt(i))+1);
            }else{
                tmap.put(t.charAt(i),1);
            }
        }
        int i=0,j=0;
        StringBuilder ans=new StringBuilder();
        StringBuilder min=new StringBuilder(s);
        int curr=tmap.size();
        while(j<s.length() && i<=j){
            char c=s.charAt(j);
            char left=s.charAt(i);
            ans.append(c);
            if(tmap.containsKey(c) && tmap.get(c)!=0){
                tmap.put(c, tmap.get(c) - 1);
                if(tmap.get(c) == 0){
                    curr--;
                }
            }else if(tmap.containsKey(c) && tmap.get(c)==0){
                while(tmap.get(c)==0 || (curr==0 && !tmap.containsKey(left))){
                    i++;
                    ans.delete(0,1);
                    if(tmap.containsKey(left)){
                        if(tmap.get(left) == 0 && c!=left){
                            curr++;
                        }
                        if(c!=left)
                            tmap.put(left, tmap.get(left)+1);
                    }
                    if(tmap.get(c) != 0 && c!=left){
                        if(!(curr==0 && !tmap.containsKey(left)))
                            curr++;
                    }
                    left=s.charAt(i);

                }
            }

            if(curr==0){
                if(min.length()> ans.length()){
                    min=new StringBuilder(ans);
                }
            }else if(curr<0){
                while(curr<0){
                    i++;
                    ans.delete(0,1);
                    if(min.length()> ans.length()){
                        min=new StringBuilder(ans);
                    }
                    if(tmap.containsKey(left)){
                        tmap.put(left, tmap.get(left)+1);
                    }
                    if(tmap.containsKey(c)&& tmap.get(c) != 0){
                        curr++;
                    }
                    left=s.charAt(i);
                }
            }
            j++;
        }

        return helper(min, tmap);
    }

    private static String helper(StringBuilder min, HashMap<Character, Integer> tmap) {
        while(true){
            char left=min.charAt(0);
            if(tmap.containsKey(left)){
                break;
            }else{
                min.delete(0,1);
            }
        }
        return min.toString();
    }

    //class Solution {
    //    public String minWindow(String s, String t) {
    //        Map<Character, Integer> map=new HashMap();
    //        for(int i=0;i<t.length();i++){
    //            Character c=t.charAt(i);
    //            map.put(c, map.getOrDefault(c,0)+1);
    //        }
    //        int l=0;
    //        int matched=map.size();
    //        int minSize=Integer.MAX_VALUE;
    //        int startIndex=0;
    //        for(int r=0;r<s.length();r++){
    //            Character rChar=s.charAt(r);
    //            if(map.containsKey(rChar)){
    //                map.put(rChar, map.get(rChar)-1);
    //                if(map.get(rChar)==0) matched--;
    //            }
    //            while(l<=r && matched==0){
    //                if(minSize>r-l+1){
    //                    minSize=r-l+1;
    //                    startIndex=l;
    //                }
    //                Character lChar=s.charAt(l);
    //                if(map.containsKey(lChar)){
    //                    map.put(lChar, map.get(lChar)+1);
    //                    if(map.get(lChar)>0) matched++;
    //                }
    //                l++;
    //            }
    //        }
    //        return minSize==Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+minSize);
    //    }
    //}

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
