package bishizhenti;

import java.util.Arrays;
import java.util.Scanner;

public class findMax {
    //在整数 n 中删除m个数字, 使得余下的数字按原次序组成的新数最大，比如当n=92081346717538，m=10时，则新的最大数是9878
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long  n = sc.nextLong();
            String n_str = Long.toString(n);
            int m = sc.nextInt();
            int[] flag = new int[n_str.length()];//标记数是否留下
            Arrays.fill(flag,0);
            int num = n_str.length()-m;
            int pos = -1;
            for(int i=0;i<num;i++) {
                pos = fingMAX(n_str,pos+1,m+i+1);
                flag[pos] = 1;
            }
            String str = "";
            for (int i=0;i<n_str.length();i++){
                if (flag[i]==1) {
                    str +=n_str.charAt(i);
                }
            }
            //long res = Long.parseLong(str);
            System.out.println(str);
        }
    }
    public static int fingMAX(String n, int start,int end) {
        char curMax = n.charAt(start);
        int pos = start;
        for(int i=start;i<end;i++) {
            if(n.charAt(i)>curMax) {
                curMax = n.charAt(i);
                pos = i;
            }
        }
        return pos;
    }
}
