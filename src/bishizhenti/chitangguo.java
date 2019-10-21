package bishizhenti;


import java.util.Arrays;
import java.util.Scanner;

public class chitangguo {
    //桌上有n颗糖，第i颗糖的美味度为2的wi次方。彼得每次能吃掉任意多的糖，但是每次吃掉的糖美味度的和必须为2的k次方
    //问彼得最少需要多少次才能吃完所有糖
    static int cnt =0;
    static int[] arr = new int[1000001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            cnt = 0;
            Arrays.fill(arr,0);
            int[] wi_arr = new int[N];
            for (int i = 0; i < N; i++) {
                wi_arr[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                count_one(wi_arr[i]);
            }
            System.out.println(cnt);
        }

    }

    public static void count_one(int wi) {
        if (arr[wi] > 0) {
            arr[wi] = 0;
            count_one(wi+1);
            cnt--;
        } else {
            arr[wi] = 1;
            cnt++;
        }
    }

}
