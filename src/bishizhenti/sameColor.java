package bishizhenti;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sameColor {
    //每个人都有颜色，其中一些会告诉你还有多少其他人和自己同色。
    //推断最少有多少人
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str =br.readLine();
            List<Integer> list = new ArrayList<>();
            String[] strArr = str.split(",");
            for(int i=0;i<strArr.length;i++){
                list.add(Integer.parseInt(strArr[i]));
            }
            int res = 0;
            res = count(list);
            System.out.println(res);
        }

    }
    public static int count(List<Integer> nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();i++){
            if(!map.containsKey(nums.get(i))){
                map.put(nums.get(i),1);
            }else {
                map.put(nums.get(i),map.get(nums.get(i))+1);
            }
        }
        int res=0;
        for(Integer key:map.keySet()){
            int count = map.get(key);
            int yushu = (count-1)/(key+1);
            res += (key+1)*(yushu+1);
        }
        return res;
    }
}
