package bishizhenti;

import java.util.Scanner;

public class qiaokeli {
    //小Q的父母要出差N天，走之前给小Q留下了M块巧克力。
    // 小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，
    // 请问他第一天最多能吃多少块巧克力
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int day = sc.nextInt();
            int num = sc.nextInt();
            System.out.println(maxNum(day, num));
        }
    }

    public static int sum(int s, int n, int m) {
        //计算第一天吃s个巧克力一共需要多少个巧克力
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s;
            s = (s + 1) / 2;
        }
        return sum;
    }
    public static int maxNum(int n,int m) {
        if(n==1) return m;
        int low = 0;
        int high = m;
        while (low<=high) {
            int mid = (low+high+1)/2;
            if(sum(mid,n,m)==m) return mid;
            else if (sum(mid,n,m)<m) {
                low = mid +1;
            }else {
                high = mid -1;
            }
        }
        return high;
    }
}
