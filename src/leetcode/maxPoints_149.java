package leetcode;

import java.util.HashMap;
import java.util.Map;

public class maxPoints_149 {
    public static void main(String[] args) {
        int[][] points= {{1,1},{1,2},{1,3}};
        System.out.println(maxPoint(points));
    }
    public static int maxPoint(int[][] points){
        int n = points.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<String, Integer> slope = new HashMap<>();
            int repeat = 0;
            int tmp_max = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if (dy == 0 && dx == 0) {
                    repeat++;
                    continue;
                }
                int g = gcd(dy, dx);
                if (g != 0) {
                    dy /= g;
                    dx /= g;
                }
                String tmp = String.valueOf(dy) + "/" + String.valueOf(dx);
                slope.put(tmp, slope.getOrDefault(tmp, 0) + 1);
                tmp_max = Math.max(tmp_max, slope.get(tmp));
            }
            res = Math.max(res, repeat + tmp_max + 1);
        }
        return res;

    }
    public static int gcd(int dy, int dx) {
        if (dx == 0) return dy;
        else return gcd(dx, dy % dx);

    }

}
