package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class mergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = 0;
        int end=0;
        int startInterval=intervals[start][0];
        int endInterval=intervals[end][1];
        ArrayList<int[]> list=new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= startInterval && intervals[i][0] <= endInterval) {
                startInterval=Math.min(intervals[i][0],startInterval);
                endInterval = Math.max(intervals[i][1], endInterval);
                end=i;
            }else{
                list.add(new int[] {intervals[start][0], intervals[end][1]});
                start=i;
                end=i;
                startInterval=intervals[start][0];
                endInterval = intervals[start][1];
            }
        }

        if(start== intervals.length-1){
            list.add(new int[]{intervals[start][0], intervals[start][1]});
        }

        if(end == intervals.length-1 &&start!= intervals.length-1){
            list.add(new int[]{intervals[start][0], endInterval});
        }

        int[][] ans=new int[list.size()][2];
        for(int i=0; i< list.size(); i++){
            ans[i]=list.get(i);
        }

        return ans;
    }

    //Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    //        int start = 0;
    //        int end=0;
    //        int startInterval=intervals[start][0];
    //        int endInterval=intervals[end][1];
    //        ArrayList<int[]> list=new ArrayList<>();
    //        for (int i = 1; i < intervals.length; i++) {
    //            if (intervals[i][0] >= startInterval && intervals[i][0] <= endInterval) {
    //                startInterval=Math.min(intervals[i][0],startInterval);
    //                endInterval = Math.max(intervals[i][1], endInterval);
    //                end=i;
    //            }else{
    //                list.add(new int[] {startInterval, endInterval});
    //                start=i;
    //                end=i;
    //                startInterval=intervals[start][0];
    //                endInterval = intervals[start][1];
    //            }
    //        }
    //
    //        if(start== intervals.length-1){
    //            list.add(new int[]{intervals[start][0], intervals[start][1]});
    //        }
    //
    //        if(end == intervals.length-1 &&start!= intervals.length-1){
    //            list.add(new int[]{intervals[start][0], endInterval});
    //        }
    //
    //        return list.toArray(new int[0][]);
    //    }

    public static void main(String[] args) {
        int[][] ans=merge(new int[][]{{2,2}, {1,3}, {3,3}, {3,4}, {2,3}, {4,5}, {4,4}});
        for(int[] i:ans){
            System.out.println(Arrays.toString(i));
        }
    }
}
