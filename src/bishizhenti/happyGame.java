package bishizhenti;

import java.util.Scanner;

public class happyGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k =sc.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int i=0;i<n;i++){
                x[i] = sc.nextInt();
                y[i]= sc.nextInt();
            }
        }
    }
    public static int maxHappy(int[] x,int[] y){
        return 1;
    }
}
