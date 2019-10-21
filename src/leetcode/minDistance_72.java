package leetcode;

public class minDistance_72 {
    //编辑距离

    public int minDistance(String word1, String word2) {
        // +1是为了从len=0的字符串算起
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // dp二维数组的初始化
        dp[0][0] = 0;
        for (int i = 1; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        // dp的关系递推
        for (int i = 1; i < word1.length() + 1; i++)
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String args[]) {
        String s1 = "hello";
        String s2 = "hell";
        minDistance_72 md= new minDistance_72();
        int res = md.minDistance(s1,s2);
        System.out.println(res);
    }
}