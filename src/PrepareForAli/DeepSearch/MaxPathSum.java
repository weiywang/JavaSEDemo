package PrepareForAli.DeepSearch;

public class MaxPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(maxGain(root.left), 0);
        int rightMax = Math.max(maxGain(root.right), 0);

        //如果以当前节点为根节点开辟新的路径，如果新路径的值大于原路径的话，则更新maxSum;
        int newPathSum = root.val + leftMax + rightMax;

        maxSum = Math.max(maxSum, newPathSum);

        //这个返回值是在递归的过程中使用的，最终的结果是通过属性maxSum返回的
        //当然，对根节点调用该方法时，返回的值并没有实际意义，但也没用到该值进行返回
        return root.val + Math.max(leftMax, rightMax);
    }
}
