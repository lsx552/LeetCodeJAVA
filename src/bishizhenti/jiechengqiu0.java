package bishizhenti;

import java.util.Scanner;

public class jiechengqiu0 {
    //输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(getNumOfZero(n));
        }
    }
        public static int getNumOfZero(int n) {
            int counter = 0;
            n = n/5;
            while (n!=0)
            {
                counter += n;
                n = n/5;
            }
            return counter;
        }

}
