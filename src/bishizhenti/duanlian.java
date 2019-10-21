package bishizhenti;

import java.util.Scanner;

public class duanlian {
    static  int len;
    static  int sumE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int[] dist = new int[N];
            int[] effact = new int[N];
            for (int i=0;i<N;i++) {
                dist[i] = sc.nextInt();
            }
            for (int i=0;i<N;i++) {
                effact[i] = sc.nextInt();
            }
            int[] maxE = new int[N];
            len = dist.length;
            for (int i=N-1;i>=0;i--) {
                if(i==N-1) {
                    sumE = 2*N;
                    for (int j=0;j<N;j++) {
                        sumE += effact[j];
                    }
                    maxE[N-1] = sumE;
                }else {
                    int index = calIndex(dist,effact,i);
                    sumE = calE(dist,effact,index);
                    maxE[i] = sumE;
                }

            }
            for (int i=0;i<N;i++) {
                System.out.println(maxE[i]);
            }
        }

    }

    public static int calIndex(int[] dist,int[] effact,int k) {
        int minE = effact[0];
        int minIndex = 0;
        for(int i=1;i<k;i++) {
            if(effact[i]<minE) {
                minE = effact[i];
                minIndex = i;
            }

        }
        if(sumE-2-effact[len-1]>sumE-effact[minIndex]) {
            return len;
        }else {
            return minIndex;
        }

    }
    public static int calE(int[] dist,int[] effact,int index) {
        if (index==len) {
            sumE  = sumE-2-effact[len-1];
            len = len -1;
        }else {
            sumE= sumE - effact[index];
        }
        return sumE;
    }
    public static int maxE(int[] dist,int[] effact) {
        int[] dp = new int[dist.length];
        dp[0] = 2+effact[0];
        for (int i=1;i<dist.length;i++) {
            dp[i] = Math.max(dp[i-1],2*(i+1)+effact[i]);
        }
        return dp[dist.length-1];
    }
}
