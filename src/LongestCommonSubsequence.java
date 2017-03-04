/**
 * Created by zeqingzhang on 11/6/16.
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || A.length() == 0){
            return 0;
        }

        if(B == null || B.length() == 0){
            return 0;
        }

        int m = A.length();
        int n = B.length();
        int[][] tracker = new int[n + 1][m + 1];
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(A.charAt(i) == B.charAt(j)){
                    tracker[i][j] = Math.max(tracker[i - 1][j], tracker[i][j - 1]);
                    tracker[i][j] = Math.max(tracker[i][j],
                            tracker[i - 1][j - 1] + 1);
                }else{
                    tracker[i][j] = Math.max(tracker[i - 1][j], tracker[i][j - 1]);
                    tracker[i][j] = Math.max(tracker[i][j], tracker[i - 1][j - 1]);
                }
            }
        }
        return tracker[m + 1][n + 1];
    }
}
