package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class addNumbersInArrayForm {
    public static void main(String[] args) {
        System.out.println(addNums(new int[]{2,1,5}, 806));
    }

    public static List<Integer> addNums(int[] num, int k){
        List<Integer> list=new ArrayList<Integer>();
        int kDig = (int)(Math.log10(k)) + 1;
        if(kDig<=num.length){
            int i=num.length-1;
            while(k>0){
                num[i]+=k%10;
                k/=10;
                i--;
            }


            boolean addCarry=num[num.length-1]>=10;
            int carry=0;
            for(i=num.length-1; i>=0; i--){
                if(addCarry){
                    int ele=num[i]+carry;
                    list.add(0, ele%10);
                    if(ele<10){
                        addCarry=false;
                        carry=0;
                    }else{
                        addCarry=true;
                        carry=ele/10;
                    }
                }else{
                    int ele=num[i]%10;
                    if(num[i]>=10){
                        addCarry=true;
                        carry=num[i]/10;
                        list.add(0, ele);
                    }else{
                        addCarry=false;
                        list.add(0, ele);
                        carry=0;
                    }
                }
            }

            if(carry!=0){
                int ele=list.get(0);
                list.remove(0);
                list.add(0, ele+10*carry);
            }

            if(list.get(0)>=10){
                int ele=list.get(0);
                list.remove(0);
                list.add(0,ele%10);
                list.add(0,ele/10);
            }
        }else{
            List<Integer> temp=new ArrayList<Integer>();
            int i=num.length-1;
            while(k>0){
                if(i>=0){
                    temp.add(0,k%10+num[i]);
                    i--;
                }else{
                    temp.add(0,k%10);
                }
                k/=10;
            }
            num=new int[temp.size()];
            for(i=0; i<num.length; i++){
                num[i]=temp.get(i);
            }

            boolean addCarry=num[num.length-1]>=10;
            int carry=0;
            for(i=num.length-1; i>=0; i--){
                if(addCarry){
                    int ele=num[i]+carry;
                    list.add(0, ele%10);
                    if(ele<10){
                        addCarry=false;
                        carry=0;
                    }else{
                        addCarry=true;
                        carry=ele/10;
                    }
                }else{
                    int ele=num[i]%10;
                    if(num[i]>=10){
                        addCarry=true;
                        carry=num[i]/10;
                        list.add(0, ele);
                    }else{
                        addCarry=false;
                        list.add(0, ele);
                        carry=0;
                    }
                }
            }

            if(carry!=0){
                int ele=list.get(0);
                list.remove(0);
                list.add(0, ele+10*carry);
            }

            if(list.get(0)>=10){
                int ele=list.get(0);
                list.remove(0);
                list.add(0,ele%10);
                list.add(0,ele/10);
            }
        }

        System.gc();

        return list;
    }
}
