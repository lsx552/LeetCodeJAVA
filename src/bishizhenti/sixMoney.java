package bishizhenti;

import java.util.Scanner;

public class sixMoney {
    //给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，
    // 编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int N = sc.nextInt();
            int[] coins = new int[n];
            for (int i=0;i<n;i++){
                coins[i] = sc.nextInt();
            }
            System.out.println(count(coins,N));
        }
    }
    public static int count(int[] coins,int N){
        if(N<=0) return 0;
        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i = 0;i<coins.length;i++){ //i表示用前i+1种硬币
            for(int j = coins[i];j<=N;j++){
                dp[j] = dp[j]+dp[j-coins[i]];
            }
        }
        return dp[N];
    }
}
