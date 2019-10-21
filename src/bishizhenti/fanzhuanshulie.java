package bishizhenti;

import java.util.Scanner;

public class fanzhuanshulie {
    //给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。
    //例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.
    //而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.
    //小Q现在希望你能帮他算算前n项和为多少。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(n*m/2);
        }
    }
}
