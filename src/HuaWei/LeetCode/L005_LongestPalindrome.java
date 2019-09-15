package HuaWei.LeetCode;

public class L005_LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        if(len == 1){
            return s;
        }
        int start = 0;
        int slen = 1;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            if(i < len-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                start = i;
                slen = 1;
            }
        }

        for(int i = 3; i < len; i++){
            for(int j = 0; j+i-1 < len; j++){
                int end = j+i-1;
                if(s.charAt(j) == s.charAt(end)){
                    dp[i][end] = dp[j+1][end-1];
                    if(dp[j][end] == 1){
                        start = j;
                        slen = i;
                    }
                }
            }
        }
        return s.substring(start, start+slen);
    }
}
