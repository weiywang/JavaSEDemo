package PrepareForAli;

public class RegexMatch {
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        boolean[][] dp = new boolean[slen+1][plen+1];//注意要是slen+1，要多加1

        dp[0][0] = false;

        for(int i = 0; i < slen; i++){
            for(int j = 1; j < plen; j++){
                if(p.charAt(j-1) != '*'){
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }else{
                    //dp[i-1][j]? s.charAt(i-1) == p.charAt(j-2)?
                    dp[i][j] = dp[i][j-2] || (i>0 && dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                }
            }
        }

        return dp[slen][plen];
    }
}
