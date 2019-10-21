package bishizhenti;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class guohe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] time = new int[n];
            for(int i=0;i<n;i++){
                time[i] = sc.nextInt();
            }
            System.out.println(getTime(time));
        }
    }
    public static int getTime(int[] time){
        Arrays.sort(time);
        int i;
        int sum=0;
        for (i=time.length-1;i>2;i-=2){
            if ((time[0]+2*time[1]+time[i])<2*time[0]+time[i]+time[i-1]){
                sum = sum+time[0]+2*time[1]+time[i];
            }else {
                sum = sum+2*time[0]+time[i]+time[i-1];
            }
        }
        if (i==2){
            sum = sum+time[0]+time[1]+time[2];
        }else if (i==1){
            sum = sum+time[1];
        }else {
            sum = sum+time[0];
        }
        return sum;
    }

}
