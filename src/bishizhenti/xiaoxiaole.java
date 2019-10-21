package bishizhenti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class xiaoxiaole {
    //n个数字，每次任意选两个不同的删除，问最后能否删完
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] res = new String[T];
        for(int i=0;i<T;i++) {
            int n = sc.nextInt();
            int[] temp = new int[n];
            for (int j =1;j<n;j++) {
                temp[j] = sc.nextInt();
            }
            String ans = canDelete(temp);
            res[i] = ans;
        }
        for(int i=0;i<T;i++) {
            System.out.println(res[i]);
        }

    }
    public static String canDelete(int[] arr) {
        int[] countArr = new int[100005];
        for (int i : arr) {
            countArr[i]++;
        }
        int max_cnt = 0;
        for (int i=0;i<100005;i++) {
            if(countArr[i]>max_cnt)
                max_cnt = countArr[i];
        }
        if(max_cnt>arr.length/2)
            return "NO";
        else
            return "YES";

    }
}
