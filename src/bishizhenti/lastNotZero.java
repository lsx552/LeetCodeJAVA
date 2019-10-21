package bishizhenti;

import java.util.*;
public class lastNotZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            System.out.println(factorial2(a));
        }

    }

    public static  int factorial2(int n) {
        int s = 1;
        for(int i=1;i<=n;i++){
            s*=i;
            while (s%10==0){
                s /=10;
            }
            s %=100;
        }
        return s%10;
    }

}