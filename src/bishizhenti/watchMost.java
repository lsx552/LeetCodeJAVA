package bishizhenti;

import java.util.*;

public class watchMost {
    public static void main(String[] args) {
        //输入 from 视频A to 视频B
        //输出观看次数最多的视频
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i=0;i<n;i++){
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                if(!map.containsKey(start[i])){
                    map.put(start[i],1);
                }else {
                    map.put(start[i],map.get(start[i])+1);
                }
            }

            for (int i=0;i<n;i++){
                Stack<Integer> stack = new Stack<>();
                stack.add(end[i]);
                int temp =1;
                while (!stack.isEmpty()){
                    int flag = stack.pop();
                    for (int j=0;j<n;j++){
                        if(start[j]==flag){
                            stack.add(end[j]);
                            temp+=1;
                        }
                    }
                }
                map.put(start[i],map.get(start[i])+temp);
            }

            List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
            Collections.sort(list, (o1, o2) -> (o2.getValue() - o1.getValue()));
            System.out.println(list.get(0).getKey());
        }
    }
}
