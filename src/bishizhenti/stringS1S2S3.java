package bishizhenti;


import java.util.Scanner;

public class stringS1S2S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();
            System.out.println(func(s1,s2,s3));
        }
    }
    public static int func(String s1,String s2,String s3){
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1+len2!=len3) return 0;
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 1;
        for (int i=0;i<len1+1;i++){
            for (int j=0;j<len2+1;j++){
                if((i-1>=0)&&dp[i-1][j]==1&&s1.charAt(i-1)==s3.charAt(i-1+j)){
                    dp[i][j] = 1;
                }
                if ((j-1>=0)&&dp[i][j-1]==1&&s2.charAt(j-1)==s3.charAt(i+j-1)){
                    dp[i][j] = 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
