package HuaWei.LeetCode;

import java.util.*;

public class L001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (Integer num : nums) {
            int complete = target - num;
            //是花括号，不是小括号
            if(map.containsKey(complete)) return new int[]{map.get(complete), count};
            map.put(num, count);
            count++;
        }
        //能执行到这里，说明数组中不含有相应的两个数
        return new int[]{-1, -1};
    }
}
