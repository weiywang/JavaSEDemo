package HuaWei.LeetCode;

import java.util.*;
public class L554_LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        int res = 0;
        int height  = wall.size();
        int length = 0;
        for(int len : wall.get(0)){
            length += len;
        }
        if(length == 1){
            return height;
        }


        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> l : wall){
            int index = 0;
            int j = 0;
            int size = l.size();
            for(int t : l){
                //防止走到最右边的边线,边界值是l.size()-1,不是length-1
                if(j == size-1) break;
                index = index + t;
                map.put(index, map.containsKey(index)?map.get(index)+1:1);
                res = Math.max(map.get(index), res);
                j++;
            }
        }
        return height-res;
    }
}
