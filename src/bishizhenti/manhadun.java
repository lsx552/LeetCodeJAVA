package bishizhenti;

import java.util.Scanner;

public class manhadun {
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n= sc.nextInt();
            int m = sc.nextInt();
            System.out.println(m^n);
        }
    }
//    public static int count(int n,int m){}

}
