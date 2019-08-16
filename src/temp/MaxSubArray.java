package temp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) {
            return sum;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {//当sum小于0时，前面累加的序列视为无用，另起炉灶
                sum = 0;
            }
        }
        return maxSum;
    }
}
