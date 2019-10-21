package leetcode;

public class NumIslands_200 {
    //给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
    // 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
    // 你可以假设网格的四个边均被水包围。

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands += dfs(grid, i, j);
                }
            }
        }

        return numberOfIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        return 1;
    }
    public static void main(String[] args) {
        NumIslands_200 island = new NumIslands_200();
        char[][] grig = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}
                         };
        char[][] grig2 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}
                          };
        int num = island.numIslands(grig2);

        System.out.print(num);
        }
    }

