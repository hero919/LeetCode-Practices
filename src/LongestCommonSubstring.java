import java.util.Arrays;

/**
 * Created by zeqingzhang on 11/6/16.
 */
public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0){
            return 0;
        }

        if(B == null || B.length() == 0){
            return 0;
        }

        int m = A.length();
        int n = B.length();



        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){
                if(A.charAt(j - 1) == B.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }

    public static void main(String[] args){
        LongestCommonSubstring l = new LongestCommonSubstring();
        l.longestCommonSubstring("www.lintcode.com code", "www.ninechapter.com code");
    }
}
