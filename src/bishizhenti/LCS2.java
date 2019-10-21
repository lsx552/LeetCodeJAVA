package bishizhenti;

public class LCS2 {
    public static void main(String[] args) {
        String str1 = "happy";
        String str2 = "capy";
        System.out.println(findLCS(str1,str2));
    }
    //最长公共子序列
    public static int findLCS(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length() + 1];
        for (int i = 0; i < str1.length()+1; i++) {
            dp[i][0]=0;
        }
        for (int j = 0; j < str2.length()+1; j++) {
            dp[0][j]=0;
        }
        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }


}
