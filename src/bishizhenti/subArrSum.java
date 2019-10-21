package bishizhenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class subArrSum {
    //一个数组有 N 个元素，求连续子数组的最大和。
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] arr = br.readLine().split(" ");
            int[] num = new int[arr.length];
            for(int i=0;i<arr.length;i++){
                num[i] = Integer.parseInt(arr[i]);
            }
         System.out.println(FindGreatestSumOfSubArray(num));
        }
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int dp=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            dp=Math.max(dp+array[i], array[i]);
            res=Math.max(dp, res);
        }
        return res;
    }
    //dp（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
    //dp（i）=max（dp（i-1）+array[i] ， array[i]）
    //res：所有子数组的和的最大值
    //res=max（res，dp（i））
}
