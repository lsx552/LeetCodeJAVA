package bishizhenti;


import java.util.Scanner;

public class moveBot {
    //在一根数轴上，1-n每个点上都有L或R，每个点有个机器人，现在所有机器人同时操作10的100次方次。
    //如果该点为L则左移，如果该点为R右移，输出每个坐标上有多少个机器人

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int[] l = new int[100005];//当前位置左边的第一个R
            int[] r = new int[100005];//当前位置右边的第一个L
            int[] res = new int[100005];
            String str = sc.next();
            int n = str.length();
            for(int i=0;i<n;i++){
                if(str.charAt(i)=='R'){
                    r[i] = i;
                }else {
                    r[i] = r[i-1];
                }
            }
            for (int i=n-1;i>=0;i--){
                if(str.charAt(i)=='L'){
                    l[i] = i;
                }else {
                    l[i] = l[i+1];
                }
            }
            for(int i=0;i<n;i++){
                int count = 0;
                if(str.charAt(i)=='R'){
                    count = l[i] - i;
                    if(count%2==0){
                        res[l[i]]++;
                    }else {
                        res[l[i]-1]++;
                    }
                }else {
                    count = i - r[i];
                    if (count%2==0){
                        res[r[i]]++;
                    }else {
                        res[r[i]+1]++;
                    }
                }
            }
            for (int i=0;i<n;i++){
                System.out.print(" "+res[i]);
            }
        }
    }

}
