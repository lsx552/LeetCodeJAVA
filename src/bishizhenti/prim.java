package bishizhenti;

public class prim {
    //最小生成树
    //自己到自己的距离设为-1，已经联通的距离设为0
    //U表示已经为最小生成树的顶点集合，V表示还未加入的顶点
    static int MAX = Integer.MAX_VALUE;
    public static void prim(int[][] graph, int n){
        int[] lowcost = new int[n];//U中的点到V中的点的最小花费，-1表示已经加入U
        int[] mst = new int[n];//mst[i]=j连接i的上一个节点为j
        int i, j, min, minid, sum = 0;

        for(i = 1; i < n; i++){
            lowcost[i] = graph[0][i];
            mst[i] = 0;
        }

        for(i = 1; i < n; i++){
            min = MAX;
            minid = 0;
            for(j = 1; j < n; j++){
                if (lowcost[j] < min && lowcost[j] != -1) {
                    min = lowcost[j];
                    minid = j;
                }
            }
            System.out.println((mst[minid]+1) + "到" + (minid+1) + " 权值：" + min);

            sum += min;
            lowcost[minid] = -1;

            for (j = 1; j < n; j++) {
                if (graph[minid][j] < lowcost[j]) {
                    lowcost[j] = graph[minid][j];
                    mst[j] = minid;
                }
            }
        }

        System.out.println("sum:" + sum);

    }
    public static void main(String [] args) {
        int[][] tree = new int[][]{
                {-1,0,0,6,MAX},
                {0,-1,10,MAX,MAX},
                {0,10,-1,MAX,2},
                {6,MAX,MAX,-1,0},
                {MAX,MAX,2,0,-1},

        };
        prim(tree, 5);
    }
}
