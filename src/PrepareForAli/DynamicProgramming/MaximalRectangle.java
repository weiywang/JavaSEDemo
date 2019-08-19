package PrepareForAli.DynamicProgramming;

import java.util.Arrays;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(right, n);

        int maxSquare = 0;

        for(int i = 0; i < m; i++) {
            int curleft = 0, curright = n;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curleft);
                } else {
                    left[j] = 0;
                    curleft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {//从右向左遍历
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curright);
                } else {
                    right[j] = n;
                    curright = j;//不用j-1是为了下面计算方便
                }
            }

            //这个循环一定要放在大循环里，这样才能统计所有点的最大面积的值
            for(int j = 0; j < n; j++){
                maxSquare = Math.max(maxSquare, height[j] * (right[j] - left[j]));
            }

        }
        return maxSquare;
    }
}
