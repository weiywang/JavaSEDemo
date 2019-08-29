package PrepareForAli.Arrays;

import PrepareForAli.List.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lists = new ArrayList<>();
        int n = intervals.length;
        if(n == 0){
            lists.add(newInterval);
            return lists.toArray(new int[0][]);//此用法之前没有使用过，学习并记住
        }

        int i;
        for(i = 0; i < n; i++){
            if(intervals[i][1] >= newInterval[0]){//>=，不是>
                break;
            }
            lists.add(intervals[i]);
        }

        if(i == n){
            lists.add(newInterval);
            return lists.toArray(new int[0][]);
        }

        if(intervals[i][0] > newInterval[1]){
            lists.add(newInterval);
        }else{
            int head = Math.min(intervals[i][0], newInterval[0]);
            int tail = Math.max(intervals[i][1], newInterval[1]);

            //循环条件是intervals[i][0] <= tail，不是<
            while(i < n && intervals[i][0] <= tail){
                tail = Math.max(tail, intervals[i][1]);
                i++;
            }
            //{head, tail}不能忘记添加
            lists.add(new int[]{head, tail});
        }

        for(; i < n; i++){
            lists.add(intervals[i]);
        }

        return lists.toArray(new int[0][]);
    }
}
