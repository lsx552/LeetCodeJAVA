package bishizhenti;

import java.text.DecimalFormat;
import java.util.Scanner;
//
public class redBlueBall {
//    //现在有一个进阶版的问题，同样是一个袋子里面有n个红球和m个蓝球，共有A，B，C三人参与游戏，
//    // 三人按照A，B，C的顺序轮流操作，在每一回合中，A，B，C都会随机从袋子里面拿走一个球，
//    // 然而真正分出胜负的只有A，B两个人，没错，C就是来捣乱的，他除了可以使得袋子里面减少一个球，没有其他任何意义，
//    // 而A，B谁 先拿到红球就可以获得胜利，但是由于C的存在，两人可能都拿不到红球，此时B获得胜利。
//    //3 4
//    //0.62857

    static Double[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();   // red
            int m = sc.nextInt();   // blue
            dp = new Double[n+1][m+1];
            double res = helper(n,m);
            System.out.println(String.format("%.5f",res));
        }

    }

    private static double helper(int n, int m){
        if (n<=0 || m<0){
            return 0;
        }else if (n+m <= 2){
            if (m == 0) // n=1 m=0 || n=2 m=0
                return 1;
            else
                return 0.5; // n=1 m=1
        }else if (dp[n][m] != null)
            return dp[n][m];
        else{
            double ans = 1.0*n/(m+n);   // A 直接选择 red
            double t = 1.0*m/(m+n)*(m-1)/(m+n-1);   // A、B 选择 blue
            ans += helper(n-1,m-2)*t*n/(m+n-2) + helper(n,m-3)*t*(m-2)/(m+n-2); // C 选择 red || C 选择 blue
            dp[n][m] = ans;
            return ans;
        }
    }

}

