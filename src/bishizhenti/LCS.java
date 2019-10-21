package bishizhenti;

public class LCS {
    //最长公共子串
    public static void main(String[] args) {
        String str1 = "abcefefddgag";
        String str2 = "sbsefefddgeg";
        System.out.println(longCommenSubstr(str1,str2));
    }
    public static String longCommenSubstr(String str1,String str2) {
        if (str1==null || str2==null||str1.length()==0||str2.length()==0) {
            return "";
        }
        int[][] dp = new int[str1.length()][str2.length()];
        int maxStart=0,maxEnd=0;

        for(int i=0; i<str1.length(); ++i)
        for (int j = 0; j < str2.length(); ++j) {
            if (str1.charAt(i) == str2.charAt(j)) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
            else {
                dp[i][j] = 0;
            }

            if (dp[i][j] > maxStart) {
                maxStart = dp[i][j];
                maxEnd = i; //若记录i,则最后获取LCS时是取str1的子串
            }
        }
        return str1.substring(maxEnd - maxStart + 1, maxEnd);
    }
}
