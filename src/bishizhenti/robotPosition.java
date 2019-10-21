package bishizhenti;

import java.util.*;
class robot{
    int x;
    int y;
    String fangxiang;
    public robot(int x,int y,String fangxiang){
        this.x = x;
        this.y = y;
        this.fangxiang = fangxiang;
    }
}

public class robotPosition {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            int k = sc.nextInt();
            int w = sc.nextInt();
            String ops = sc.next();
            String opStr = "";
            for (int i=0;i<k;i++){
                opStr +=ops;
            }
            Map<Integer, List<Integer>> zhangai = new HashMap<>();
            for (int i=0;i<w;i++){
                int z_x = sc.nextInt();
                int z_y = sc.nextInt();
                if (!zhangai.containsKey(z_x)){
                    List<Integer> list = new ArrayList<>();
                    list.add(z_y);
                    zhangai.put(z_x,list);
                }else {
                    List<Integer> list = zhangai.get(z_x);
                    list.add(z_y);
                }
            }
            robot bot = new robot(0,0,"up");
            for (int i=0;i<opStr.length();i++){
                bot = getPos(bot,opStr.charAt(i), (HashMap<Integer, List<Integer>>) zhangai);
            }
            System.out.print(bot.x+" "+bot.y);
        }
    }
    public static robot getPos(robot cur,char op,HashMap<Integer,List<Integer>> zhangai){
        if (op=='1'){
            if (cur.fangxiang=="up"){
                cur.fangxiang ="left";
            }else if (cur.fangxiang=="left"){
                cur.fangxiang="down";
            }else if (cur.fangxiang=="down"){
                cur.fangxiang="right";
            }else if (cur.fangxiang=="right"){
                cur.fangxiang="up";
            }
        }else if (op=='2'){
            if (cur.fangxiang=="up"){
                cur.fangxiang ="right";
            }else if (cur.fangxiang=="left"){
                cur.fangxiang="up";
            }else if (cur.fangxiang=="down"){
                cur.fangxiang="left";
            }else if (cur.fangxiang=="right"){
                cur.fangxiang="down";
            }
        }else if (op=='3'){
            if (cur.fangxiang=="up"){
                cur.fangxiang ="down";
            }else if (cur.fangxiang=="left"){
                cur.fangxiang="right";
            }else if (cur.fangxiang=="down"){
                cur.fangxiang="up";
            }else if (cur.fangxiang=="right"){
                cur.fangxiang="left";
            }
        }else if (op=='4'){
            if (cur.fangxiang=="up"){
                if (!hasZhangai(cur.x,cur.y+1,zhangai)&&!isBorder(cur.x,cur.y+1))
                    cur.y++;
            }else if (cur.fangxiang=="left"){
                if (!hasZhangai(cur.x-1,cur.y,zhangai)&&!isBorder(cur.x-1,cur.y))
                    cur.x--;
            }else if (cur.fangxiang=="down"){
                if (!hasZhangai(cur.x,cur.y-1,zhangai)&&!isBorder(cur.x,cur.y-1))
                    cur.y--;
            }else if (cur.fangxiang=="right"){
                if (!hasZhangai(cur.x+1,cur.y,zhangai)&&!isBorder(cur.x+1,cur.y))
                    cur.x++;
            }
        }else if (op=='5'){
            if (cur.fangxiang=="up"){
                if (!hasZhangai(cur.x,cur.y-1,zhangai)&&!isBorder(cur.x,cur.y-1))
                    cur.y--;
            }else if (cur.fangxiang=="left"){
                if (!hasZhangai(cur.x+1,cur.y,zhangai)&&!isBorder(cur.x+1,cur.y))
                    cur.x++;
            }else if (cur.fangxiang=="down"){
                if (!hasZhangai(cur.x,cur.y+1,zhangai)&&!isBorder(cur.x,cur.y+1))
                    cur.y++;
            }else if (cur.fangxiang=="right"){
                if (!hasZhangai(cur.x-1,cur.y,zhangai)&&!isBorder(cur.x-1,cur.y))
                    cur.x--;
            }
        }else if (op=='6'){
            if (cur.fangxiang=="up"){
                if (!hasZhangai(cur.x-1,cur.y,zhangai)&&!isBorder(cur.x-1,cur.y))
                    cur.x--;
            }else if (cur.fangxiang=="left"){
                if (!hasZhangai(cur.x,cur.y-1,zhangai)&&!isBorder(cur.x,cur.y-1))
                    cur.y--;
            }else if (cur.fangxiang=="down"){
                if (!hasZhangai(cur.x+1,cur.y,zhangai)&&!isBorder(cur.x+1,cur.y))
                    cur.x++;
            }else if (cur.fangxiang=="right"){
                if (!hasZhangai(cur.x,cur.y+1,zhangai)&&!isBorder(cur.x,cur.y+1))
                    cur.y++;
            }
        }else if (op=='7'){
            if (cur.fangxiang=="up"){
                if (!hasZhangai(cur.x+1,cur.y,zhangai)&&!isBorder(cur.x+1,cur.y))
                    cur.x++;
            }else if (cur.fangxiang=="left"){
                if (!hasZhangai(cur.x,cur.y+1,zhangai)&&!isBorder(cur.x,cur.y+1))
                    cur.y++;
            }else if (cur.fangxiang=="down"){
                if (!hasZhangai(cur.x-1,cur.y,zhangai)&&!isBorder(cur.x-1,cur.y))
                    cur.x--;
            }else if (cur.fangxiang=="right"){
                if (!hasZhangai(cur.x,cur.y-1,zhangai)&&!isBorder(cur.x,cur.y-1))
                    cur.y--;
            }
        }
        return cur;
    }
    public static boolean hasZhangai(int x,int y,HashMap<Integer,List<Integer>> zhangai){
        boolean res=false;
        if (!zhangai.containsKey(x)){
            res = false;
        }else {
            List<Integer> list = zhangai.get(x);
            for (int i=0;i<list.size();i++){
                if (y==list.get(i)){
                    res = true;
                    break;
                }
            }
        }
        return res;
    }
    public static boolean isBorder(int x,int y){
        boolean res = false;
        if (x<0||x>n)
            res = true;
        if (y<0||y>m)
            res =true;
        return res;
    }
}
