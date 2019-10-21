package bishizhenti;

import java.util.*;

public class maxFib {
    public static void main(String[] args) {
        //给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            String[] strArr = str.split(",");
            int[] arr = new int[strArr.length];
            for (int i=0;i<strArr.length;i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            System.out.println(getMax(arr));
        }
    }
    public static int getMax(int[] A){
        int res = 0;
        int length = A.length;
        Map<Integer,Integer> dataMap = new HashMap<>();
        for(int i=0;i<length;i++){
            dataMap.put(A[i],i);
        }
        int[][] tmpData = new int[length][length];
        for(int i=length-1; i>=0; i--){
            for(int j=i+1; j<length; j++){
                if(dataMap.get(A[i] + A[j]) != null){
                    int tmp = A[i] + A[j];
                    int position = dataMap.get(tmp);
                    tmpData[i][j] = tmpData[j][position] + 1;
                    res = Math.max(res,tmpData[i][j]);
                }else {
                    tmpData[i][j] = 2;
                }
            }
        }
        return res;


    }
}
