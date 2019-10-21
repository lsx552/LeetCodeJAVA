package bishizhenti;


import java.util.Arrays;
import java.util.Scanner;

public class ningmeng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m=  sc.nextInt();
            long[] a = new long[n];
            long[] b = new long[m];
            for (int i=0;i<n;i++){
                a[i] = sc.nextLong();
            }
            for (int i=0;i<m;i++){
                b[i] = sc.nextLong();
            }
            System.out.println(max(a,b));
        }
    }
    public static long max(long[] a,long[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        long res =0;
        long a_2max=0;
        long b_max=0;
        if(a[a.length-2]>0){
            a_2max = a[a.length-2];
            b_max = a[b.length-1];
        }else {
            a_2max = a[a.length-2];
            b_max = b[0];
        }

        res = a_2max*b_max;
        return res;
    }
}
