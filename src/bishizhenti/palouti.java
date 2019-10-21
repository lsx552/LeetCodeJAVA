package bishizhenti;

import java.math.BigInteger;
import java.util.Scanner;

public class palouti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
              long N  = sc.nextLong();

              System.out.println(func(N));
        }
    }
    public static String func(long N){
        BigInteger res = BigInteger.valueOf(0);

        if (N<=1){
            res=BigInteger.valueOf(1);
        }else if (N==2){
            res=BigInteger.valueOf(1);
        }
        BigInteger n1 = BigInteger.valueOf(1);
        BigInteger n2 = BigInteger.valueOf(1);
        for (long i=2;i<N;i++){
            res = n1.add(n2);
            n1 = n2;
            n2 = res;
        }
        return res.toString();
    }
}
