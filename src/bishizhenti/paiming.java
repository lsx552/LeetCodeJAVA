package bishizhenti;

import java.util.Scanner;

public class paiming {
    //N个同学按成绩排名，问有多少种排列方式
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int res=0;
            int[][] dp = count(n);
            for (int i=1;i<n+1;i++){
                res += dp[i][n];
            }
            System.out.println(res);
        }
     }
     public static int[][] count(int n){
        int[][] dp = new int[n+1][n+1];
        for (int i=1;i<n+1;i++){
            for (int j=1;j<n+1;j++){
                if (i==1){
                    dp[i][j] = 1;
                }if (i!=j){
                    dp[i][j] = i*dp[i][j-1]+i*dp[i-1][j-1];
                }else {
                    dp[i][j]= fac(i);
                }
            }
        }
        return dp;
     }
     public static int fac(int n){
        int res=1;
        while (n>0){
            res *=n;
            n--;
        }
        return res;
     }
}
