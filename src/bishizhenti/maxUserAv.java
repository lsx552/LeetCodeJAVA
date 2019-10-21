package bishizhenti;

import java.util.*;

public class maxUserAv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0;i<n;i++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(start[i])){
                map.put(start[i],map.get(start[i])+1);
            }else {
                map.put(start[i],1);
            }
        }
        for (int i=0;i<n;i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(end[i]);
            int temp =1;
            while (!queue.isEmpty()){
                int flag = queue.poll();
                for (int j=0;j<n;j++){
                    if(start[j]==flag){
                        queue.offer(end[j]);
                        temp += 1;
                    }
                }
            }
            map.put(start[i],map.get(start[i])+temp);
        }
        System.out.println("res");
    }

}
