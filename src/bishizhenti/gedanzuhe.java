package bishizhenti;

import java.util.Scanner;

public class gedanzuhe {
    //小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，
    // 每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
    static long c[][]  = new long [101][101];
    public static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c[0][0] = 1;
        for (int i=1;i<101;i++) {
            c[i][0] = 1;
            for (int j=1;j<=i;j++) {
                c[i][j] = (c[i-1][j-1]+c[i-1][j])%mod;
            }
        }
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            int a = sc.nextInt(),x = sc.nextInt();
            int b = sc.nextInt(),y = sc.nextInt();
            long sum = 0;
            for (int i=0;i<=x;i++) {
                for (int j=0;j<=y;j++) {
                    if ((a*i+b*j)>k) break;
                    if ((a*i+b*j)==k)
                        sum += c[x][i] * c[y][j];
                }
            }
            System.out.println(sum%mod);
        }
    }
}
