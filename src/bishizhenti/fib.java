package bishizhenti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fib {
    //给出一个整数 n，请输出斐波那契数列的第 n 项对 1e9 + 7 取模的值。
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = input.readLine();
            String[] inputLine = str.split(" ");
            long m =  Long.parseLong(inputLine[0]);
            System.out.println(fib(m));
        }

    }
    public static long fib(long n) {
        if (n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        long[][] base = {{1, 1}, {1, 0}};
        long[][] res = matrixPower(base, n - 2);
        return (res[0][0] + res[1][0]) % 1000000007;
    }

    public static long[][] matrixPower(long[][] m, long p) {
        long[][] res = new long[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        long[][] tmp = m;
        //快速幂
        while (p != 0) {
            if ((p & 1) != 0) { //p & 1取p的二进制数的最末位
                res = multMatrix(res, tmp);
            }
            tmp = multMatrix(tmp, tmp);
            p >>= 1;
        }
        return res;
    }

    private static long[][] multMatrix(long[][] m1, long[][] m2) {
        long[][] res = new long[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                    res[i][j] = res[i][j] % 1000000007;
                }
            }
        }
        return res;
    }
    //f(n)   = f(n-1) + f(n-2)
    //f(n-1) = f(n-1)
    //
    //矩阵：
    //
    //[ f(n)   ] = [ 1*f(n-1) + 1*f(n-2) ] = [ 1 1 ] * [ f(n-1) ]
    //[ f(n-1) ]   [ 1*f(n-1) + 0*f(n-2) ]   [ 1 0 ]   [ f(n-2) ]
    //
    //显然：
    //    [ f(2) ] = [ 1 ]
    //    [ f(1) ]   [ 1 ]
    //
    //假设：
    //    mul = [ 1 1 ]
    //          [ 1 0 ]
    //
    //那么：
    //    [ f(n)   ] = mul * [ f(n-1) ] = mul * mul * [ f(n-2) ] = ... = mul^(n-2) * [ f(2) ]
    //    [ f(n-1) ]         [ f(n-2) ]               [ f(n-3) ]                     [ f(1) ]
    //
    //转变为快速幂问题：
    //    快速求 mul^(n-2) 的值即可
}
