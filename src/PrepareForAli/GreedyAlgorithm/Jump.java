package PrepareForAli.GreedyAlgorithm;

public class Jump {
    public int jump(int[] nums) {
        int steps = 0;
        int end = 0;
        int maxPosition = 0;

        //nums.length - 1? nums.length - 1如何处理的？当 i = nums.length - 1时跳出了循环
        for(int i = 0; i < nums.length - 1; i++){
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
