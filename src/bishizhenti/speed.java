package bishizhenti;

import java.util.*;

public class speed {
    public static void main(String[] args) {
        //n个加速带，每个加速带有加速度a，加速时间t，求最大移动距离

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] t = new int[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
                t[i] = sc.nextInt();
            }
            double res = getDist(a,t);
            System.out.println(String.format("%.1f", res));

        }
    }
    public static double getDist(int[] a, int[] t){
        int curSpeed = 0;
        double curDist = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<a.length;i++){
            map.put(a[i],t[i]);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int v1 = o1.getKey()*o1.getValue();
                int v2 = o2.getKey()*o2.getValue();
                int res=0;
                if (v1>v2){
                    res = -1;
                }else if (v1<v2){
                    res = 1;
                }else {
                    if (o1.getKey()>o2.getKey()){
                        res = -1;
                    }
                }
                return res;
            }
        });
        for (Map.Entry<Integer,Integer> mapping:list){
            curDist = curDist+curSpeed*mapping.getValue()+0.5*mapping.getKey()*mapping.getValue()*mapping.getValue();
            curSpeed = curSpeed + mapping.getKey()*mapping.getValue();
        }
        return curDist;
    }
}
