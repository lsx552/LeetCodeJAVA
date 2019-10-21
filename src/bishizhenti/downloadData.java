package bishizhenti;

import java.util.Scanner;

public class downloadData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            int v = sc.nextInt();
            double sum = 0.00;
            if((x*x+y*y)<=a*a){
                int temp = x*x+y*y;
                sum = Math.sqrt(temp)*t/v;
            }else if (((x*x+y*y)>a*a)&&((x*x+y*y)<=b*b)){
                int temp = x*x+y*y;
                sum = a*t/v+(Math.sqrt(temp)-a)*s/v;
            }else if ((x*x+y*y)>b*b){
                int temp = x*x+y*y;
                sum = a*t/v+(b-a)*s/v;
            }
            System.out.println(String.format("%.2f",sum));
        }
    }
}
