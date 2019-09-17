package HuaWei.LeetCode;

import java.util.ArrayList;

public class L679_JudgePoint24 {
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> list = new ArrayList<Double>();
        for(Integer num : nums){
            list.add((double)num);
        }
        return solve(list);
    }

    public boolean solve(ArrayList<Double> list){
        if(list.size() == 0) return false;
        //必须是取绝对值，是1e-6不是1e6
        if(list.size() == 1){
            return Math.abs(list.get(0) - 24) < 1e-6;

        }

        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(i != j){
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for(int k = 0; k < list.size(); k++){
                        if(k != i && k != j) nums2.add(list.get(k));
                    }

                    for(int k = 0; k < 4; k++){
                        if(k < 2 && j > i) continue;
                        //加好写成了减号，导致栈溢出，超时
                        if(k == 0) nums2.add(list.get(i) + list.get(j));
                        if(k == 1) nums2.add(list.get(i) * list.get(j));
                        if(k == 2) nums2.add(list.get(i) - list.get(j));
                        if(k == 3) {
                            if (list.get(j) != 0) {
                                nums2.add(list.get(i) / list.get(j));
                            } else {
                                continue;
                            }
                        }
                        if(solve(nums2)) return true;
                        nums2.remove(nums2.size()-1);
                    }
//这两句代码，应该放在上面一个for循环里面，这样放会导致栈溢出，永远达不到边界
//                    if(solve(nums2)) return true;
//                    nums2.remove(nums2.size()-1);
                }
            }
        }
        return false;
    }

    public static void main(String[] Args){
        int[] nums = {4, 1, 8, 7};
        System.out.println(new L679_JudgePoint24().judgePoint24(nums));
    }
}
