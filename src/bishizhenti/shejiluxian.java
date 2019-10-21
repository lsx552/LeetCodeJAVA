package bishizhenti;

import java.util.Scanner;

public class shejiluxian {
    //用户出行旅游通常都是一个闭环，即从某地出发游览各个景点，
    // 最终回到出发地。已知各个景点间的通行时间。
    // 请你设计一套算法，当用户给定出发地以及景点后，给出一条游览路线，
    // 使得用户能够不重复的游历每个景点并返回出发地的总通行时间最短，计算该最短通行时间。
    // 假设所有用户的出发地都是0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();//出发地与景点的总个数
            int m = sc.nextInt();//景点间直达路线的个数m
            int[][] time = new int[m][3];
            for(int i=0;i<m;i++) {
                time[i][0] = sc.nextInt();
                time[i][1] = sc.nextInt();
                time[i][2] = sc.nextInt();
            }
            System.out.println(-1);
        }
    }
}
