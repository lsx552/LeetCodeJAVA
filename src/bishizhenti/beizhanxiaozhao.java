package bishizhenti;

import java.util.Scanner;

public class beizhanxiaozhao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int T= sc.nextInt();
            int[][] plan = new int[T][2];
            int[] res = new int[T];
            for (int i=0;i<T;i++){
                plan[i][0] = sc.nextInt();
                plan[i][1] = sc.nextInt();
                int[][] cost = new int[plan[i][0]][2];
                for (int j=0;j< plan[i][0];j++){
                    cost[j][0] = sc.nextInt();
                    cost[j][1] = sc.nextInt();
                }
                res[i] = maxScore(cost,plan[i][1]);
            }
            for (int i=0;i<T;i++){
                System.out.println(res[i]);
            }
        }
    }
    public static int maxScore(int[][] cost,int day) {
        int[] dp = new int[day+1];
        for(int i=0;i<day+1;i++) {
            dp[i] = 0;
        }
        for (int i=0;i<cost.length;i++) {
            for (int j = day;j>=cost[i][0];j--) {
                dp[j] = Math.max(dp[j],dp[j-cost[i][0]]+cost[i][1]);
            }
        }
        return dp[day];
    }
}
