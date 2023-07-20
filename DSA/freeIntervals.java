package DSA;

import java.util.ArrayList;
import java.util.List;

public class freeIntervals {
    public static List<List<String>> getMeetTime(List<List<String>> p1, List<List<String>> p2, int time){
        int i1=0;
        int i2=0;
        List<List<String>> booked=new ArrayList<>();
        List<List<String>> out=new ArrayList<>();
        String startTime="";
        String endTime = "";
        while(i1<p1.size() || i2 < p2.size()){
            if(i1==p1.size()){
                String s2=p2.get(i2).get(0);
                String e2=p2.get(i2).get(1);
                List<String> curr=new ArrayList<>();
                curr.add(s2);
                curr.add(e2);
                booked.add(curr);
                i2++;
                continue;
            }
            if(i2==p2.size()){
                String s1=p1.get(i1).get(0);
                String e1=p1.get(i1).get(1);
                List<String> curr=new ArrayList<>();
                curr.add(s1);
                curr.add(e1);
                booked.add(curr);
                i1++;
                continue;
            }
            String s1=p1.get(i1).get(0);
            String s2=p2.get(i2).get(0);
            String e1=p1.get(i1).get(1);
            String e2=p2.get(i2).get(1);
            if((compareTime(s1,s2)==-1 && compareTime(e1,s2)==1)){
                startTime=s1;
                if(compareTime(e1,e2)==1){
                    endTime=e1;
                    i1++;
                    i2++;
                }else{
                    endTime=e2;
                    i2++;
                }
            }else if((compareTime(s2,s1)==-1 && compareTime(e2,s1)==1)){
                startTime=s2;
                if(compareTime(e1,e2)==1){
                    endTime=e1;
                    i1++;
                }else{
                    endTime=e2;
                    i2++;
                    i1++;
                }
            }else{
                if(startTime.equals("")){
                    if(compareTime(s1,s2)==-1){
                        startTime=s1;
                        endTime=e1;
                    }else{
                        startTime=s2;
                        endTime=e2;
                    }
                }
                List<String> curr=new ArrayList<>();
                curr.add(startTime);
                curr.add(endTime);
                booked.add(curr);
                if(compareTime(s1,s2)==-1){
                    i1++;
                }else{
                    i2++;
                }
                startTime="";
                endTime = "";
            }
        }
        if(!startTime.equals("")){
            List<String> curr=new ArrayList<>();
            curr.add(startTime);
            curr.add(endTime);
            booked.add(curr);
        }
        for (List<String> i: booked)   {
            System.out.println(i);
        }
        System.out.println();
        for(int i=0; i<booked.size()-1; i++){
            String e=booked.get(i).get(1);
            String s=booked.get(i+1).get(0);
            if(getDiff(s,e)>=time){
                List<String> curr=new ArrayList<>();
                curr.add(e);
                curr.add(s);
                out.add(curr);
            }
        }
        return out;
    }

    private static int getDiff(String s, String e) {
        String[] T1=s.split(":");
        String[] T2=e.split(":");
        int hour1=Integer.parseInt(T1[0]);
        int hour2=Integer.parseInt(T2[0]);
        int min1=Integer.parseInt(T1[1]);
        int min2=Integer.parseInt(T2[1]);
        return (hour1*60 + min1)-(hour2*60 + min2);
    }

    public static int compareTime(String t1,String t2){
        String[] T1=t1.split(":");
        String[] T2=t2.split(":");
        int hour1=Integer.parseInt(T1[0]);
        int hour2=Integer.parseInt(T2[0]);
        int min1=Integer.parseInt(T1[1]);
        int min2=Integer.parseInt(T2[1]);
        if((hour1*60 + min1)>(hour2*60 + min2)){
            return 1;
        } else if ((hour1*60 + min1)<(hour2*60 + min2)) {
            return -1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        List<List<String>> p1=new ArrayList<>();
        List<String> curr=new ArrayList<>();
        curr.add("9:00");
        curr.add("10:30");
        p1.add(new ArrayList<>(curr));
        curr.remove(0);
        curr.remove(0);
        curr.add("12:00");
        curr.add("13:00");
        p1.add(new ArrayList<>(curr));
        curr.remove(0);
        curr.remove(0);
        curr.add("16:00");
        curr.add("18:00");
        p1.add(new ArrayList<>(curr));
        curr.remove(0);
        curr.remove(0);
        List<List<String>> p2=new ArrayList<>();
        curr.add("10:00");
        curr.add("11:30");
        p2.add(new ArrayList<>(curr));
        curr.remove(0);
        curr.remove(0);
        curr.add("12:30");
        curr.add("15:00");
        p2.add(new ArrayList<>(curr));
        curr.remove(0);
        curr.remove(0);
        curr.add("16:00");
        curr.add("17:00");
        p2.add(new ArrayList<>(curr));
        curr.remove(0);
        curr.remove(0);
        List<List<String>> out=getMeetTime(p1,p2,30);
        for (List<String> i: out)   {
            System.out.println(i);
}
    }
}
