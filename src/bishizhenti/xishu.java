package bishizhenti;

import java.util.Scanner;

public class xishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            long[] arr = func(n);
            for (int i=0;i<arr.length;i++){
                System.out.print((arr[i])+" ");
            }



        }
    }
    public static long[] func(int n){
        long[] res= {1};
        if (n==1) return  res;
        long[][] dp  = new long[n+1][n+1];
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[2][1]= 2;
        dp[2][2]=1;
        for(int i=3;i<n+1;i++){
            for (int j=0;j<n+1;j++){
                if (j==0){
                    dp[i][j]=1;
                }else if (j==i){
                    dp[i][j]=1;
                }else {
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[n];
    }
}
