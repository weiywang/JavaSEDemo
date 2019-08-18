package PrepareForAli;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        if(n * m == 0){
            return n + m;
        }

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){//边界条件是i<=m
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++){//边界条件是i<=n
            dp[0][i] = i;
        }

        for(int i = 1; i <= m; i++){//起始为1
            for(int j = 1; j <= n; j++){
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int leftdown = dp[i-1][j-1];

                if(word1.charAt(i-1) != word2.charAt(j-1)){//是i-1,j-1,
                    leftdown = leftdown + 1;
                }

                dp[i][j] = Math.min(left, Math.min(down, leftdown));
            }
        }

        return dp[m][n];
    }
}
