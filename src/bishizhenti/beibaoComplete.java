package bishizhenti;

import java.util.Scanner;

public class beibaoComplete {
    //完全背包，每个物品无限用
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt(); //物品个数
            int m = sc.nextInt(); //背包容量
            int[] weight = new int[n];
            int[] val = new int[n];
            for(int i=0;i<n;i++) {
                weight[i] = sc.nextInt();
                val[i] = sc.nextInt();
            }
            System.out.println(maxV(weight,val,m));
        }
    }
    public static int maxV(int[] weight,int[] val,int m) {
        int[] dp = new int[m+1];
        for(int i=0;i<m+1;i++) {
            dp[i] = 0; // 背包不必装满 初始化为0
            //dp[i] = Integer.MIN_VALUE; 背包必须装满 初始化为Integer.MIN_VALUE
        }
        for (int i=0;i<weight.length;i++) {
            for (int j = weight[i];j<m+1;j++) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+val[i]);
            }
        }
        return dp[m];
    }
}



