package bishizhenti;

import java.util.Arrays;
import java.util.Scanner;

public class maxIncreaseSeq {
    //给定一个无序整型数组，允许将其中一个元素修改为任意数，
    //使修改后的数组存在尽可能长的连续递增序列
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] num = new int[N];
            int[] dp1 = new int[N]; //以nums[i]开始的最长上升子序列
            int[] dp2 = new int[N]; //以nums[i]结尾的最长上升子序列
            Arrays.fill(dp1,0);
            Arrays.fill(dp2, 0);
            dp1[N-1] =1;
            for ( int i = 0 ; i < N ; i++){
                num[i] = in.nextInt();
            }

            for ( int i = N-2 ; i>=0; i--){
                if ( num[i] < num[i+1]){
                    dp1[i] = dp1[i+1]+1;
                }else {
                    dp1[i]=1;
                }
            }
            dp2[0] = 1;
            for ( int i = 1 ; i<=N-1 ; i++){
                if (num[i] > num[i-1]){
                    dp2[i] = dp2[i-1]+1;
                }else {
                    dp2[i] = 1;
                }
            }

            int res = 1;
            int m = 1;
            for(int i = 0 ; i < N-1 ; i++){
                if(i==0){
                    m = dp1[i+1]+1;
                }else if (i==N-1){
                    m = dp2[i-1] + 1;
                }else if (num[i-1]+1<num[i+1]){
                    m = dp1[i+1]+dp2[i-1]+1;
                }else {
                    m = Math.max(dp1[i+1],dp2[i-1]+1);
                }
                if (m>res){
                    res = m;
                }
            }
            System.out.println(res);
        }

    }
}
