package bishizhenti;

import java.util.Scanner;

public class huajiang {
    public static final int max = 100005;
    public static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int[][] qujian = new int[t][2];
        long[] res = new long[t];
        long[] dp= new long[max];
        long[] sum = new long[max];
        for (int i=0;i<k;i++) dp[i] = 1;
        for (int i=k;i<max;i++) {
            dp[i] = (dp[i-1]%mod + dp[i-k]%mod)%mod;
        }
        sum[1] = dp[1];
        for(int i=2;i<max;i++) {
            sum[i] = (sum[i-1]%mod + dp[i]%mod) % mod;
        }
        for (int i=0;i<t;i++) {
            qujian[i][0] = sc.nextInt();
            qujian[i][1] = sc.nextInt();
            long cnt = ((sum[qujian[i][1]]-sum[qujian[i][0]-1])%mod+mod)%mod;
            res[i] = cnt;
        }
        for (int i=0;i<t;i++) {
            System.out.println(res[i]);
        }
    }
}
