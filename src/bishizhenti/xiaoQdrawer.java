package bishizhenti;
import java.util.Scanner;

public class xiaoQdrawer {
    //小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用'X'表示。
    //每次小Q会选择一条斜线, 如果斜线的方向形如'/',即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;
    // 如果对角线的方向形如'\',即斜率为-1,小Q会选择这条斜线中的一段格子,都涂画为黄色,用'Y'表示。
    //如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用'G'表示。
    //小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char color[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String tem = scanner.next();
            for (int j = 0; j < tem.length(); j++) {
                color[i][j] = tem.charAt(j);
            }
        }
        // 获取最小步数
        getMinStep(n, m, color);
    }

    private static void getMinStep(int n, int m, char color[][]) {
        int step = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (color[i][j] == 'Y') {
                    dfs_y(i, j, n, m, color); // 画y
                    step++;
                } else if (color[i][j] == 'B') {
                    dfs_b(i, j, n, m, color); // 画B
                    step++;
                } else if (color[i][j] == 'G') {
                    dfs_y(i, j, n, m, color); // 先画y
                    step++;
                    dfs_b(i, j, n, m, color); // 在画B
                    step++;
                }
            }
        }

        System.out.println(step);
    }

    private static void dfs_y(int x, int y, int n, int m, char color[][]) {
        // 根据要求决定当前位置是否能画y
        if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'Y' || color[x][y] == 'G')) {
            if (color[x][y] == 'G') {
                color[x][y] = 'B'; // 如果当前位置要求画的是G,那么画了Y之后下一次只能画B
            } else {
                color[x][y] = 'X'; // 如果当前位置要求画的是Y,那么画了Y之后下一次不需要再画
            }

            // 是否连笔继续画，Y对应的是画\，即左上或者右下
            dfs_y(x - 1, y - 1, n, m, color);
            dfs_y(x + 1, y + 1, n, m, color);

        }

    }

    private static void dfs_b(int x, int y, int n, int m, char color[][]) {
        // 根据要求决定当前位置是否能画B
        if (x >= 0 && x < n && y >= 0 && y < m && (color[x][y] == 'B' || color[x][y] == 'G')) {
            if (color[x][y] == 'G') {
                color[x][y] = 'Y'; // 如果当前位置要求画的是G,那么画了Y之后下一次只能画Y
            } else {
                color[x][y] = 'X'; // 如果当前位置要求画的是B,那么画了B之后下一次不需要再画
            }

            // 是否连笔继续画，B对应的是画/，即左下或者右上
            dfs_b(x + 1, y - 1, n, m, color);
            dfs_b(x - 1, y + 1, n, m, color);
        }
    }

}
