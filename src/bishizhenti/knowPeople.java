package bishizhenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class knowPeople {
    //小A参加了一个n人的活动，每个人都有一个唯一编号i(i>=0 & i<n)，其中m对相互认识，
    // 在活动中两个人可以通过互相都认识的一个人介绍认识。现在问活动结束后，小A最多会认识多少人？
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 聚会的人数；
        int ai = Integer.parseInt(br.readLine());// 小A的编号
        int m = Integer.parseInt(br.readLine());// 相互认识的人数
        int[] x = new int[m];//人员编号
        int[] y = new int[m];
        for (int i = 0; i < m; i++) {
            String[] str = br.readLine().split(",");
            x[i] = Integer.parseInt(str[0]);
            y[i] = Integer.parseInt(str[1]);
        }
        Map<Integer, List<Integer>> map = new HashMap();//用来表示图的临接表
        Map<Integer, Integer> flag = new HashMap();//标志位，用来判定是否遍历过
        for (int i = 0; i < m; i++) {
            if (!flag.containsKey(x[i]))
                flag.put(x[i], 0);
            if (!flag.containsKey(y[i]))
                flag.put(y[i], 0);
        }
        for (int i = 0; i < m; i++) {//构建图的临接表
            if (map.containsKey(x[i]))
                map.get(x[i]).add(y[i]);
            else {
                List<Integer> list = new ArrayList();
                list.add(y[i]);
                map.put(x[i], list);
            }
            if (map.containsKey(y[i]))
                map.get(y[i]).add(x[i]);
            else {
                List<Integer> list = new ArrayList();
                list.add(x[i]);
                map.put(y[i], list);
            }

        }

        Queue<Integer> queue = new LinkedList();
        queue.offer(ai);
        List<Integer> res = new ArrayList();
        while (!queue.isEmpty()) {
            int tag = queue.poll();
            List<Integer> temp = map.get(tag);
            for(int i=0;i<temp.size();i++){
                if(flag.get(temp.get(i))==0) {
                    flag.replace(temp.get(i), 1);
                    queue.offer(temp.get(i));
                    res.add(temp.get(i));
                }
            }
        }
        int r = res.size() - map.get(ai).size() - 1;//减去本来就认识的人和自己
        System.out.println(r);

    }
}
