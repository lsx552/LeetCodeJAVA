package bishizhenti;

import java.util.HashMap;
import java.util.Scanner;

public class BusSchedule {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String schedule = sc.nextLine();
        int n = schedule.length();
        if(n==0) {
            System.out.println(0);
        } else{
            HashMap<Character,Integer> end_pos = new HashMap<>();//记录字符的最远结束位置
            for(int i = 0; i<n; i++){
                end_pos.put(schedule.charAt(i),i);
            }
            int start=0;// 起始下标
            String res="";
            while(start<schedule.length()) {
                int end= start;
                int k =end;
                while(k<=end){
                    end = Math.max(end_pos.get(schedule.charAt(k)),end);
                    k++;
                }
                res += String.valueOf(end-start+1)+" ";
                start = end+1;
            }
            res = res.trim();
            System.out.println(res);
        }
    }
}
