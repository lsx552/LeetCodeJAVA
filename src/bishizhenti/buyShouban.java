package bishizhenti;

import java.util.Arrays;
import java.util.Scanner;

public class buyShouban {
    //S元，N个手办，求最少买多少手办能花完S元
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int[] cost = new int[N];
            for (int i=0;i<N;i++) {
                cost[i] = sc.nextInt();
            }
            System.out.println(minNum(cost,S));
        }
    }
    public static int minNum(int[] cost,int S){
        Arrays.sort(cost);
        int res =0;
        int sum = 0;
        for(int i=cost.length-1;i>=0;i--) {
            sum +=cost[i];
            res +=1;
            if (sum>=S) {
                return res;
            }
        }
        return -1;
    }
}
