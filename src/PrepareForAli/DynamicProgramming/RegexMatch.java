package PrepareForAli.DynamicProgramming;

public class RegexMatch {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        //表示的s[0, i)、p[0, j)是否匹配
        boolean[][] dp = new boolean[slen+1][plen+1];//注意要是slen+1，要多加1

        dp[0][0] = true;//初始值应设为true

        for(int i = 0; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                if(p.charAt(j-1) == '*'){
                    //dp[i-1][j]? s.charAt(i-1) == p.charAt(j-2)?
                    //在本轮计算中，考察的是j-1，因此如果*什么也没代替，就是说出现了s = "aab"， p = "c*a*b"这种情况，就自然考虑dp[i][j-2]
                    //如果*替代了至少一个前面的字符，则一定有s[i-1]=p[j-2]或者p[j-2]='.',这时有dp[i][j]=dp[i-1][j]
                    dp[i][j] = dp[i][j-2] || (i>0 && dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }else{
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
            }
        }

        return dp[slen][plen];
    }
}
