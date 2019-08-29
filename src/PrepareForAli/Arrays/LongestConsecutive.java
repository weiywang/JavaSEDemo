package PrepareForAli.Arrays;

import java.util.HashSet;
import java.util.*;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int max = 0;
        for(int num : nums){
            int temp = 1;
            int pre = num;
            int next = num;
            while(set.contains(--pre)){
                temp++;
                set.remove(pre);
            }

            while(set.contains(++next)){
                temp++;
                set.remove(next);
            }

            max = Math.max(max, temp);
            if(max > nums.length){
                return max;
            }
        }
        return max;

    }
}
